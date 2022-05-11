package org.cakelab.blender.io;

import static org.blender.dna.constants.object.Constants.*;
import static org.blender.dna.constants.vfont.Constants.*;
import static org.blender.dna.constants.BKE_node.*;
import static org.blender.dna.constants.constraints.eBConstraint_Types.*;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.blender.dna.*;
import org.blender.utils.MainLib;
import org.cakelab.appbase.log.Log;
import org.cakelab.blender.io.convert.ConvertBlender2OpenGL;
import org.cakelab.blender.io.convert.CoordinateSystemConverter;
import org.cakelab.blender.io.convert.mesh.MeshConverter;
import org.cakelab.blender.nio.CArrayFacade;
import org.cakelab.blender.nio.CPointer;
import org.cakelab.blender.utils.*;
import org.cakelab.oge.scene.Pose;
import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.soapbox.model.TriangleMesh;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.lwjgl.opengl.GL11;

public class BlenderInput {

	private static final short TYPE_MESH = 1;
	private static final Vector4fc BLENDER_DEFAULT_COLOR = new Vector4f(0.5f,0.5f,0.5f,1f);
	private MainLib main;
	private ArrayList<org.cakelab.oge.Camera> cameras = new ArrayList<org.cakelab.oge.Camera>();
	private File file;
	private CoordinateSystemConverter converter;
	private MeshConverter mesher;
	
	private HashMap<Long, Pose> objects = new HashMap<Long, Pose>();
	private HashMap<Long, ArrayList<Pose>> children = new HashMap<Long, ArrayList<Pose>>();
	
	public BlenderInput(File file) throws IOException {
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
		
		converter = new ConvertBlender2OpenGL();
		mesher = new MeshConverter(converter);
	}
	
	public ArrayList<org.cakelab.oge.Camera> getCameras() {
		return cameras;
	}

	/**
	 * Loads all objects, cameras and lights assigned to the given 
	 * layers and converts them into a scene.
	 * 
	 * @param layers Layers to be shown/active.
	 * @return A scene object with all objects of the selected layers
	 * @throws IOException
	 */
	public org.cakelab.oge.scene.Scene loadScene(Integer ... layers) throws IOException {
		
		int selectedLayers = 0;
		final int MAX_LAYERS = 0xFFFFFF;
		for (int l : layers) {
			if (l > MAX_LAYERS || l < 0) throw new IllegalArgumentException("layers have a number between 0 and " + MAX_LAYERS);
			selectedLayers |= 1<<l;
		}
		if (selectedLayers == 0) {
			// select all layers by default
			selectedLayers = MAX_LAYERS;
		}
		
		org.cakelab.oge.scene.Scene scene = new org.cakelab.oge.scene.Scene();
		Scene bscene = main.getScene();

		// Traverse master collection and gather objects
		Collection collection = bscene.getMaster_collection().get();
		traverseCollection(collection, selectedLayers, scene);
		

		resolveParentChildRelations();
		return scene;
	}
	
	private void traverseCollection(Collection collection, int selectedLayers, org.cakelab.oge.scene.Scene scene) throws IOException {

		Iterator<CollectionObject> it_gobj = BlenderListIterator.create(collection.getGobject(), CollectionObject.class);
		while (it_gobj.hasNext()) {
			CollectionObject gobj = it_gobj.next();
			BlenderObject ob = gobj.getOb().get();
			
			if (ob == null) {
				continue;
			}
			if ((ob.getLay() & selectedLayers) == 0) {
				// TODO: Layers are deprecated?
				// skip objects not in selected layers (i.e. invisible)
				continue;
			}
			
			switch (ob.getType()) {
			case OB_CAMERA:
				cameras.add(loadCamera(ob));
				break;
			case OB_LAMP:
				scene.add(loadLamp(ob));
				break;
			case OB_MESH:
				scene.add(loadMesh(ob));
				break;
			case OB_FONT:
				loadText(ob);
				break;
			default:
				Log.warn("skipped object " + ob.getId().getName().asString() + " with unknown type " + ob.getType());
				// TODO etc
			}
		}
		
		
		Iterator<CollectionChild> it_child = BlenderListIterator.create(collection.getChildren(), CollectionChild.class);
		while(it_child.hasNext()) {
			CollectionChild child = it_child.next();
			Collection childCollection = child.getCollection().get();
			if (childCollection != null) traverseCollection(childCollection, selectedLayers, scene);
		}

	}

	private void loadText(BlenderObject ob) throws IOException {
		// TODO [6] text and curves
		// does not work yet
		
		Curve curve = ob.getData().cast(Curve.class).get();
		String text = curve.getStr().toCArrayFacade(curve.getLen()).asString();
		System.out.println("Text: " + text);
		
		/* Vector Fonts used for text in the 3D view-port */
		VFont vFont = curve.getVfont().get();
		String fontName = vFont.getName().asString();
		System.out.println("Font: " + fontName);
		if (fontName.equals(FO_BUILTIN_NAME)) {
			// use builtin font
			Font.getFont("BFont");
		} else {
			// load free type font from file
		}

		/* All the information needed to draw the text is stored in Curve */

	}

