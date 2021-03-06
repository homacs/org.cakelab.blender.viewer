package org.cakelab.blender.io.output;

import java.io.File;
import java.io.IOException;

import org.blender.dna.*;
import org.blender.utils.BlenderFactory;
import org.blender.utils.MainLib;
import org.cakelab.blender.io.BlenderFile;
import org.cakelab.blender.io.block.BlockCodes;
import org.cakelab.blender.nio.CArrayFacade;
import org.cakelab.blender.nio.CPointer;

import static org.cakelab.blender.io.output.ExampleCopybufferExchange_Resources.*;

/**
 * This code snippet create a copybuffer.blend file with a mesh in the system's temp directory.
 * The file copybuffer.blend is Blender's kind of clip-board functionality. Blender creates
 * this file if you hit CTRL+C and reads the file if you hit CTRL+V.
 * 
 * After the file was generated with this class, you can paste it in Blender using CTRL-V.
 * Switch to texture view in Blender, to see that it actually pasted a textured cube.
 * 
 * Please note, that we even set the variables, which have a value of 0, although it
 * is not necessary, because all new buffers are initialised with 0 values.
 * 
 * @author homac
 *
 */
public class ExampleCopybufferExchange {
	/*
	 * 
	 * DISCLAIMER
	 * ----------
	 * 
	 * 
	 * Since 2.80, this example is no longer working as intended.
	 * There are a lot of changes in the last release and I 
	 * haven't had time to update it. But the basic principle 
	 * is still the same.
	 * 
	 * You can safely remove it from the build path, if necessary.
	 * 
	 */
	// FIXME: adapt to 2.80
	
	
	/* This variable is used for debugging purposes. 
	 * If enabled, it will add data to the file, which is
	 * usually added at runtime and not required to be 
	 * stored in a .blend file. This is useful for 
	 * comparisons to files created by blender.*/
	private static final boolean ADD_RUNTIME_INFO = false;
	
	private static BlenderFactory factory;
	private static BlenderObject object;
	private static CPointer<Object> Null;

	public static void main(String[] args) throws IOException {
		File copybuffer = new File("/tmp/copybuffer.blend");
		// in case there is already clipboard content 
		// -> delete it first, to make sure it actually does something
		copybuffer.delete();
		// Initialises a new blender file with StructDNA and FileGlobal.
		BlenderFile blend = BlenderFactory.newBlenderFile(copybuffer);

		factory = new BlenderFactory(blend);
		Null = factory.getNullPointer();
		initFileGlobal();

		
		Image textureImage = createImage();

		ImagePackedFile ipf = createImagePackedFile(TEXTURE_PATH);
		CPointer<Object> p_void_ipf = ipf.__io__addressof().cast(Object.class);
		textureImage.getPackedfiles().setFirst(p_void_ipf);
		textureImage.getPackedfiles().setLast(p_void_ipf);

		ipf.setPackedfile(createPackedFile(TEXTURE_HEXDATA));
		textureImage.setPackedfile(ipf.getPackedfile()); // XXX: can we remove it then?

		PreviewImage previewImage = createPreviewImage(32, 32, hex2ByteArr(TEXTURE_PREVIEW_HEXDATA), 0, new short[]{0,1});
		textureImage.setPreview(previewImage.__io__addressof());

		Stereo3dFormat stereo3d_format = createStereo3dFormat();
		textureImage.setStereo3d_format(stereo3d_format.__io__addressof());


		
		object = createObject();
		CPointer<CPointer<Material>> mat = createObjectMaterialLink();
		object.setMat(mat);
		
		CArrayFacade<Byte> matbits = createObjectMatbits();
		object.setMatbits(matbits);
		
		PartDeflect pd = createPartDeflect();
		object.setPd(pd.__io__addressof());

		Material material = createMaterial();

		IDProperty properties = createMaterialProperties();
		material.getId().setProperties(properties.__io__addressof());
		
		
		MTex mtex = createMTex();
		material.getMtex().set(0, mtex.__io__addressof());
		material.getMtex().set(1, Null.cast(MTex.class));
		
		PreviewImage previewMat = createPreviewImage(32, 32, hex2ByteArr(MATERIAL_PREVIEW_HEXDATA), 0, new short[]{56,56});
		material.setPreview(previewMat.__io__addressof());

		Tex tex = createTex();
		tex.setIma(textureImage.__io__addressof());
		
		PreviewImage previewTex = createPreviewImage(32, 32, hex2ByteArr(TEX_PREVIEW_HEXDATA), 871, new short[]{18,17});
		tex.setPreview(previewTex.__io__addressof());
		mtex.setTex(tex.__io__addressof());
	
		Mesh mesh = createMesh(textureImage.__io__addressof());
		// finish link to material
		mesh.getMat().set(material.__io__addressof());
		
		
		object.setData(mesh.__io__addressof().cast(Object.class));
		
		blend.write();
		blend.close();
		
	}

	private static IDProperty createMaterialProperties() throws IOException {
		IDProperty phead = createIDProperty(1, 6, 0, ""); // IDP_GROUP
		
		IDProperty pcycles = createIDProperty(1, 6, 0, "cycles");
		
		phead.getData().getGroup().setFirst(pcycles.__io__addressof().cast(Object.class));
		phead.getData().getGroup().setLast(pcycles.__io__addressof().cast(Object.class));
		
		IDProperty pvolume_sampling = createIDProperty(0, 1, 0, "volume_sampling");
		pcycles.getData().getGroup().setFirst(pvolume_sampling.__io__addressof().cast(Object.class));
		pcycles.getData().getGroup().setLast(pvolume_sampling.__io__addressof().cast(Object.class));
		
		
		return phead;
	}
	
	private static IDProperty createIDProperty(int len, int type, int flag, String name) throws IOException {
		IDProperty p = factory.newCStructBlock(BlockCodes.ID_DATA, IDProperty.class);
		p.setLen(len);
		p.setType((byte) type); // IDP_GROUP
		p.getData().setVal2(0);
		p.getData().setPointer(Null);
		p.getData().setVal(0);
		p.setFlag((short) flag); // TODO: meaning
		p.getName().fromString(name);
		p.setTotallen(0);
		p.setSubtype((byte) 0);
		p.setNext(Null.cast(IDProperty.class));
		p.setSaved(0);
		p.setPrev(Null.cast(IDProperty.class));
		return p;
	}
	
	

	private static void initFileGlobal() throws IOException {
		//
		// Initialising File Global for minimal blender file
		//
		// Note: version specifiers have already been initialised by BlenderFileImpl
		FileGlobal global = factory.getFileGlobal();
		// no scene
		global.setCurscene(Null.cast(Scene.class));
		// XXX: retrieve build commit timestamp from sdna in generator
		if (ADD_RUNTIME_INFO) global.setBuild_commit_timestamp(1477311627);
		// XXX: copy build hash from sdna file
		
		if (ADD_RUNTIME_INFO) global.getBuild_hash().fromString("e8299c8");
		/* Flags saved to the blend file, now only used for runtime options */
		if (ADD_RUNTIME_INFO) global.setGlobalf(262272);
		// no flags in copybuffer
		global.setFileflags(0);
		
		// XXX: move this to blender factory
		StringBuffer subvstr = new StringBuffer();
		int spaces = (int) (4 - Math.pow(MainLib.BLENDER_SUBVERSION, 1/10));
		for (int i = 0; i < spaces; i++) subvstr.append(' ');
		subvstr.append(MainLib.BLENDER_SUBVERSION);
		global.getSubvstr().fromString(subvstr.toString());

		// In copy buffer, this is the name of the file, the data was copied from.
		// thus, it can be left empty
		if (ADD_RUNTIME_INFO) global.getFilename().fromString("/home/homac/repos/svn/cakelab.org/playground/JavaBlendDemo/resources/cube.blend");
		global.setCurscreen(factory.getNullPointer().cast(bScreen.class));
	}

