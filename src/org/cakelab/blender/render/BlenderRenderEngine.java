package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import org.cakelab.appbase.log.Log;
import org.cakelab.blender.render.data.BRLightRenderData;
import org.cakelab.blender.render.data.BRMeshRenderData;
import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.blender.render.data.BRTextureRenderData;
import org.cakelab.blender.render.debug.DebugInterface;
import org.cakelab.blender.render.renderers.r3d.Renderer3DLibrary;
import org.cakelab.oge.DebugView;
import org.cakelab.oge.RenderEngine;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.module.ModuleRegistry;
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
	
	public static final int VERTEX_ATTRIBUTE_COORDS = 0;
	public static final int VERTEX_ATTRIBUTE_NORMAL = 1;
	public static final int VERTEX_ATTRIBUTE_UV = 4;

	private RenderSetup setup;
	private BufferedMatrix4f projection = new BufferedMatrix4f();
	private BufferedMatrix4f projection2d = new BufferedMatrix4f();

	private final int moduleId;
	private DebugInterface debugInterface;
	
	public BlenderRenderEngine() {
		moduleId = ModuleRegistry.registerModule(this);
		
		setup = new RenderSetup(this, new Renderer3DLibrary(this));
		debugInterface = new DebugInterface(this);
	}
	
	
	@Override
	public void setup(Scene scene) throws GLException {
		
		
		// TODO: not for transparent objects
		glEnable(GL_CULL_FACE);
		// front face counter clockwise
		glFrontFace(GL_CCW);

		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		for (VisualEntity ob : scene.getVisualEntities()) {
				setup.setup(ob);
		}
		
		for (LightSource lamp : scene.getLightSources()) {
			setup.setupLamp(lamp);
		}
		
		debugInterface.setup(scene);
	}
	
	@Override
	public void setup(VisualEntity ob) throws GLException {
		setup.setup((VisualMeshEntity)ob);
	}

	
	@Override
	public void setView(int width, int height, float fov) throws GLException {
		float aspectRatio = (float) width / (float) height;
		projection.setPerspective((float) Math.toRadians(fov), aspectRatio, 0.1f, 1000.0f);
		projection2d.scaling(2f/width,2f/height,1f);
		debugInterface.setView(width, height, fov);
	}

	@Override
	public void render(ApplicationContext context, double currentTime, Scene scene) throws GLException {
		glViewport(0, 0, context.getWindowWidth(), context.getWindowHeight());
		GLAPIHelper.glClearBuffer4f(GL_COLOR, 0, 0.0f, 0.0f, 0.0f, 1.0f);
		GLAPIHelper.glClearBuffer1f(GL_DEPTH, 0, 1f);

		context.setProjectionTransform(projection);
		context.setProjectionTransform2d(projection2d);

		for (LightSource lamp : context.getActiveLamps()) {
			BRLightRenderData renderData = (BRLightRenderData) lamp.getRenderData();
			renderData.update(context, currentTime);
		}
		
		Renderer previousRenderer = null;
		for (VisualEntity vobj : scene.getVisualEntities()) {
			BRObjectRenderData renderData = (BRObjectRenderData) vobj.getModuleData(moduleId);
			Renderer renderer = renderData.getRenderer();
			if (renderer != previousRenderer) {
				// TODO [1] remove hack
				currentTime += 0.0000001;
				previousRenderer = renderer;
			}
			renderer.prepare(context, currentTime);
			renderer.render(context, currentTime, vobj);
		}
		
		debugInterface.render(context, currentTime, scene);
	}


	@Override
	public int getModuleId() {
		return moduleId;
	}


	@Override
	public DebugView getDebugView() {
		return debugInterface;
	}


	public RenderSetup getRenderSetup() {
		return setup;
	}
}
