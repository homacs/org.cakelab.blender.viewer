package org.cakelab.blender.io.convert.mesh;

import static org.blender.dna.constants.mesh.Constants.ME_SMOOTH;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blender.dna.MLoop;
import org.blender.dna.MLoopUV;
import org.blender.dna.MPoly;
import org.blender.dna.MVert;
import org.blender.dna.Mesh;
import org.cakelab.blender.io.convert.CoordinateSystemConverter;
import org.cakelab.blender.nio.CArrayFacade;
import org.cakelab.soapbox.model.Mesh.FrontFaceVertexOrder;
import org.cakelab.soapbox.model.TriangleMesh;
import org.cakelab.util.types.ArrayListInt;
import org.joml.Vector3f;

public class MeshConverter {

	/** vector components per vector */
	private static final int COORDS_SIZE = 3;
	
	/** vector components per UV coordinate */
	private static final int UVCOORDS_SIZE = 2;
	
	/** vector components per normal vector */
	private static final int NORMAL_SIZE = COORDS_SIZE;

	private final CoordinateSystemConverter converter;
	private final Triangulator triangulator = new Triangulator();
	private final BlenderVertexInput in;
	private final ConverterVertexOutput out;
	
	private MVert[] vertices;
	private MPoly[] polies;
	private MLoop[] loops;
	
	private boolean withNormals;
	
	private int sliceLength;
	private int uvOffset;
	private int normalOffset;

	// stuff required to calculate normal vectors for smooth shading
	private final Map<MPoly, Polygon> polygons = new HashMap<>();
	private final AdjacencyMap adjacentPolies = new AdjacencyMap();
	private final Map<Integer, Vector3f> averagedNormals = new HashMap<Integer, Vector3f>();
	private final ArrayListInt vertexIds = new ArrayListInt();
	
	public MeshConverter(CoordinateSystemConverter converter) {
		this.converter = converter;
		this.in = new BlenderVertexInput();
		this.out = new ConverterVertexOutput(converter);
	}
	
	public TriangleMesh createTriangleMesh(Mesh mesh, boolean withUv, boolean withNormals, boolean smooth) throws IOException {
		setup(mesh, withUv, withNormals);
		return process(smooth);
	}

	private void setup(Mesh mesh, boolean withUv, boolean withNormals) throws IOException {
		this.withNormals = withNormals;
		int totpolies = mesh.getTotpoly();
		vertices = mesh.getMvert().toArray(mesh.getTotvert());
		polies = mesh.getMpoly().toArray(totpolies);
		loops = mesh.getMloop().toArray(mesh.getTotloop());
		MLoopUV[] loopsuv = withUv ? mesh.getMloopuv().toArray(mesh.getTotloop()) : null;
		boolean withUV = (loopsuv != null && loopsuv.length != 0);

		setupSliceOffsets(withUV, withNormals);
		
		polygons.clear();
		adjacentPolies.init(vertices.length);
		vertexIds.clear();
		averagedNormals.clear();
		
		in.init();
		out.init(vertices, loops, loopsuv, withUV, withNormals, vertexIds, adjacentPolies, sliceLength);
	}

	private void setupSliceOffsets(boolean withUV, boolean withNormals) {
		// for each polygon N vertices with at least 3 coords for xyz
		sliceLength = COORDS_SIZE;
		uvOffset = 0;
		normalOffset = 0;
		if (withUV) {
			uvOffset = sliceLength;
			// and 2 coords for uv map, if available
			sliceLength += UVCOORDS_SIZE;
		}
		if (withNormals) {
			normalOffset = sliceLength;
			// and 3 coords for the normal vector if available
			sliceLength += NORMAL_SIZE;
		}
	}