	private void registerChild(BlenderObject parent, Pose ob) throws IOException {
		ArrayList<Pose> list = children.get(parent.__io__addressof().getAddress());
		if (list == null) {
			list = new ArrayList<Pose>();
			children.put(parent.__io__addressof().getAddress(), list);
		}
		list.add(ob);
	}

	private void registerObject(BlenderObject ob, Pose p) throws IOException {
		objects.put(ob.__io__addressof().getAddress(), p);
	}

	private void resolveParentChildRelations() {
		for (Entry<Long, ArrayList<Pose>> set : children.entrySet()) {
			Pose parent = objects.get(set.getKey());
			for (Pose child : set.getValue()) {
				child.setReferenceSystem(parent);
			}
		}
	}

	private org.cakelab.oge.scene.LightSource loadLamp(BlenderObject ob) throws IOException {
		Lamp l = ob.getData().cast(Lamp.class).get();
		Vector3f rgb = new Vector3f(l.getR(), l.getG(), l.getB());
		org.cakelab.oge.scene.LightSource lamp = new org.cakelab.oge.scene.LightSource(rgb);
		setPose(lamp, ob);
		return lamp;
	}

	private void setPose(org.cakelab.oge.scene.Pose pose, BlenderObject ob) throws IOException {
		
		BlenderObject parent = ob.getParent().get();
		if (parent != null) {
			// In Blender, a childs position and rotation get overridden
			// by that of the parent.
			// Thus, we will position our child at 0,0,0 without any rotation
			// but we keep the relationship just for .. I don't know why ..
			registerChild(parent, pose);
		} else {
		
			float[] tmp = new float[3];
			ob.getLoc().toArray(tmp, 0, 3);
			converter.convertVector(tmp, 0, 3);
			pose.setX(tmp[0]);
			pose.setY(tmp[1]);
			pose.setZ(tmp[2]);
			
			ob.getRot().toArray(tmp, 0, 3);
			Quaternionf rotation = converter.convertEulerRotation(tmp, 0);
			pose.setRotation(rotation);
		}
		// register for resolution of parent child relationships
		registerObject(ob, pose);
		
		// TODO: think about a more generic way for constraint interpretation
		ListBase constraints = ob.getConstraints();
		bConstraint c = constraints.getFirst().cast(bConstraint.class).get();
		if (c != null) {
			BlenderListIterator<bConstraint> cit = new BlenderListIterator<bConstraint>(c);
			while (cit.hasNext()) {
				c = cit.next();
				if (c.getType() == CONSTRAINT_TYPE_CHILDOF.v) {
					bChildOfConstraint childof = c.getData().cast(bChildOfConstraint.class).get();
					parent = childof.getTar().get();
					registerChild(parent, pose);
					break;
				}
			}
		}
		
//		// TODO object origin
//		ob.getOrig().toArray(tmp, 0, 3);
//		

	}

	private org.cakelab.oge.Camera loadCamera(BlenderObject ob) throws IOException {
		Camera cam = ob.getData().cast(Camera.class).get();
		org.cakelab.oge.Camera camera = new org.cakelab.oge.Camera(0, 0, 0, 0, 0, 0);
		
		// calculate field of view from focal length
		float f = cam.getLens();     // focal length
		float d = cam.getSensor_y(); // receiver width (for horizontal fov angle)
		float fov = (float) (2 * Math.atan(d/(2*f)));
		camera.setFoV((float) Math.toDegrees(fov));
		
		setCameraView(camera, ob);
		return camera;
	}

	private void setCameraView(org.cakelab.oge.Camera pose, BlenderObject ob) throws IOException {
		float[] tmp = new float[3];
		ob.getLoc().toArray(tmp, 0, 3);
		converter.convertVector(tmp, 0, 3);
		pose.setX(tmp[0]);
		pose.setY(tmp[1]);
		pose.setZ(tmp[2]);
		
		ob.getRot().toArray(tmp, 0, 3);
		/*
		 * Blenders default camera orientation is towards negative 
		 * Z and up is along postive Y.
		 */
		Vector3f forward = new Vector3f(0, 0, -1);
		Vector3f up = new Vector3f(0, 1, 0);
		Quaternionf rotation = converter.convertCameraOrientation(forward, up, tmp);
		pose.setOrientation(forward, up);
		pose.apply(rotation);
		
	}

	private void setPoseAndScale(org.cakelab.oge.scene.Entity pose, BlenderObject ob) throws IOException {
		setPose(pose, ob);

		float[] tmp = new float[3];

		BlenderObject parent = ob.getParent().get();
		if (parent != null) {
			// leave scale as it is
		} else {
			// use scale of object
			
			/* size is actually the scale of the object, not its size */
			ob.getSize().toArray(tmp, 0, 3);
			converter.convertScale(tmp, 0);
			pose.setScale(tmp[0], tmp[1], tmp[2]);
		}
		
	}