	@SuppressWarnings("unchecked")
	private static BlenderObject createObject() throws IOException {
		BlenderObject object = factory.newCStructBlock(BlockCodes.ID_OB, BlenderObject.class);
		object.setObstacleRad(0.0f);
		bAnimVizSettings avs = object.getAvs();
		avs.setGhost_bc(10);
		avs.setPath_ef(250);
		avs.setGhost_ef(250);
		avs.setRecalc((short) 0);
		avs.setPath_step((short) 1);
		avs.setPath_ac(10);
		avs.setGhost_ac(10);
		avs.setPath_bc(10);
		avs.setPath_bakeflag((short) 0);
		avs.setPath_sf(1);
		avs.setGhost_flag((short) 0);
		avs.setGhost_sf(1);
		avs.setPath_type((short) 0);
		avs.setGhost_step((short) 1);
		avs.setPath_viewflag((short) 6);
		avs.setGhost_type((short) 0);

		// this is just a cache which gets initialised by blender on demand
		object.setDerivedFinal(Null);
		// XXX: allow null as argument to set functions for pointers
		object.setCurrentlod(Null.cast(LodLevel.class));
		
		object.setProxy_from(Null.cast(BlenderObject.class));
		object.setRecalc((byte) 0);
		// TODO: shapenr: what if we have multiple objects
		object.setShapenr((short) 0);
		object.getDscale().fromArray(new float[]{1,1,1});
		object.setCollision_boundtype((byte) 0);
		object.setGameflag2(0);
		object.setMax_vel(0.0f);
		object.setBoundtype((byte)0);
		object.setMargin(0.06f);
		object.setStep_height(0.15f);

		ID id = object.getId();
		initId(id, "OB" + "MyCube", 1024, 1, 0);
		
		object.setTrack(Null.cast(BlenderObject.class));
		object.setMax_jumps((byte) 1);
		object.setParent(Null.cast(BlenderObject.class));
		object.getDsize().fromArray(new float[]{0,0,0});
		// another cache value for the bounding box. 
		// Blender creates a new Bounding box when reading the object.
		object.setBb(Null.cast(BoundBox.class));
		object.setProtectflag((short) 0);
		// UI info, probably unimportant for copy buffer
		object.setActcol(1);
		object.getActuators().setFirst(Null);
		object.getActuators().setLast(Null);
		object.setSoft(Null.cast(SoftBody.class));
		object.setEmpty_drawsize(1.0f);
		object.getControllers().setFirst(Null);
		object.getControllers().setLast(Null);
		object.setFormfactor(0.4f);
		object.setIuser(Null.cast(ImageUser.class));
		object.setDrotAngle(0.0f);
		object.setTrackflag((short) 1);
		CArrayFacade<CArrayFacade<Float>> constinv = object.getConstinv();
		/* i guess this is just runtime info, which gets init at file read. Copy buffer always contains unit matrix */
		constinv.get(0).fromArray(new float[]{1,0,0,0});
		constinv.get(1).fromArray(new float[]{0,1,0,0});
		constinv.get(2).fromArray(new float[]{0,0,1,0});
		constinv.get(3).fromArray(new float[]{0,0,0,1});
		
		object.setPreview(Null.cast(PreviewImage.class));
		
		object.setSf(0.0f);
		object.getDefbase().setFirst(Null);
		object.getDefbase().setLast(Null);
		object.setMin_vel(0.0f);
		object.setRotmode((short) 1);
		object.getCol().fromArray(new float[]{1,1,1,1});
		object.setAction(Null.cast(bAction.class));
		object.getDquat().fromArray(new float[]{1,0,0,0});
		object.setBody_type((byte) 1);
		/* i guess this is just runtime info, which gets init at file read. Copy buffer always contains unit matrix */
		CArrayFacade<CArrayFacade<Float>> parentinv = object.getParentinv();
		parentinv.get(0).fromArray(new float[]{1,0,0,0});
		parentinv.get(1).fromArray(new float[]{0,1,0,0});
		parentinv.get(2).fromArray(new float[]{0,0,1,0});
		parentinv.get(3).fromArray(new float[]{0,0,0,1});
		
		object.setDupend(100);
		object.setSculpt(Null);
		object.getParsubstr().fromString("");
		object.setDupsta(1);
		object.setMin_angvel(0f);

		object.setScavisflag((byte) 7);
		object.setTotcol(1);
		object.setRigidbody_constraint(Null.cast(RigidBodyCon.class));
		object.getRotAxis().fromArray(new float[]{0,1,0});
		object.getOrig().fromArray(new float[]{0,0,0});
		object.setInertia(1.0f);
		CArrayFacade<CArrayFacade<Float>> imat = object.getImat();
		imat.get(0).fromArray(new float[]{1,0,0,0});
		imat.get(1).fromArray(new float[]{0,1,0,0});
		imat.get(2).fromArray(new float[]{0,0,1,0});
		imat.get(3).fromArray(new float[]{0,0,0,1});
		
		object.setDamping(0.0254f);
		object.setRdamping(0.159f);
		object.getDloc().fromArray(new float[]{0,0,0});
		object.setMax_angvel(0f);
		object.setBsoft(Null.cast(BulletSoftBody.class));
		object.setCustomdata_mask(0);
		object.setEmpty_drawtype((byte) 1);
		object.setNlaflag((short) 0);

		object.setState(1);
		object.setColbits((short) 0);
		object.setDupoff(0);
		object.setDup_group(Null.cast(Group.class));
		object.setRestore_mode(0);
		object.setPartype((short) 0);
		object.setRigidbody_object(Null.cast(RigidBodyOb.class));
		
		// inverse object-view matrix to be initialised at runtime
		CArrayFacade<CArrayFacade<Float>> imat_ren = object.getImat_ren();
		imat_ren.get(0).fromArray(new float[]{0,0,0,0});
		imat_ren.get(1).fromArray(new float[]{0,0,0,0});
		imat_ren.get(2).fromArray(new float[]{0,0,0,0});
		imat_ren.get(3).fromArray(new float[]{0,0,0,0});
		object.getDrotAxis().fromArray(new float[]{0,1,0});
		object.setShapeflag((byte) 0);
		object.setDt((byte) 5);
		object.getHooks().setFirst(Null);
		object.getHooks().setLast(Null);
		object.getConstraints().setFirst(Null);
		object.getConstraints().setLast(Null);
		
		// another cache
		object.setDerivedDeform(Null);
		object.getEffect().setFirst(Null);
		object.getEffect().setLast(Null);
		object.setFluidsimSettings(Null.cast(FluidsimSettings.class));
		object.getDrot().fromArray(new float[]{0,0,0});
		object.getRot().fromArray(new float[]{0,0,0});
		object.setSmoothresh(0.0f);
		object.getProp().setFirst(Null);
		object.getProp().setLast(Null);
		object.getSize().fromArray(new float[]{1,1,1});
		object.getQuat().fromArray(new float[]{1,0,0,0});
		// we can set it to 0, since it is a cache value
		object.setLastDataMask(0);
		// later: create and set material link
		object.setMat(Null.cast(new Class[]{CPointer.class, Material.class}));
		object.getLoc().fromArray(new float[]{0,0,0});
		CArrayFacade<CArrayFacade<Float>> obmat = object.getObmat();
		obmat.get(0).fromArray(new float[]{1,0,0,0});
		obmat.get(1).fromArray(new float[]{0,1,0,0});
		obmat.get(2).fromArray(new float[]{0,0,1,0});
		obmat.get(3).fromArray(new float[]{0,0,0,1});
		
		object.setScaflag((short) 0);
		// XXX: can we remove it then?
		object.setIpo(Null.cast(Ipo.class));
		object.setDuplilist(Null.cast(ListBase.class));
		object.setLay(1);
		// obviously a cache value
		object.setLastNeedMapping((byte) 0);
		object.setRotAngle(0.0f);
		// another cache
		object.setCurve_cache(Null);
		// 
		object.setGameflag(81920);
		object.getModifiers().setFirst(Null);
		object.getModifiers().setLast(Null);
		// later: create and set mesh (depends on getType)
		object.setData(Null);
		object.setGpd(Null.cast(bGPdata.class));
		object.getGpulamp().setFirst(Null);
		object.getGpulamp().setLast(Null);
		object.getIma_ofs().set(0, 0f);
		object.getIma_ofs().set(1, 0f);
		object.setRestrictflag((byte) 0);
		object.getPc_ids().setFirst(Null);
		object.getPc_ids().setLast(Null);
		object.setTransflag((short) 0);
		// later: setMatbits
		object.setMatbits(Null.cast(Byte.class));
		object.setCol_mask((short) 255);
		object.getSensors().setFirst(Null);
		object.getSensors().setLast(Null);

		object.getLodlevels().setFirst(Null);
		object.getLodlevels().setLast(Null);

		object.setIndex((short) 0);
		object.setMass(1.0f);
		object.getNlastrips().setFirst(Null);
		object.getNlastrips().setLast(Null);
		object.setActdef((short) 0);
		
		// Type is OB_MESH
		object.setType((short)1);
		object.setProxy(Null.cast(BlenderObject.class));
		object.setPoselib(Null.cast(bAction.class));
		
		object.setFall_speed(55.0f);
		object.setProxy_group(Null.cast(BlenderObject.class));
		object.setDupon(1);
		
		object.setInit_state(0);

		object.setCol_group((short) 1);
		object.setMpath(Null.cast(bMotionPath.class));
		object.getParticlesystem().setFirst(Null);
		object.getParticlesystem().setLast(Null);
		object.setPar3(0);
		object.setJump_speed(10.0f);
		object.setUpflag((short) 2);
		object.setFlag((short) 1);
		object.setDepsflag((byte) 0);
		object.getAnisotropicFriction().fromArray(new float[]{1,1,1});
		// later: create and set partdeflect
		object.setPd(Null.cast(PartDeflect.class));
		object.setPar2(0);
		object.setPar1(0);
		object.getConstraintChannels().setFirst(Null);
		object.getConstraintChannels().setLast(Null);
		object.setDtx((short) 0);
		object.setSoftflag((short) 0);
		object.setMode(0);
		object.setDupfacesca((float) 1.0);
		object.setPose(Null.cast(bPose.class));
		object.setAdt(Null.cast(AnimData.class));
		return object;
	}

