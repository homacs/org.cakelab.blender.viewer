package org.cakelab.blender.io;

import static org.blender.dna.constants.object.Constants.*;
import static org.blender.dna.constants.mesh.Constants.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.blender.dna.Base;
import org.blender.dna.BlenderObject;
import org.blender.dna.Camera;
import org.blender.dna.Image;
import org.blender.dna.ImagePackedFile;
import org.blender.dna.Lamp;
import org.blender.dna.MLoop;
import org.blender.dna.MLoopUV;
import org.blender.dna.MPoly;
import org.blender.dna.MTex;
import org.blender.dna.MVert;
import org.blender.dna.Material;
import org.blender.dna.Mesh;
import org.blender.dna.PackedFile;
import org.blender.dna.Scene;
import org.blender.dna.Tex;
import org.blender.utils.MainLib;
import org.cakelab.blender.nio.CArrayFacade;
import org.cakelab.blender.nio.CPointer;
import org.cakelab.blender.utils.BlenderSceneIterator;
import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.scene.VisualMeshObject;
import org.cakelab.oge.scene.VisualObject;
import org.cakelab.soapbox.model.Mesh.FrontFaceVertexOrder;
import org.cakelab.soapbox.model.QuadMesh;
import org.cakelab.soapbox.model.TriangleMesh;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

public class BlenderIO {

	private static final short TYPE_MESH = 1;
	private MainLib main;
	private ArrayList<org.cakelab.oge.Camera> cameras = new ArrayList<org.cakelab.oge.Camera>();
	private File file;
	
	
	public BlenderIO(File file) throws IOException {
		this.file = file;
		//
		// read data from file into heap memory
		//
		BlenderFile f = new BlenderFile(file);
		if (!MainLib.doVersionCheck(f.readFileGlobal())) {
			System.err.println("Warning: Blender file version not supported. Expect missing data and/or I/O errors");
		}
		main = new MainLib(f);
		f.close();
	}
	
	public ArrayList<org.cakelab.oge.Camera> getCameras() {
		return cameras;
	}

	public org.cakelab.oge.scene.Scene loadScene() throws IOException {
		org.cakelab.oge.scene.Scene scene = new org.cakelab.oge.scene.Scene();
		Scene bscene = main.getScene();
		BlenderSceneIterator base_it = new BlenderSceneIterator(bscene);
		while (base_it.hasNext()) {
			Base base = base_it.next();
			BlenderObject ob = base.getObject().get();
			
			switch (ob.getType()) {
			case OB_CAMERA:
				cameras.add(loadCamera(ob));
				break;
			case OB_LAMP:
				scene.addLightSource(loadLamp(ob));
				break;
			case OB_MESH:
				scene.add(loadMesh(ob));
				break;
				// TODO etc
			}
		}
		return scene;
	}
	
	private org.cakelab.oge.scene.LightSource loadLamp(BlenderObject ob) throws IOException {
		Lamp l = ob.getData().cast(Lamp.class).get();
		Vector3f rgb = new Vector3f(l.getR(), l.getG(), l.getB());
		org.cakelab.oge.scene.LightSource lamp = new org.cakelab.oge.scene.LightSource(rgb);
		setPose(lamp, ob);
		return lamp;
	}

	private org.cakelab.oge.Camera loadCamera(BlenderObject ob) throws IOException {
		// TODO: camera pose seems wrong
		Camera cam = ob.getData().cast(Camera.class).get();
		org.cakelab.oge.Camera camera = new org.cakelab.oge.Camera(0, 0, 0, 0, 0, 0);
		camera.setFoV(cam.getLens());
		setPose(camera, ob);
		return camera;
	}

	private void setPose(org.cakelab.oge.scene.Pose camera, BlenderObject ob) throws IOException {
		float[] tmp = new float[3];
		ob.getLoc().toArray(tmp, 0, 3);
		convertVector(tmp, 0);
		camera.setX(tmp[0]);
		camera.setY(tmp[1]);
		camera.setZ(tmp[2]);
		
		ob.getRot().toArray(tmp, 0, 3);
		convertRotation(tmp, 0);
		float pitch = (float) Math.toDegrees(tmp[0]);
		float yaw = (float) Math.toDegrees(tmp[1]);
		float roll = (float) Math.toDegrees(tmp[2]);
		camera.setRotation(pitch, yaw, roll);
		
	}