	private VisualEntity loadMesh(BlenderObject ob) throws IOException {
		Mesh mesh = ob.getData().cast(Mesh.class).get();
		VisualEntity object = createObject(ob, mesh);
		setPoseAndScale(object, ob);
		return object;
	}

	
	public VisualEntity loadFirstObject() throws IOException {
		Mesh mesh = main.getMesh();
		//
		// Convert mesh and texture into opengl suitable format
		//
		return createObject(null, mesh);
	}
	
	
	/**
	 * Retrieve the assets of a specific object with name objectName.
	 * @param filename Blender file
	 * @param objectName Name of the object to load
	 * @throws IOException 
	 */
	public VisualEntity loadObject(String objectName) throws IOException {
		Scene scene = main.getScene();
		BlenderSceneIterator base_it = new BlenderSceneIterator(scene);
		while (base_it.hasNext()) {
			Base base = base_it.next();
			BlenderObject o = base.getObject().get();
			String name = o.getId().getName().asString();
			if (name.equals("OB" + objectName)) {
				if (o.getType() == TYPE_MESH) {
					Mesh mesh = o.getData().cast(Mesh.class).get();
					return createObject(o, mesh);
				}
			}
		}
		throw new IOException("Object '" + objectName + "' not found");
	}
	
	private VisualEntity createObject(BlenderObject ob, Mesh mesh) throws IOException {
		TriangleMesh triangles;
		// TODO get smooth from material (maybe something to be decided by the renderer)
		boolean smooth = false;
		boolean withNormals = true;

		org.cakelab.oge.scene.Material material = getMaterial(ob, mesh);
		triangles = mesher.createTriangleMesh(mesh, material.hasTextures(), withNormals, smooth);
		
		return new VisualMeshEntity(triangles, material);
	}

	
	private org.cakelab.oge.scene.Material getMaterial(BlenderObject ob, Mesh mesh) throws IOException {
		Vector4f basecolor = new Vector4f(0,0,0,1);
		float emitter_intensity = 0f;
		
		short totcol = mesh.getTotcol();
		if (totcol > 1) {
			// TODO: consider multiple materials
			throw new IOException("mesh with multiple materials not supported");
		}
		CPointer<Material> pmat = mesh.getMat().get();
		org.cakelab.oge.scene.Material material;

		if (pmat == null || !pmat.isValid()) {
			CArrayFacade<Float> color = ob.getCol();
			if (color != null && color.length() == 4) {
				basecolor = converter.convertColor(color.get(0), color.get(1), color.get(2), color.get(3));
			} else {
				basecolor.set(BLENDER_DEFAULT_COLOR);
			}
			emitter_intensity = 0;
			if (basecolor.w == 0.0) Log.warn("invisible object found (base color alpha = 0)");
			material = new org.cakelab.oge.scene.Material(basecolor, null, emitter_intensity);
		} else {
			Material mat = pmat.get();
			
			basecolor = converter.convertColor(mat.getR(), mat.getG(), mat.getB(), mat.getA());
			material = new org.cakelab.oge.scene.Material(basecolor);
			if (mat.getUse_nodes() != 0) {
				readNodes(mat, material);
				// reset color if there is a texture
				if (material.hasTextures()) {
					material.setColor(new Vector4f(0,0,0,1));
				}
			}
			
		}
		return material;
	}
	
	
	
	
	private void readNodes(Material mat, org.cakelab.oge.scene.Material material) throws IOException {
		// TODO: this is all just for demonstration purposes
		CPointer<bNodeTree> p_nodetree = mat.getNodetree();
		if (p_nodetree != null && p_nodetree.get() != null) {
			bNodeTree tree = p_nodetree.get();
			ListBase nodes = tree.getNodes();
			Iterator<bNode> it = BlenderListIterator.create(nodes.getFirst().cast(bNode.class));
			while (it.hasNext()) {
				bNode node = it.next();
				int type = node.getType();
				switch(type) {
				case SH_NODE_TEX_IMAGE:
					
					Image ima = node.getId().cast(Image.class).get();
					BufferedImage image = getImage(ima);

					int pixelFormat = GL11.GL_RGBA;
					boolean flipped = true;
					material.setColorTexture(new TextureImage(image, pixelFormat, flipped));
					break;
				case TEX_NODE_IMAGE:
					ImageUser iuser = node.getStorage().cast(ImageUser.class).get();
					break;
				case SH_NODE_BSDF_PRINCIPLED:
					CArrayFacade<Float> rgba = Nodes.getDefaultRGBAInput(node, "Emission");
					if (rgba != null) {
						float intensity = (rgba.get(0) + rgba.get(1) + rgba.get(2) + rgba.get(3))/4.0f;
						material.setEmitterIntensity(intensity);
					}
					rgba = Nodes.getDefaultRGBAInput(node, "Base Color");
					if (rgba != null) {
						Vector4f basecolor = converter.convertColor(rgba.get(0), rgba.get(1), rgba.get(2), rgba.get(3));
						material.setColor(basecolor);
					}
					
					break;
				default:
					// currently we are not interested in any other nodes, because this is just a demo
					// System.out.println("type: " + type);
				}
			}
		}
	}


	private BufferedImage getImage(Image image) throws IOException {
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