	private static Mesh createMesh(CPointer<Image> texture) throws IOException {
		
		Mesh mesh = factory.newCStructBlock(BlockCodes.ID_ME, Mesh.class);

		//
		// init required data structures beforehand
		//
		// link to material
		CPointer<CPointer<Material>> matp = factory.newCPointerBlock(BlockCodes.ID_DATA, new Class[]{Material.class});
		int totvert = 8;
		CArrayFacade<CustomDataLayer> vdataLayers = createVertexData(totvert);
		int totedge = 12;
		CArrayFacade<CustomDataLayer> edataLayers = createEdgeData(totedge);
		int totloop = 24;
		CArrayFacade<CustomDataLayer> ldataLayers = createLoopData(totloop);
		
		int numPolies = 12;
		CArrayFacade<CustomDataLayer> pdataLayers = createPolyData(texture);

		//
		// now init all fields of Mesh
		//
		
		mesh.setMselect(Null.cast(MSelect.class));
		CustomData edata = mesh.getEdata();
		initCustomData(edata, edataLayers, totedge);
		
		mesh.setMtface(Null.cast(MTFace.class));
		mesh.setDvert(Null.cast(MDeformVert.class));
		mesh.setTotloop(totloop);
		mesh.setKey(Null.cast(Key.class));
		mesh.setDrawflag(67); // ME_DRAWEDGES | ME_DRAWFACES | ME_DRAWCREASES
		mesh.setCd_flag((byte) 0);
		mesh.setTotselect(0);
		
		CustomData pdata = mesh.getPdata();
		// TODO: ASK: why 28 (was supposed to be numPolies(12))
		initCustomData(pdata, pdataLayers, 28);
		
		CustomData fdata = mesh.getFdata();
		fdata.setLayers(Null.cast(CustomDataLayer.class));
		fdata.setMaxlayer(0);
		fdata.setTotlayer(0);
		
		mesh.setTface(Null.cast(TFace.class));
		mesh.setMloop(ldataLayers.get(1).getData().cast(MLoop.class));
		mesh.setTotface(0);

		CustomData ldata = mesh.getLdata();
		// TODO: ASK: why 20 for totsize? Actually it is 48.
		initCustomData(ldata, ldataLayers, 20);

		mesh.setMtpoly(pdataLayers.get(0).getData().cast(MTexPoly.class));
		mesh.setMpoly(pdataLayers.get(1).getData().cast(MPoly.class));
		mesh.getRot().fromArray(new float[]{0,0,0});
		mesh.setMloopcol(Null.cast(MLoopCol.class));
		mesh.setSmoothresh(0.5235988f);
		mesh.setMr(Null.cast(Multires.class));
		mesh.getSize().fromArray(new float[]{1,1,1});
		mesh.setSubdivr((byte) 1);
		mesh.setTotpoly(6);
		
		ID id = mesh.getId();
		initId(id, "ME" + "MyCube", 1024, 1, 0);
		
		mesh.setMvert(vdataLayers.get(0).getData().cast(MVert.class));
		mesh.setEditflag((byte) 0);
		mesh.setEdit_btmesh(Null);
		mesh.setTotcol((short) 1);
		// link will be initialised later (Note: this is a Material**)
		mesh.setMat(matp);
		mesh.setAct_face(0);
		mesh.getLoc().fromArray(new float[]{5.9604645E-8f, -1.1920929E-7f, 0});
		mesh.setTexcomesh(Null.cast(Mesh.class));
		mesh.setFlag((short) 6);
		mesh.setBb(Null.cast(BoundBox.class));
		mesh.setMcol(Null.cast(MCol.class));
		mesh.setIpo(Null.cast(Ipo.class));
		mesh.setSubsurftype((byte) 0);
		mesh.setTotedge(totedge);
		
		CustomData vdata = mesh.getVdata();
		initCustomData(vdata, vdataLayers, 20);
		
		mesh.setMedge(edataLayers.get(0).getData().cast(MEdge.class));
		mesh.setMface(Null.cast(MFace.class));
		mesh.setMloopuv(ldataLayers.get(0).getData().cast(MLoopUV.class));
		mesh.setTexflag((short) 1); // AUTOSPACE
		mesh.setSubdiv((byte) 1);
		mesh.setAdt(Null.cast(AnimData.class));
		mesh.setTotvert(totvert);
		return mesh;
	}