	private VisualObject loadMesh(BlenderObject ob) throws IOException {
		Mesh mesh = ob.getData().cast(Mesh.class).get();
		VisualObject object = createObject(mesh);
		setPose(object, ob);
		return object;
	}

	
	public VisualObject loadFirstMesh() throws IOException {
		Mesh mesh = main.getMesh();
		
		//
		// Convert mesh and texture into opengl suitable format
		//
		return createObject(mesh);
	}
	
	
	/**
	 * Retrieve the assets of a specific object with name objectName.
	 * @param filename Blender file
	 * @param objectName Name of the object to load
	 * @throws IOException 
	 */
	public VisualObject loadObject(String objectName) throws IOException {
		Scene scene = main.getScene();
		BlenderSceneIterator base_it = new BlenderSceneIterator(scene);
		while (base_it.hasNext()) {
			Base base = base_it.next();
			BlenderObject o = base.getObject().get();
			String name = o.getId().getName().asString();
			if (name.equals("OB" + objectName)) {
				if (o.getType() == TYPE_MESH) {
					Mesh mesh = o.getData().cast(Mesh.class).get();
					return createObject(mesh);
				}
			}
		}
		throw new IOException("Object '" + objectName + "' not found");
	}

	
	
	
	private VisualObject createObject(Mesh mesh) throws IOException {
		TriangleMesh triangles;
		boolean withNormals = true;
		// TODO get smooth from material (maybe something to be decided by the renderer)
		boolean smooth = false;
		//
		// retrieve texture(s) from material
		//
		org.cakelab.oge.scene.Material material = getMaterial(mesh);
		if (material.hasTextures()) {
			//
			// get polygons with associated uv coordinates
			//
			triangles = createTriangleMesh(mesh, true, withNormals, smooth);

		} else {
			triangles = createTriangleMesh(mesh, false, withNormals, smooth);
		}
		return new VisualMeshObject(triangles, material);
	}

	
	private org.cakelab.oge.scene.Material getMaterial(Mesh mesh) throws IOException {
		Vector4f basecolor = new Vector4f(0,0,0,1);
		TextureImage texture = null;
		float emitter_intensity = 0f;
		
		short totcol = mesh.getTotcol();
		if (totcol > 1) {
			// TODO: consider multiple materials
			throw new IOException("mesh with multiple materials not supported");
		}
		CPointer<Material> pmat = mesh.getMat().get();
		if (pmat.isValid()) {
			Material mat = pmat.get();
			/*
			 * we interpret the colour of the material as base colour
			 * of the object which is mixed with the texture (if present)
			 * based on the textures alpha channel.
			 */
			basecolor.x = mat.getR();
			basecolor.y = mat.getG();
			basecolor.z = mat.getB();
			basecolor.w = mat.getAlpha();
			
			CArrayFacade<CPointer<MTex>> mtexs = mat.getMtex();
			
			emitter_intensity = mat.getEmit();
			
//			if (mtexs.length() > 1) {
//				// TODO: consider multiple textures
//				throw new IOException("material with multiple textures not supported");
//			}
			
			for (CPointer<MTex> pmtex : mtexs) {
				if (!pmtex.isNull()) {
					Tex tex = pmtex.get().getTex().get();
					BufferedImage image = getTexture(tex.getIma().get());

					int pixelFormat = GL11.GL_RGBA;
					boolean flipped = true;

					texture = new TextureImage(image, pixelFormat, flipped);
					break;
				}
			}
		} else {
			System.err.println("warning: mesh without material");
		}

		return new org.cakelab.oge.scene.Material(basecolor, texture, emitter_intensity);
	}
	
