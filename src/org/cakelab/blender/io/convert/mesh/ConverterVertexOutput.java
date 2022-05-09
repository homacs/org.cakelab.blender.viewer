package org.cakelab.blender.io.convert.mesh;

import java.io.IOException;

import org.blender.dna.MLoop;
import org.blender.dna.MLoopUV;
import org.blender.dna.MVert;
import org.cakelab.blender.io.convert.CoordinateSystemConverter;
import org.cakelab.blender.nio.CArrayFacade;
import org.cakelab.util.types.ArrayListFloat;
import org.cakelab.util.types.ArrayListInt;
import org.joml.Vector3f;

class ConverterVertexOutput extends ArrayListFloat implements VertexOutput {
	private Polygon poly;
	private Vector3f normal;
	private MVert[] vertices;
	private MLoop[] loops;
	private MLoopUV[] loopsuv;
	private boolean withUV;
	private boolean withNormals;
	private ArrayListInt vertexIds;
	private AdjacencyMap adjacentPolies;
	private int sliceLength;
	private final CoordinateSystemConverter converter;

	public ConverterVertexOutput(CoordinateSystemConverter converter) {
		super(1024);
		this.converter = converter;
	}

	public void init(MVert[] vertices, MLoop[] loops, MLoopUV[] loopsuv, 
			boolean withUV, boolean withNormals, ArrayListInt vertexIds, AdjacencyMap adjacentPolies,
			int sliceLength) {
		clear();
		this.vertices = vertices;
		this.loops = loops;
		this.loopsuv = loopsuv;
		this.withUV = withUV;
		this.withNormals = withNormals;
		this.vertexIds = vertexIds;
		this.adjacentPolies = adjacentPolies;
		this.sliceLength = sliceLength;
	}
	
	public void setPolygon(Polygon poly) {
		if (withNormals) {
			this.poly = poly;
			this.normal = poly.normal;
		}
	}
	
	@Override
	public void put(int loopid) throws IOException {

		int vertexId = loops[loopid].getV();
		if (withNormals) {
			vertexIds.add(vertexId);
			adjacentPolies.add(vertexId, poly);
		}
		
		int destPos = size();
		capacity(size() + sliceLength);
		float[] dest = data();

		// add converted vertex coords
		MVert v = vertices[vertexId];
		CArrayFacade<Float> co = v.getCo();
		int len = co.length();
		co.toArray(dest, destPos, len);
		converter.convertVector(dest, destPos, len);
		destPos += len;
		
		if (withUV) {
			// copy uv coords
			MLoopUV loopuv = loopsuv[loopid];
			
			CArrayFacade<Float> uv = loopuv.getUv();
			len = uv.length();
			uv.toArray(dest, destPos, len);
			destPos += len;
		}

		if (withNormals) {
			// copy prepared normal vector coords of polygon (default)
			dest[destPos++] = normal.x;
			dest[destPos++] = normal.y;
			dest[destPos++] = normal.z;
		}

		size(destPos);
		
	}

}