	private static CArrayFacade<CustomDataLayer> createVertexData(int totvert) throws IOException {
		// create a block for one data layer with vertices
		CArrayFacade<CustomDataLayer> vdataLayers = factory.newCStructBlock(BlockCodes.ID_DATA, CustomDataLayer.class, 1);
		// create a block with an array of vertices
		CArrayFacade<MVert> mverts = factory.newCStructBlock(BlockCodes.ID_DATA, MVert.class, totvert);
		CustomDataLayer vdataLayer = vdataLayers.get(0);
		
		initCustomDataLayer(vdataLayer, mverts.cast(Object.class), 0 /* CD_MVERT */, "", 0);
		
		// init array of vertices
		int i = 0;
		initMVert(mverts, i++, new short[]{18918, 18918, -18918}, new float[]{1,1,-1});
		initMVert(mverts, i++, new short[]{18918, -18918, -18918}, new float[]{1,-1,-1});
		initMVert(mverts, i++, new short[]{-18918, -18918, -18918}, new float[]{-1,-1,-1});
		initMVert(mverts, i++, new short[]{-18918, 18918, -18918}, new float[]{-1,1,-1});
		initMVert(mverts, i++, new short[]{18918, 18918, 18918}, new float[]{1,1,1});
		initMVert(mverts, i++, new short[]{18918, -18918, 18918}, new float[]{1,-1,1});
		initMVert(mverts, i++, new short[]{-18918, -18918, 18918}, new float[]{-1,-1,1});
		initMVert(mverts, i++, new short[]{-18918, 18918, 18918}, new float[]{-1,1,1});
		return vdataLayers;
	}

	private static void initMVert(CArrayFacade<MVert> mverts, int i, short[] normals,
			float[] coords) throws IOException {
		MVert v = mverts.get(i);
		v.getNo().fromArray(normals);
		v.setFlag((byte) 1); // SELECT (it was selected)
		v.getCo().fromArray(coords);
		v.setBweight((byte) 0);
	}


	private static CArrayFacade<CustomDataLayer> createEdgeData(int numEdges) throws IOException {
		CArrayFacade<CustomDataLayer> edgeDataLayers = factory.newCStructBlock(BlockCodes.ID_DATA, CustomDataLayer.class, 1);
		CArrayFacade<MEdge> edges = factory.newCStructBlock(BlockCodes.ID_DATA, MEdge.class, numEdges);
		CustomDataLayer edgeDataLayer = edgeDataLayers.get(0);
		
		initCustomDataLayer(edgeDataLayer, edges.cast(Object.class), 3 /* CD_MEDGE */, "", 0);
		
		int i = 0;
		initEdge(edges, i++, 0, 1);
		initEdge(edges, i++, 0, 3);
		initEdge(edges, i++, 0, 4);
		initEdge(edges, i++, 1, 2);
		initEdge(edges, i++, 1, 5);
		initEdge(edges, i++, 2, 3);
		initEdge(edges, i++, 2, 6);
		initEdge(edges, i++, 3, 7);
		initEdge(edges, i++, 4, 5);
		initEdge(edges, i++, 4, 7);
		initEdge(edges, i++, 5, 6);
		initEdge(edges, i++, 6, 7);
		return edgeDataLayers;
	}

	private static void initEdge(CArrayFacade<MEdge> edges, int i, int v1,
			int v2) throws IOException {
		MEdge e = edges.get(i);
		e.setV1(v1);
		e.setV2(v2);
		e.setFlag((short) (1 | (1<<1) | (1<<5))); // SELECT | ME_EDGEDRAW | ME_EDGERENDER
		e.setCrease((byte) 0);
		e.setBweight((byte) 0);
	}


	private static CArrayFacade<CustomDataLayer> createLoopData(int totloop) throws IOException {
		// create two data layers: 1. for UVMap and 2. for loops
		
		CArrayFacade<CustomDataLayer> ldataLayers = factory.newCStructBlock(BlockCodes.ID_DATA, CustomDataLayer.class, 2);
		
		CArrayFacade<MLoopUV> mloopuv = factory.newCStructBlock(BlockCodes.ID_DATA, MLoopUV.class, totloop);
		CustomDataLayer loopuvDataLayer = ldataLayers.get(0); // uvmap first
		
		initCustomDataLayer(loopuvDataLayer, mloopuv.cast(Object.class), 16 /* CD_MLOOPUV */, "UVMap", 0);
		
		// 24 x UV vectors (2D) - one for each loop element
		int i = 0;
        initLoopUv(mloopuv, i++, 0.6666667, 8.940696E-8);
        initLoopUv(mloopuv, i++, 1.0, 3.9736427E-8); 
        initLoopUv(mloopuv, i++, 1.0, 0.33333337); 
        initLoopUv(mloopuv, i++, 0.6666667, 0.33333334); 
        initLoopUv(mloopuv, i++, 0.0, 0.6666668); 
        initLoopUv(mloopuv, i++, 6.953875E-8, 0.33333343); 
        initLoopUv(mloopuv, i++, 0.3333333, 0.33333352); 
        initLoopUv(mloopuv, i++, 0.33333328, 0.66666675); 
        initLoopUv(mloopuv, i++, 0.6666667, 0.33333328); 
        initLoopUv(mloopuv, i++, 0.3333334, 0.33333334); 
        initLoopUv(mloopuv, i++, 0.3333333, 0.0); 
        initLoopUv(mloopuv, i++, 0.6666666, 1.9868214E-8); 
        initLoopUv(mloopuv, i++, 2.980232E-8, 0.33333343); 
        initLoopUv(mloopuv, i++, 0.0, 1.2914339E-7); 
        initLoopUv(mloopuv, i++, 0.33333322, 0.0); 
        initLoopUv(mloopuv, i++, 0.3333333, 0.33333328); 
        initLoopUv(mloopuv, i++, 0.6666666, 0.33333343); 
        initLoopUv(mloopuv, i++, 0.99999994, 0.33333343); 
        initLoopUv(mloopuv, i++, 0.99999994, 0.6666667); 
        initLoopUv(mloopuv, i++, 0.6666666, 0.66666675); 
        initLoopUv(mloopuv, i++, 0.3333333, 0.33333343); 
        initLoopUv(mloopuv, i++, 0.66666657, 0.33333343); 
        initLoopUv(mloopuv, i++, 0.6666666, 0.6666667); 
        initLoopUv(mloopuv, i++, 0.33333334, 0.6666668);

		
		CArrayFacade<MLoop> mloop = factory.newCStructBlock(BlockCodes.ID_DATA, MLoop.class, totloop);
		CustomDataLayer loopDataLayer = ldataLayers.get(1); // after uv map
		
		initCustomDataLayer(loopDataLayer, mloop.cast(Object.class), 26 /* CD_MLOOP */, "NGon Face-Vertex", 12);
		

		// define loops (loop faces)
		i = 0;
		initLoop(mloop, i++, 0, 0);
		initLoop(mloop, i++, 3, 1);
		initLoop(mloop, i++, 5, 2);
		initLoop(mloop, i++, 1, 3);
		initLoop(mloop, i++, 9, 4);
		initLoop(mloop, i++, 11, 7);
		initLoop(mloop, i++, 10, 6);
		initLoop(mloop, i++, 8, 5);
		initLoop(mloop, i++, 2, 0);
		initLoop(mloop, i++, 8, 4);
		initLoop(mloop, i++, 4, 5);
		initLoop(mloop, i++, 0, 1);
		initLoop(mloop, i++, 4, 1);
		initLoop(mloop, i++, 10, 5);
		initLoop(mloop, i++, 6, 6);
		initLoop(mloop, i++, 3, 2);
		initLoop(mloop, i++, 6, 2);
		initLoop(mloop, i++, 11, 6);
		initLoop(mloop, i++, 7, 7);
		initLoop(mloop, i++, 5, 3);
		initLoop(mloop, i++, 2, 4);
		initLoop(mloop, i++, 1, 0);
		initLoop(mloop, i++, 7, 3);
		initLoop(mloop, i++, 9, 7);
		
		return ldataLayers;
	}

