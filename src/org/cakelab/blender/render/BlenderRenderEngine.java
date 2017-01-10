package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import org.cakelab.appbase.log.Log;
import org.cakelab.blender.render.coords.CoordPlane;
import org.cakelab.blender.render.coords.CoordPlaneRenderer;
import org.cakelab.blender.render.data.BRLightRenderData;
import org.cakelab.blender.render.data.BRMeshRenderData;
import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.blender.render.data.BRTextureRenderData;
import org.cakelab.oge.RenderEngine;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.opengl.BufferObject.Usage;
import org.cakelab.oge.opengl.MeshVertexArray;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.scene.LightSource;
import org.cakelab.oge.scene.Scene;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.texture.GPUTexture;
import org.cakelab.oge.texture.TextureImageIO;
import org.cakelab.oge.utils.BufferedMatrix4f;
import org.cakelab.oge.utils.GLAPIHelper;
import org.cakelab.oge.utils.SingleProgramRendererBase;
import org.cakelab.soapbox.model.Mesh;
import org.lwjgl.opengl.GL11;

public class BlenderRenderEngine implements RenderEngine {
	
	private static final int VERTEX_ATTRIBUTE_COORDS = 0;
	private static final int VERTEX_ATTRIBUTE_NORMAL = 1;
	private static final int VERTEX_ATTRIBUTE_UV = 4;

	
	private BufferedMatrix4f projection = new BufferedMatrix4f();
	private SimpleBaseColorTexRenderer simpleBaseColorTexRenderer;
	private SimpleBaseColorRenderer simpleBaseColorRenderer;
	@SuppressWarnings("unused")
	private PhongPerVertexRenderer phongPerVertexRenderer;
	private PhongPerFragmentRenderer phongPerFragmentRenderer;
	private PhongTexPerFragmentRenderer phongTexPerFragmentRenderer;
	private NormalRenderer normalRenderer;
	private boolean renderNormals;
	private boolean renderMesh;
	private CoordPlaneRenderer coordsRenderer;
	private CoordPlane coords;
	
	
	@Override
	public void setup(Scene scene) throws GLException {

		setupRenders();
		
		
		// TODO: not for transparent objects
		glEnable(GL_CULL_FACE);
		// front face counter clockwise
		glFrontFace(GL_CCW);

		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		
		
		for (VisualEntity ob : scene.getVisualObjects()) {
			try {
				if (!(ob instanceof VisualMeshEntity)) {
					Log.warn("Renderer has no proper method to render objects without a mesh");
				} else {
					setup((VisualMeshEntity)ob);
				}
			} catch (IOException e) {
				throw new GLException(e);
			}
		}
		
		for (LightSource lamp : scene.getLightSources()) {
			setupLamp(lamp);
		}
	}

	private void setupLamp(LightSource lamp) {
		BRLightRenderData renderData = new BRLightRenderData(lamp);
		lamp.setRenderData(renderData);
	}

	private void setupRenders() throws GLException {
		try {
			simpleBaseColorTexRenderer = new SimpleBaseColorTexRenderer();
			simpleBaseColorRenderer = new SimpleBaseColorRenderer();
			phongPerVertexRenderer = new PhongPerVertexRenderer();
			phongPerFragmentRenderer = new PhongPerFragmentRenderer();
			phongTexPerFragmentRenderer = new PhongTexPerFragmentRenderer();
			normalRenderer = new NormalRenderer();
			coordsRenderer = new CoordPlaneRenderer();
			coords = new CoordPlane();
		} catch (IOException e) {
			throw new GLException(e);
		}
		
	}