	private TriangleMesh process(boolean smooth) throws IOException {

		List<MPoly> smoothPolies = new ArrayList<>();
		
		// for each polygon
		for (MPoly poly : polies) {
			// for each vertex of a face (loop)
			boolean poly_smooth = smooth || (poly.getFlag() & ME_SMOOTH) != 0;
			int loopStart = poly.getLoopstart();
			int nvertices = poly.getTotloop();
			Vector3f normal = null;
			Polygon polygon = null;
			if (withNormals) {
				if (poly_smooth) smoothPolies.add(poly);
				normal = calcNormal(loopStart);
				converter.convertVector(normal);
				normal.normalize();
				polygon = registerPolygon(poly, out.size(), vertexIds.size(), normal);
			}
			in.setPolygon(poly);
			out.setPolygon(polygon);
			
			if (nvertices < 3) {
				throw new IllegalArgumentException("unexpected: polygon with less than 3 vertices!");
			} else if (nvertices == 3) {
				// loop is a triangle
				outputVertices(in, out, nvertices);
			} else {
				// loop is polygon with nvertices >= 4
				triangulator.triangulate(in, out, nvertices);
			}
		}
		if (withNormals) {
			updateSmoothNormalVectors(smoothPolies);
		}
		return new TriangleMesh(FrontFaceVertexOrder.CounterClockwise, sliceLength, out.data(), uvOffset, normalOffset, out.size());
	}
	
	private void outputVertices(VertexInput in, VertexOutput out, int nvertices) throws IOException {
		for (int l = 0; l < nvertices; l++) {
			out.put(in.getVertexId(l));
		}
	}
	
	private Polygon registerPolygon(MPoly poly, int coordsStart, int vertexIdsStart, Vector3f normal) throws IOException {
		assert (vertexIdsStart == coordsStart/sliceLength);
		int numVertices = poly.getTotloop();
		if (numVertices > 3) {
			// Number of triangles after triangulation:
			int numTriangles = numVertices - 2;
			numVertices = numTriangles * 3;
		}
		Polygon polygon = new Polygon(coordsStart, vertexIdsStart, numVertices, sliceLength, normal);
		polygons.put(poly, polygon);
		return polygon;
	}

	private void updateSmoothNormalVectors(List<MPoly> smoothPolies) throws IOException {
		for (MPoly bPoly : smoothPolies) {
			Polygon poly = polygons.get(bPoly);
			assert (poly.vertexIdsStart == poly.coordsStart/sliceLength);
			
			for (int v = 0; v < poly.numVertices; v++) {
				int vertexId = vertexIds.get(poly.vertexIdsStart + v);
				Vector3f normal = getAveragedNormalVector(vertexId);
				int off = poly.coordsStart + v * sliceLength + normalOffset;
				float[] data = out.data();
				data[off + 0] = normal.x;
				data[off + 1] = normal.y;
				data[off + 2] = normal.z;
			}
		}
	}
	
	private Vector3f getAveragedNormalVector(int vertexId) {
		Vector3f normal = averagedNormals.get(vertexId);
		if (normal != null) 
			return normal;

		normal = calcAveragedNormalVector(adjacentPolies.get(vertexId));
		averagedNormals.put(vertexId, normal);
		return normal;
	}

	private Vector3f calcAveragedNormalVector(Set<Polygon> polies) {
		Vector3f normal = new Vector3f();
		for (Polygon poly : polies) {
			Vector3f n = poly.normal;
			normal.add(n);
		}
		return normal.normalize();
	}

	/** calculate normal vector of a planar face starting at loopStart */
	private Vector3f calcNormal(int loopStart) throws IOException {
		// calculating the normal of the polygon using the first 3 vertices 
		// of the planar face:
		//			vec3 ab = b - a;
		//          vec3 ac = c - a;
		//          vec3 normal = normalize(cross(ab, ac));
		MLoop loop = loops[loopStart + 0];
		CArrayFacade<Float> a = vertices[loop.getV()].getCo();
		loop = loops[loopStart + 1];
		CArrayFacade<Float> b = vertices[loop.getV()].getCo();
		loop = loops[loopStart + 2];
		CArrayFacade<Float> c = vertices[loop.getV()].getCo();
		
		Vector3f ab = new Vector3f(b.get(0)-a.get(0), b.get(1)-a.get(1), b.get(2)-a.get(2));
		Vector3f ac = new Vector3f(c.get(0)-a.get(0), c.get(1)-a.get(1), c.get(2)-a.get(2));
		
		return ab.cross(ac);
	}

}