	private static void initLoopUv(CArrayFacade<MLoopUV> mloopuv, int i, double u, double v) throws IOException {
		MLoopUV luv = mloopuv.get(i);
		luv.setFlag(2); // MLOOPUV_VERTSEL
		luv.getUv().set(0, (float) u);
		luv.getUv().set(1, (float) v);
	}

	private static void initLoop(CArrayFacade<MLoop> mloop, int i, int e, int v) throws IOException {
		MLoop l = mloop.get(i);
		l.setE(e);
		l.setV(v);
	}


	private static CArrayFacade<CustomDataLayer> createPolyData(CPointer<Image> texture) throws IOException {
		// create two data layers for polygons (faces), one for polys in UV and one for polys in mesh
		CArrayFacade<CustomDataLayer> pdataLayers = factory.newCStructBlock(BlockCodes.ID_DATA, CustomDataLayer.class, 2);
		// cube has 6 faces
		int numPolies = 6;

		CArrayFacade<MTexPoly> mtexpolies = factory.newCStructBlock(BlockCodes.ID_DATA, MTexPoly.class, numPolies);
		CustomDataLayer puvdatalayer = pdataLayers.get(0);
		
		initCustomDataLayer(puvdatalayer, mtexpolies.cast(Object.class), 15 /* CD_MTEXPOLY */, "UVMap", 0);

		// assign texture to each polygon
		int i = 0;
		initMTexPoly(mtexpolies, i++, texture);
		initMTexPoly(mtexpolies, i++, texture);
		initMTexPoly(mtexpolies, i++, texture);
		initMTexPoly(mtexpolies, i++, texture);
		initMTexPoly(mtexpolies, i++, texture);
		initMTexPoly(mtexpolies, i++, texture);

		CArrayFacade<MPoly> mpolies = factory.newCStructBlock(BlockCodes.ID_DATA, MPoly.class, numPolies);
		CustomDataLayer pdatalayer = pdataLayers.get(1);
		
		// TODO: ASK: offset 16? (optional)
		initCustomDataLayer(pdatalayer, mpolies.cast(Object.class), 25 /* CD_MPOLY */, "NGon Face", 16);

		// define polygons
		i = 0;
		initMPoly(mpolies, i++, 0, 4);
		initMPoly(mpolies, i++, 4, 4);
		initMPoly(mpolies, i++, 8, 4);
		initMPoly(mpolies, i++, 12, 4);
		initMPoly(mpolies, i++, 16, 4);
		initMPoly(mpolies, i++, 20, 4);
		
		return pdataLayers;
	}

	private static void initMTexPoly(CArrayFacade<MTexPoly> mtexpolies, int i, CPointer<Image> texture) throws IOException {
		MTexPoly poly = mtexpolies.get(i);
		poly.setTile((short) 0);
		poly.setTransp((byte) 0);
		poly.setFlag((byte) 0);
		poly.setTpage(texture);
		poly.setMode((short) 0);
	}

	private static void initMPoly(CArrayFacade<MPoly> mpolies, int i, int loopstart,
			int totloop) throws IOException {
		MPoly p = mpolies.get(i);
		p.setLoopstart(loopstart);
		p.setTotloop(totloop);
		p.setFlag((byte) 2); // ME_FACE_SEL
		p.setMat_nr((short) 0);
	}

	private static void initCustomData(CustomData edata, CArrayFacade<CustomDataLayer> edataLayers, int size) throws IOException {
		edata.setLayers(edataLayers);
		edata.setPool(Null);

		initLayerTypeMap(edataLayers, edata.getTypemap());
		
		edata.setMaxlayer(edataLayers.length());
		edata.setTotlayer(edataLayers.length());
		if (ADD_RUNTIME_INFO) {
			edata.setTotsize(size);
		} else {
			edata.setTotsize(0);
		}
		edata.setExternal(Null.cast(CustomDataExternal.class));
		
	}

	private static void initCustomDataLayer(CustomDataLayer dataLayer, CPointer<Object> data, int type, String name, int offset) throws IOException {
		dataLayer.setType(type); // type of the data contained in the layer
		dataLayer.setActive(0);
		dataLayer.setUid(0);
		dataLayer.setActive_mask(0);
		dataLayer.setData(data); // pointer on the actual data
		dataLayer.setFlag(0);
		dataLayer.getName().fromString(name);
		if (ADD_RUNTIME_INFO) {
			dataLayer.setOffset(offset);
		} else {
			dataLayer.setOffset(0);
		}
		dataLayer.setActive_rnd(0);

	}


	private static Image createImage() throws IOException {
		CPointer<Image> p_image = factory.newCStructBlock(BlockCodes.ID_IM, Image.class, 1);
		
		Image image = p_image.get();

		image.setYrep((short) 1);
		image.setTwend((short) 0); // no animation
		image.setGen_depth((short) 0);
		image.setTwsta((short) 0); // no animation
		image.setRr(Null);
		image.setLast_render_slot((short) 0);
		image.setTotbind((short) 0);
		image.setXrep((short) 1);
		image.setGen_flag((byte) 0); // not used
		image.setSource((short) 1); // IMA_SRC_FILE
		ColorManagedColorspaceSettings colorSpace = image.getColorspace_settings();
		colorSpace.getName().fromString("sRGB");
		image.setGen_x(1024);    // width
		
		if (ADD_RUNTIME_INFO) {
			image.setOk((short) 2); // IMA_OK_LOADED: will be reset on read
		} else {
			image.setOk((short) 0);
		}
		image.setType((short) 0);
		
		image.getGputexture().set(0, Null);
		image.getGputexture().set(1, Null);
		
		image.setGen_type((byte) 1); // IMA_GENTYPE_GRID (seems to be default for textures)
		if (ADD_RUNTIME_INFO) image.setLastused(1479815019); // time since last usage (TODO: important)
		image.setGen_y(1024); // height
		image.setLastframe(0); // no animation
		image.setCache(Null);
		
		ID id = image.getId();
		initId(id, "IMtest-cube-texture.png", 1028, 1, 0);

		image.setEye((byte) 0);
		
		@SuppressWarnings("unchecked")
		CPointer<Object>[] nullArray = new CPointer[]{Null,Null,Null,Null,Null,Null,Null,Null};
		image.getRenders().fromArray(nullArray);
		image.getGen_color().fromArray(new float[]{0f,0f,0f,1f});
		image.setLastupdate(0f);
		
		image.getViews().setFirst(Null);
		image.getViews().setLast(Null);
		
		image.setFlag(512); // IMA_USER_FRAME_IN_RANGE
		image.setRender_slot((short) 0);
		
		image.setTpageflag((short) 8); // IMA_MIPMAP_COMPLETE
		
		if (ADD_RUNTIME_INFO) {
			image.getBindcode().fromArray(new int[]{9,0});
		} else {
			image.getBindcode().fromArray(new int[]{0,0});
		}
		
		image.setAnimspeed((short) 0);
		image.setAlpha_mode((byte) 0);
		CArrayFacade<RenderSlot> p_rs = image.getRender_slots();
		for (RenderSlot rs : p_rs) {
			rs.getName().fromString("");
		}
		
		if (ADD_RUNTIME_INFO) {
			image.getName().fromString("//.." + TEXTURE_PATH);
		} else {
			/* its an embedded (packed) image, so we don't need the path */
			image.getName().fromString("");
		}
		
		image.getAnims().setFirst(Null);
		image.getAnims().setLast(Null);
		
		image.setViews_format((byte) 0);
		image.setAspx(1f);
		image.setAspy(1f);
		image.setRepbind(Null.cast(Integer.class));
		
		return image;
	}