	private void setup(VisualMeshEntity gob) throws GLException, IOException {
		
		Mesh mesh = gob.getMesh();
		Material material = gob.getMaterial();
		MeshVertexArray vao = new MeshVertexArray(mesh, VERTEX_ATTRIBUTE_COORDS, Usage.STATIC_DRAW);
		TextureImage textureImage = material.getColorTexture();
		SingleProgramRendererBase renderer;
		if (textureImage != null && mesh.hasUVCoordinates()) {
			
			/*
			 * TODO determine attribute arguments from mesh data
			 */
			int attrIdxTexCoord = VERTEX_ATTRIBUTE_UV;
			int uvOffset 	    = mesh.getUVOffset(); /* offset to uv coords in each vector */
			int size 		    = 2;
			vao.declareVertexAttribute(attrIdxTexCoord, uvOffset, size);
			
			
			GPUTexture gpuTexture = createGPUTexture(textureImage);
			BRTextureRenderData renderData = new BRTextureRenderData(gpuTexture);
			textureImage.setRenderData(renderData);
			
			if (material.isLightEmitting()) {
				renderer = simpleBaseColorTexRenderer;
			} else {
				renderer = phongTexPerFragmentRenderer;
			}
		} else {
			if (material.isLightEmitting()) {
				renderer = simpleBaseColorRenderer;
			} else {
				renderer = phongPerFragmentRenderer;
			}
		}

		
		
		if (renderer.needsNormals()) {
			int normalsOffset = mesh.getNormalsOffset();
			assert(mesh.hasNormals());
			vao.declareVertexAttribute(VERTEX_ATTRIBUTE_NORMAL, normalsOffset, 3);
		}
		
		
		mesh.setRenderData(new BRMeshRenderData(vao));
		
		BRObjectRenderData renderAssets = new BRObjectRenderData(mesh, material);
		
		renderAssets.setRenderer(renderer);
		gob.setRenderData(renderAssets);
		
	}

	private GPUTexture createGPUTexture(TextureImage image) throws IOException {
		return new TextureImageIO(image.getImage(), 
				image.getPixelFormat(), image.isFlipped(), false, GL11.GL_NEAREST, GL11.GL_NEAREST);
	}
	
	@Override
	public void setView(int width, int height, float fov) {
		float aspectRatio = (float) width / (float) height;
		projection.setPerspective((float) Math.toRadians(50.0f), aspectRatio, 0.1f, 1000.0f);
	}

	@Override
	public void render(ApplicationContext context, double currentTime, Scene scene) {
		glViewport(0, 0, context.getWindowWidth(), context.getWindowHeight());
		GLAPIHelper.glClearBuffer4f(GL_COLOR, 0, 0.0f, 0.0f, 0.0f, 1.0f);
		GLAPIHelper.glClearBuffer1f(GL_DEPTH, 0, 1f);

		context.setProjectionTransform(projection);

		for (LightSource lamp : context.getActiveLamps()) {
			BRLightRenderData renderData = (BRLightRenderData) lamp.getRenderData();
			renderData.update(context, currentTime);
		}
		
		SingleProgramRendererBase previousRenderer = null;
		for (VisualEntity vobj : scene.getVisualObjects()) {
			BRObjectRenderData renderData = (BRObjectRenderData) vobj.getRenderData();
			SingleProgramRendererBase renderer = renderData.getRenderer();
			if (renderer != previousRenderer) {
				// TODO [1] remove hack
				currentTime++;
				previousRenderer = renderer;
			}
			renderer.prepare(context, currentTime);
			renderer.render(context, currentTime, vobj);
		}

		if (renderNormals) {
			// draw HUD elements over the current scene
			// TODO: [6] what about transparent HUDs?
			GLAPIHelper.glClearBuffer1f(GL_DEPTH, 0, 1f);
			for (VisualEntity vobj : scene.getVisualObjects()) {
				SingleProgramRendererBase renderer = normalRenderer;
				renderer.prepare(context, currentTime);
				renderer.render(context, currentTime, vobj);
			}
			coordsRenderer.prepare(context, currentTime);
			coordsRenderer.render(context, currentTime, coords);
		}
	}

	@Override
	public void toggleNormalView() {
		this.renderNormals = !this.renderNormals;
	}
	@Override
	public void toggleMeshView() {
		this.renderMesh = !this.renderMesh;
	}
}