	private TriangleMesh createTriangleMesh(Mesh mesh, boolean withUv, boolean withNormals, boolean smooth) throws IOException {
		int totpolies = mesh.getTotpoly();
		MVert[] vertices = mesh.getMvert().toArray(mesh.getTotvert());
		MPoly[] polies = mesh.getMpoly().toArray(totpolies);
		MLoop[] loops = mesh.getMloop().toArray(mesh.getTotloop());
		MLoopUV[] loopsuv = withUv ? mesh.getMloopuv().toArray(mesh.getTotloop()) : null;
		
		return createTriangleMesh(totpolies, vertices, polies, loops, loopsuv, withNormals, smooth);
	}

	private TriangleMesh createTriangleMesh(int totpolies, MVert[] vertices, MPoly[] polies, MLoop[] loops, MLoopUV[] loopsuv, boolean withNormals, boolean smooth) throws IOException {
		boolean withUV = (loopsuv != null && loopsuv.length != 0);
		
		final int COORDS_SIZE = 3;
		final int UV_SIZE = 2;
		final int NORMAL_SIZE = 3;
		
		// for each polygon N vertices with at least 3 coords for xyz
		int vectorSize = COORDS_SIZE;
		int uvOffset = 0;
		int normalsOffset = 0;
		if (withUV) {
			uvOffset = vectorSize;
			// and 2 coords for uv map, if available
			vectorSize += UV_SIZE;
		}
		if (withNormals) {
			normalsOffset = vectorSize;
			// and 3 coords for the normal vector if available
			vectorSize += NORMAL_SIZE;
		}
		
		// TODO: calculate actual size for N (considering conversion of quads and ngons to triangles
		int N = 8*3;
		float[] coords = new float[totpolies * N * vectorSize];

		// for each polygon
		int arrayLength = 0;
		for (int p = 0; p < totpolies; p++) {
			MPoly poly = polies[p];
			boolean poly_smooth = smooth || (poly.getFlag() & ME_SMOOTH) != 0;
			// for each vertex of a face (loop)
			int loff = poly.getLoopstart();
			int nvertices = poly.getTotloop();
			if (nvertices == 3) {
				// loop is a triangle
				arrayLength = copyVertices(coords, arrayLength, nvertices, loff, loops, loopsuv, vertices, withNormals, poly_smooth);
			} else if (nvertices == 4) {
				// loop is a quad
				float[] quad = new float[4 * vectorSize];
				copyVertices(quad, 0, nvertices, loff, loops, loopsuv, vertices, withNormals, poly_smooth);
				arrayLength = QuadMesh.convQuadToTriangles(quad, 0, coords, arrayLength, vectorSize);
			} else {
				// loop is polygon with nvertices>4
				float[] verts = new float[nvertices * vectorSize];
				copyVertices(verts, 0, nvertices, loff, loops, loopsuv, vertices, withNormals, poly_smooth);
				arrayLength = convertToTriangles(verts, 0, coords, arrayLength, vectorSize, nvertices);
			}
		}

		TriangleMesh tris = new TriangleMesh(FrontFaceVertexOrder.CounterClockwise, vectorSize, coords, uvOffset, normalsOffset, arrayLength);
		return tris;
	}
	
	private int copyVertices(float[] target, int targetPos, int nvertices, int loopStart, MLoop[] loops, MLoopUV[] loopsuv, MVert[] vertices, boolean withNormals, boolean smooth) throws IOException {
		Vector3f normal = null;
		if (withNormals) {
			// TODO clean up normal calculation (*where* and what about smooth)
			if (!smooth) {
				
				// calculating the normal for the polygon from 3 vertices:
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
				
				normal = ab.cross(ac);
				
				convertVector(normal);
				normal.normalize();
			}
		}
		
		
		for (int l = 0; l < nvertices; l++) {
			//
			// copy xyz coords
			//
			MLoop loop = loops[loopStart + l];
			MVert v = vertices[loop.getV()];

			CArrayFacade<Float> co = v.getCo();
			int len = co.length();
			co.toArray(target, targetPos, len);
			convertVector(target, targetPos);
			targetPos += len;
			
			
			if (loopsuv != null) {
				//
				// copy uv coords
				//
				MLoopUV loopuv = loopsuv[loopStart + l];
				
				CArrayFacade<Float> uv = loopuv.getUv();
				len = uv.length();
				uv.toArray(target, targetPos, len);
				targetPos += len;
			}

			if (withNormals) {
				//
				// copy calculated normal vector
				// 
				if (smooth) {
					CArrayFacade<Short> no = v.getNo();
					len = no.length();
					target[targetPos + 0] = no.get(0);
					target[targetPos + 1] = no.get(1);
					target[targetPos + 2] = no.get(2);
					convertNormal(target, targetPos);
					convertVector(target, targetPos);
					targetPos += len;
				} else {
					target[targetPos + 0] = normal.x;
					target[targetPos + 1] = normal.y;
					target[targetPos + 2] = normal.z;
					targetPos += 3;
				}				
			
			}
		}
		return targetPos;
	}


	