	private static ImagePackedFile createImagePackedFile(String texturePath) throws IOException {
		ImagePackedFile imagePackedFile = factory.newCStructBlock(BlockCodes.ID_DATA, ImagePackedFile.class);
		imagePackedFile.getFilepath().fromString(texturePath);
		imagePackedFile.setNext(Null.cast(ImagePackedFile.class));
		imagePackedFile.setPrev(Null.cast(ImagePackedFile.class));
		return imagePackedFile;
	}

	private static CPointer<PackedFile> createPackedFile(String hexdata) throws IOException {
		PackedFile pf = factory.newCStructBlock(BlockCodes.ID_DATA, PackedFile.class);

		byte[] raw = hex2ByteArr(TEXTURE_HEXDATA);
		CArrayFacade<Byte> imgData = factory.newCArrayBlock(BlockCodes.ID_DATA, Byte.class, raw.length);
		imgData.fromArray(raw);
		pf.setData(imgData.cast(Object.class));
		pf.setSeek(0);
		// TODO: report: for some reason the size stored in the original .blend file was wrong (length-1) 
		pf.setSize(raw.length - 1);
		return pf.__io__addressof();
	}

	private static void initId(ID id, String name, int tag, int us, int iconId) throws IOException {
		id.setFlag((short) 0);
		id.getName().fromString(name); // can be any i guess
		if (ADD_RUNTIME_INFO) {
			id.setTag((short) tag);
		} else {
			// runtime info to be set at read time
			id.setTag((short) 0);
		}
		if (ADD_RUNTIME_INFO) {
			id.setIcon_id(iconId);
		} else {
			// runtime info
			id.setIcon_id(0);
		}
		id.setNext(Null);
		id.setLib(Null.cast(Library.class));
		id.setProperties(Null.cast(IDProperty.class));
		id.setUs(us);
		id.setPrev(Null);
		id.setNewid(Null.cast(ID.class));
	}

	private static Stereo3dFormat createStereo3dFormat() throws IOException {
		Stereo3dFormat s3df = factory.newCStructBlock(BlockCodes.ID_DATA, Stereo3dFormat.class);
		// all elements 0
		return s3df;
	}

	private static void initLayerTypeMap(CArrayFacade<CustomDataLayer> dataLayer,
			CArrayFacade<Integer> typemap) throws IOException {
		// init with -1
		for (int i = 0; i < typemap.length(); i++) {
			typemap.set(i, -1);
		}

		// place indices of layers in type map
		for (int i = 0; i < dataLayer.length(); i++) {
			int type = dataLayer.get(i).getType();
			typemap.set(type, i);
		}
	}

	private static Tex createTex() throws IOException {
		Tex tex = factory.newCStructBlock(BlockCodes.ID_TE, Tex.class);
		tex.setXrepeat((short) 1);
		tex.setVn_distm((short) 0);
		tex.setVn_mexp(2.5f);
		tex.setFiltersize(1);
		tex.setAfmax(8);
		tex.setLen(0);
		tex.setStype((short) 0);
		tex.setYrepeat((short) 1);
		tex.setNabla(0.025f);
		tex.setContrast(1);
		tex.setNs_outscale(1);
		tex.setFrames(0);
		tex.setNoisebasis((short) 0);
		tex.setEnv(Null.cast(EnvMap.class));
		ID id = tex.getId();
		initId(id, "TE" + "MyTex", 1024, 1, 871);
		
		tex.setNoisetype((short) 0);
		tex.setMg_offset(1);
		tex.setIpo(Null.cast(Ipo.class));
		
		ImageUser iuser = tex.getIuser();
		iuser.setScene(Null.cast(Scene.class));
		iuser.setMulti_index((short) 0);
		iuser.setPass((short) 0);
		iuser.setFie_ima((byte) 2);
		iuser.setFlag((short) 0);
		iuser.setFramenr(0);
		
		if (ADD_RUNTIME_INFO) {
			iuser.setOk((byte) 2);
		} else {
			iuser.setOk((byte) 0);
		}
		iuser.setOffset(0);
		iuser.setSfra(1);
		iuser.setLayer((short) 0);
		iuser.setFrames(0);
		iuser.setCycl((byte) 0);
		
		tex.setCheckerdist(0);
		tex.setNodetree(Null.cast(bNodeTree.class));
		tex.setCropymin(0);
		tex.setImaflag((short) 7);
		tex.setPreview(Null.cast(PreviewImage.class));
		tex.setExtend((short) 3);
		tex.setTexfilter(0);
		tex.setNoisedepth((short) 2);
		tex.setBfac(1);
		tex.setMg_gain(1);
		tex.setNoisebasis2((short) 0);
		tex.setCoba(Null.cast(ColorBand.class));
		tex.setCropymax(1);
		tex.setSaturation(1);
		tex.setVn_coltype((short) 0);
		tex.setType((short) 8);
		tex.setTurbul(5);
		tex.setCropxmin(0);
		tex.setOt(Null.cast(OceanTex.class));
		tex.setIma(Null.cast(Image.class));
		tex.setGfac(1);
		tex.setVn_w2(0);
		tex.setVn_w3(0);
		tex.setVn_w4(0);
		tex.setVd(Null.cast(VoxelData.class));
		tex.setVn_w1(1);
		tex.setDist_amount(1);
		tex.setFie_ima((short) 2);
		tex.setMg_octaves(2);
		tex.setFlag((short) 8);
		tex.setPd(Null.cast(PointDensity.class));
		tex.setMg_H(1);
		tex.setMg_lacunarity(2);
		tex.setCropxmax(1);
		tex.setNoisesize(0.25f);
		tex.setUse_nodes((byte) 0);
		tex.setOffset(0);
		tex.setSfra(1);
		tex.setBright(1);
		tex.setAdt(Null.cast(AnimData.class));
		tex.setRfac(1);
		return tex;
	}

	private static byte[] hex2ByteArr(String hexstr) {
		char[] chars = hexstr.toCharArray();
		byte[] result = new byte[chars.length/2];
		for (int i = 0; i < chars.length; i++) {
			String s = "0x" + Character.toString(chars[i++]) + chars[i];
			result[i/2] = (byte) (Integer.decode(s) & 0xff);
		}
		return result;
	}