	private int convertToTriangles(float[] source, int srcPos, float[] target, int targetPos, int vectorSize, int nvertices) {
		// convert a polygon into a set of triangles
		// Starting with the first 3 vertices for the first triangle
		// proceed by taking the latter 2 vertices of the previous triangle and
		// add the next vertex to build another triangle.
		// XXX: This method works for concave polygons only.
		
		int i, j, k; // indices of the vertices of one particular triangle
		int front = 0, back = nvertices-1;
		int ntriangles = nvertices -2;
		
		for (int t = 0; t < ntriangles; t++) {
			if (t%2 == 0) {
				i = front;
				j = ++front;
				k = back;
			} else {
				k = back;
				j = --back;
				i = front;
			}
			
			targetPos = createTriangle(source, srcPos, i, j, k, target, targetPos, vectorSize);
			
		}
		
		return targetPos;
	}

	private int createTriangle(float[] source, int srcPos, int i, int j,
			int k, float[] target, int targetPos, int vectorSize) {
		System.arraycopy(source, srcPos +i*vectorSize, target, targetPos, vectorSize);
		targetPos += vectorSize;
		System.arraycopy(source, srcPos +j*vectorSize, target, targetPos, vectorSize);
		targetPos += vectorSize;
		System.arraycopy(source, srcPos +k*vectorSize, target, targetPos, vectorSize);
		targetPos += vectorSize;
		return targetPos;
	}

	private void convertVector(float[] array, int vectorStart) {
		float tmp = array[vectorStart + 1];
		array[vectorStart + 1] = array[vectorStart + 2];
		array[vectorStart + 2] = tmp;
		array[vectorStart + 0] = - array[vectorStart + 0];
	}

	private void convertVector(Vector3f v) {
		float tmp = v.y;
		v.y = v.z;
		v.z = tmp;
		v.x = - v.x;
	}

	private void convertNormal(float[] in, int pos) {
		 in[pos + 0] = in[pos + 0] * (1.0f / 32767.0f);
		 in[pos + 1] = in[pos + 1] * (1.0f / 32767.0f);
		 in[pos + 2] = in[pos + 2] * (1.0f / 32767.0f);		
	}

	private void convertRotation(float[] array, int vectorStart) {
		float tmp = array[vectorStart + 1];
		array[vectorStart + 1] = array[vectorStart + 2];
		array[vectorStart + 2] = tmp;
		array[vectorStart + 0] = array[vectorStart + 0];
	}



	private BufferedImage getTexture(Image image) throws IOException {
		CPointer<ImagePackedFile> p_imagePackedFile = image.getPackedfiles().getFirst().cast(ImagePackedFile.class);
		if (p_imagePackedFile.isValid()) {
			ImagePackedFile imagePackedFile = p_imagePackedFile.get();
			PackedFile packedFile = imagePackedFile.getPackedfile().get();
			
			CPointer<Byte> pdata = packedFile.getData().cast(Byte.class);
			
			byte[] data = pdata.toByteArray(packedFile.getSize());
			
			return ImageIO.read(new ByteArrayInputStream(data));
		} else {
			String filename = image.getName().asString();
			File imageFile;
			if (filename.startsWith("//")) {
				imageFile = new File(file.getParentFile().getAbsoluteFile(), filename.substring(1));
			} else {
				imageFile = new File(filename);
			}
			return ImageIO.read(imageFile);
		}
	}

}