	private static PreviewImage createPreviewImage(int width, int height, byte[] data, int iconId, short[] changedTmstmp) throws IOException {
		PreviewImage img = factory.newCStructBlock(BlockCodes.ID_DATA, PreviewImage.class);
		
		// FIXME: deprecated?
		// img.setUse_deferred((byte) 0);
		
		img.getGputexture().set(0, Null);
		img.getGputexture().set(1, Null);
		
		img.getFlag().fromArray(new short[]{0,0});
		img.setIcon_id(iconId);
		
		if (ADD_RUNTIME_INFO) {
			img.getChanged_timestamp().fromArray(changedTmstmp);
		} else {
			// just runtime info
			img.getChanged_timestamp().fromArray(new short[]{0,0});
		}

		img.getW().set(0, width);
		img.getW().set(1, 0);
		img.getH().set(0, height);
		img.getH().set(1, 0);

		// assign image data
		CArrayFacade<Byte> imgData = factory.newCArrayBlock(BlockCodes.ID_DATA, Byte.class, data.length);
		imgData.fromArray(data);
		// In the past, rect was probably a set of pointers on width and height
		// but now (v2.69) it is used as reference on image data.
		CArrayFacade<CPointer<Integer>> rect = img.getRect();
		// XXX: what about 64bit?
		rect.set(0, imgData.cast(Integer.class));
		rect.set(1, Null.cast(Integer.class));
		img.setRect(rect);
		return img;
	}

	private static MTex createMTex() throws IOException {
		MTex mtex = factory.newCStructBlock(BlockCodes.ID_DATA, MTex.class);
		mtex.setR(1);
		mtex.setClumpfac(1);
		mtex.setLengthfac(1);
		mtex.setK(1);
		mtex.setDispfac(0.2f);
		mtex.setG(0);
		mtex.setEmitfac(1);
		mtex.setTranslfac(1);
		mtex.setB(1);
		mtex.setDef_var(1);
		mtex.setColfac(1);
		mtex.setColemitfac(1);
		mtex.setDensfac(1);
		mtex.setRot(0);
		mtex.setVarfac(1);
		mtex.getSize().fromArray(new float[]{1,1,1});
		mtex.setAlphafac(1);
		mtex.setObject(Null.cast(BlenderObject.class));
		mtex.setNormapspace((short) 3);
		mtex.setMapto((short) 1);
		mtex.setProjz((byte) 3);
		mtex.setProjy((byte) 2);
		mtex.setPadensfac(1);
		mtex.setProjx((byte) 1);
		mtex.setLifefac(1);
		mtex.setNorfac(1);
		mtex.setTimefac(1);
		
		mtex.setRandom_angle(0f);
		
		mtex.setMapping((byte) 0);
		mtex.setHardfac(1);
		mtex.setGravityfac(0);
		
		mtex.setKinkampfac(0);
		mtex.setBrush_angle_mode((byte) 0);
		mtex.setScatterfac(1f);
		
		mtex.setRt(0);
		mtex.setColspecfac(1);
		mtex.setSpecfac(1);

		mtex.setDifffac(1);
		mtex.setBlendfac(1);
		mtex.setZenupfac(1);
		mtex.setColreflfac(1);
		mtex.setFieldfac(0);
		mtex.setWarpfac(0);
		mtex.setAmbfac(1);

		mtex.getOfs().fromArray(new float[]{0,0,0});
		mtex.setWhich_output((short) 0);
		
		mtex.setDampfac(0);
		// later: assign tex
		mtex.setTex(Null.cast(Tex.class));
		mtex.setMirrfac(1);
		mtex.setShadowfac(1);
		mtex.setSizefac(1);
		mtex.setColormodel((short) 0);
		mtex.setBlendtype((short) 0);
		mtex.setPmaptoneg((short) 0);
		mtex.getUvname().fromString("");
		mtex.setIvelfac(1);
		mtex.setRaymirrfac(1);
		mtex.setKinkfac(1);
		mtex.setZendownfac(1);
		mtex.setReflfac(1);
		mtex.setTexco((short) 16);
		mtex.setTexflag((short) 256);
		mtex.setRoughfac(1);
		mtex.setColtransfac(1);
		mtex.setPmapto((short) 0);
		mtex.setMaptoneg((short) 0);
		return mtex;
	}

	private static CArrayFacade<Byte> createObjectMatbits() throws IOException {
		// Matbits are stored in a separate block. One for each material, I guess..
		//
		// Explanation from blender source code: 
		//    A boolean field, with each byte 1 if corresponding material is linked to object.
		//
		// TODO: this were all 0 in my test .blend file, but it uses a material. Don't know why.
		CArrayFacade<Byte> matbits = factory.newCArrayBlock(BlockCodes.ID_DATA, Byte.class, 4);
		matbits.fromArray(new byte[]{0,0,0,0});
		return matbits;
	}

	private static CPointer<CPointer<Material>> createObjectMaterialLink() throws IOException {
		// This is an array of pointers on materials

		// Create the block for the pointer array with one entry
		CPointer<CPointer<Material>> mat = factory.newCPointerBlock(BlockCodes.ID_DATA, new Class[]{CPointer.class, Material.class});
		
		// Set the first pointer to null
		// later: set object to material link
		mat.set(Null.cast(Material.class));
		return mat;
	}

	private static Material createMaterial() throws IOException {
		//
		// Create block with the material we are using
		//
		
		
		Material mat = factory.newCStructBlock(BlockCodes.ID_MA, Material.class);
		mat.setSss_error(0.05f);
		mat.setRoughness(0.5f);
		mat.getSss_radius().fromArray(new float[]{1,1,1});
		mat.setMaterial_type((short) 0);
		mat.setRgbsel((byte) 0);
		mat.setFresnel_tra(0);
		mat.setVcol_alpha((short) 0);
		mat.setMirb(1);
		mat.setShad_alpha(1);
		mat.setSpec(0.5f);
		mat.setMode2(1);
		mat.setRay_depth_tra((short) 2);
		mat.setMirg(1);
		mat.setGroup(Null.cast(Group.class));
		mat.setRampblend_col((byte) 0);
		mat.setAng(1);
		mat.setMirr(1);
		mat.setDynamode((short) 0);
		mat.setFilter(0);
		ID id = mat.getId();
		
		// init id
		// list of ID properties will be set later
		initId(id, "MA" + "MyMaterial", 1024, 1, 0);
		
		mat.setZoffs(0.0f);
		mat.setMapto((short) 1);
		mat.setRamp_col(Null.cast(ColorBand.class));
		mat.setFriction(0.5f);
		mat.setRamp_show((short) 0);
		mat.setPr_texture((short) 0);
		mat.getSss_col().fromArray(new float[]{0.6038274f, 0.6038274f, 0.6038274f});
		mat.setFresnel_mir(0);
		mat.setSpec_shader((short) 0);
		mat.setNodetree(Null.cast(bNodeTree.class));
		// later: set preview image
		mat.setPreview(Null.cast(PreviewImage.class));
		mat.setShade_flag((short) 4);
		mat.setAmb(1);
		mat.setAdapt_thresh_tra(0.005f);
		mat.getParam().fromArray(new float[]{0.5f,0.1f,0.5f,0.1f});
		mat.setFadeto_mir((short) 0);
		mat.setDarkness(1);
		mat.setTx_limit(0);
		mat.setRms(0.1f);
		mat.setAniso_gloss_mir(1);
		mat.setRef(0.8f);
		mat.setAmbg(0);
		mat.setSss_scale(0.1f);
		mat.setMode2_l(0);
		mat.setAmbb(0);
		
		mat.setTot_slots((short) 0);
		
		mat.setFlaresize(1);
		mat.setMapto_textured(1);
		mat.setTranslucency(0);
		mat.setSamp_gloss_tra((short) 18);
		mat.setRampfac_spec(1);
		mat.setFresnel_mir_i(1.25f);
		mat.setSss_front(1);
		mat.setMl_flag((short) 0);
		mat.setFlarec((short) 1);
		mat.setAmbr(0);
		mat.getStrand_uvname().fromString("");
		mat.setUse_nodes((byte) 0);
		
		mat.setTexpaintslot(Null.cast(TexPaintSlot.class));
		CArrayFacade<CArrayFacade<Byte>> nmap_tangent_names = mat.getNmap_tangent_names();
		for (CArrayFacade<Byte> ntn : nmap_tangent_names) {
			ntn.fromString("");
		}
		
		mat.setRampin_col((byte) 0);
		mat.setReflect(0);
		mat.setR(0.8f);
		mat.setStrand_surfnor(0);
		mat.setPr_lamp((short) 3);
		mat.setSeptex(0);
		mat.setDiff_shader((short) 0);
		mat.setStrand_widthfade(0);
		mat.setMapflag((byte) 0);
		mat.setSpecr(1);
		mat.setG(0.8f);
		mat.setSbias(0);
		mat.setRampfac_col(1);
		mat.setEmit(0);
		mat.setStrand_end(1);
		mat.setB(0.8f);
		mat.setAlpha(1);
		mat.setRampblend_spec((byte) 0);
		mat.setHar((short) 50);
		mat.getGpumaterial().setFirst(Null);
		mat.getGpumaterial().setLast(Null);
		mat.setSss_back(1);
		mat.setDist_mir(0);
		mat.setFlareboost(1);
		mat.setRingc((short) 4);
		mat.setSss_colfac(1);
		mat.setSss_flag((short) 0);
		mat.setSss_texfac(0);
		mat.setIpo(Null.cast(Ipo.class));
		mat.setStrand_ease(0);
		mat.setGloss_tra(1);
		// later: set to address of mtex[0]
		mat.getMtex().set(Null.cast(MTex.class));
		mat.setFh(0);

		// TODO: meaning
		mat.setSeed1((byte) 0);
		
		VolumeSettings vol = mat.getVol();
		vol.getEmission_col().fromArray(new float[]{1,1,1});
		vol.setStepsize_type((short) 0);
		vol.setScattering(1);
		vol.setReflection(1);
		vol.getReflection_col().fromArray(new float[]{1,1,1});
		vol.setAsymmetry(0);
		vol.setDepth_cutoff(0.01f);
		vol.setStepsize(0.2f);
		vol.setEmission(0);
		vol.setMs_diff(1);
		vol.setMs_intensity(1);
		// TODO: meaning
		vol.setShadeflag((short) 8);
		vol.setMs_spread(0.2f);
		vol.setPrecache_resolution((short) 50);
		vol.setDensity(1);
		vol.setDensity_scale(1);
		vol.setShade_type((short) 1);
		vol.getTransmission_col().fromArray(new float[]{1,1,1});

		// TODO: meaning
		mat.setSeed2((byte) 6);
		mat.setTexact((byte) 0);
		mat.setSpecb(1);
		mat.setRay_mirror(0);
		mat.setSpecg(1);
		mat.setSamp_gloss_mir((short) 18);
		mat.setSss_ior(1.3f);
		mat.setRefrac(4);
		mat.setPr_type((byte) 1);
		mat.setStarc((short) 4);
		mat.setFhdist(0);
		// TODO: This is probably the index of this material in Object
		mat.setIndex((short) 0);
		
		mat.setNmap_tangent_names_count(0);
		
		mat.setSss_preset((short) 0);
		mat.setRampin_spec((byte) 0);
		mat.setTx_falloff(1);
		mat.setFresnel_tra_i(1.25f);
		mat.setXyfrict(0);
		mat.setSubsize(1);
		mat.setSpectra(1);
		mat.setLinec((short) 12);
		mat.setFlag((short) 1);
		mat.setShadowonly_flag((short) 0);
		mat.setHasize(0.5f);
		mat.setAdapt_thresh_mir(0.005f);
		mat.setAdd(0);
		mat.setStrand_sta(1);
		mat.setGloss_mir(1);
		
		mat.getLine_col().fromArray(new float[]{0,0,0,1});
		
		// TODO: meaning
		int mode = ADD_RUNTIME_INFO ? 54526019 : 0;
		
		mat.setMode(mode);
		
		if (ADD_RUNTIME_INFO) {
			mat.setTexco((short) 2576);
		} else {
			// runtime info
			mat.setTexco((short) 0);
		}
		mat.setRay_depth((short) 2);
		mat.setRamp_spec(Null.cast(ColorBand.class));
		// TODO: relationship to mode
		// runtime
		mat.setMode_l(mode);
		
		GameSettings game = mat.getGame();
		game.setAlpha_blend(0);
		game.setFlag(16);
		game.setFace_orientation(0);
		
		mat.setAdt(Null.cast(AnimData.class));
		mat.setStrand_min(1);
		mat.setLbias(0);
		return mat;
	}

	private static PartDeflect createPartDeflect() throws IOException {
		// Has to do with effects.
		
		
		PartDeflect pd = factory.newCStructBlock(BlockCodes.ID_DATA, PartDeflect.class);
		
		pd.setF_noise(0.0f);
		pd.setRng(Null);
		pd.setPdef_sbdamp(0.1f);
		pd.setTex_mode((short)0);
		pd.setF_source(Null.cast(BlenderObject.class));
		pd.setFalloff((short)0);
		pd.setZdir((short) 0);
		pd.setDeflect((short) 0);
		pd.setF_flow(0.0f);
		pd.setMinrad(0);
		pd.setClump_fac(0.0f);
		pd.setKink_axis((short) 0);
		pd.setTex(Null.cast(Tex.class));
		pd.setPdef_stickness(0.0f);
		pd.setF_power_r(0.0f);
		pd.setFree_end(0.0f);
		pd.setMindist(0.0f);
		
		// TODO: I guess it's random when creating an object
		pd.setSeed(72);

		pd.setShape((short) 0);
		pd.setTex_nabla(0.0f);
		pd.setPdef_rdamp(0.0f);
		pd.setF_size(0.0f);
		pd.setForcefield((short) 0);
		
		pd.setPdef_sboft(0.02f);
		// TODO: meaning
		pd.setFlag(49152);
		pd.setF_damp(1.0f);
		pd.setPdef_sbift(0.2f);
		pd.setPdef_perm(0.0f);
		pd.setKink((short) 0);
		pd.setF_power(0);
		pd.setAbsorption(0);
		pd.setPdef_rfrict(0);
		pd.setMaxrad(0);
		pd.setKink_freq(0);
		pd.setMaxdist(0);
		pd.setPdef_frict(0);
		pd.setKink_amp(0);
		pd.setKink_shape(0);
		pd.setF_strength(1);
		pd.setClump_pow(0);
		pd.setPdef_damp(0);
		return pd;
	}


}
