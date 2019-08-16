package org.cakelab.blender.render.debug;

import static org.lwjgl.opengl.GL11.GL_DEPTH;

import java.io.IOException;

import org.cakelab.blender.render.BlenderRenderEngine;
import org.cakelab.blender.render.debug.console.ConsoleControl;
import org.cakelab.blender.render.debug.coords.CoordPlane;
import org.cakelab.blender.render.debug.coords.CoordPlaneRenderer;
import org.cakelab.blender.render.debug.normals.NormalRenderer;
import org.cakelab.oge.DebugView;
import org.cakelab.oge.RenderEngine;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.scene.Scene;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.utils.GLAPIHelper;

public class DebugInterface implements DebugView, RenderEngine {
	private boolean visible;
	private final int moduleId;

	
	private NormalRenderer normalRenderer;
	private boolean renderNormals = true;
	private boolean renderMesh = true;
	private CoordPlaneRenderer coordsRenderer;
	private CoordPlane coords;
	private ConsoleControl console;
	private BlenderRenderEngine owner;

	
	public DebugInterface(BlenderRenderEngine owner) {
		this.moduleId = owner.getModuleId();
		this.owner = owner;
	}
	
	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public int getModuleId() {
		return moduleId;
	}

	@Override
	public void setup(Scene scene) throws GLException {
		try {
			normalRenderer = new NormalRenderer(this);
			coordsRenderer = new CoordPlaneRenderer(this);
			coords = new CoordPlane();
			console = new ConsoleControl(this, owner.getRenderSetup());
			
			console.setText(  
					  "   ----   KEYS   ----\n"
					+ "F1          - Help/Debug\n"
					+ "ESC         - Exit\n"
					+ "W/A/S/D     - Move\n"
					+ "R/F         - Up/Down");
			
		} catch (IOException e) {
			throw new GLException(e);
		}
	}

	@Override
	public void setup(VisualEntity entity) throws GLException {
	}

	@Override
	public void setView(int width, int height, float fov) throws GLException {
		// update coord plane position
		fov = (float) Math.toRadians(fov);
		float ratio = (float)width/(float)height;
		float Z = 1;
		float Y = (float) (2 * Math.tan(fov / 2) * Z);
		float X = Y * ratio;

		coords.setPosition(X/2*.8f,-Y/2*.8f,-Z);
		ratio *= 0.025f;
		coords.setScale(ratio, ratio, ratio);

		console.setView(width,height);
	}

	@Override
	public void render(ApplicationContext context, double currentTime, Scene scene) throws GLException {
		if (!visible) return;
		
		// we have permission to write over the whole screen
		GLAPIHelper.glClearBuffer1f(GL_DEPTH, 0, 1f);

		if (renderNormals) {
			
			for (VisualEntity vobj : scene.getVisualEntities()) {
				normalRenderer.prepare(context, currentTime);
				normalRenderer.render(context, currentTime, vobj);
			}
			
			coordsRenderer.prepare(context, currentTime);
			coordsRenderer.render(context, currentTime, coords);
		}
		
		if (renderMesh) {
			// TODO [6] render mesh
		}
		
		if (console.isActive()) {
			console.render(context, currentTime);
		}
	}

	@Override
	public DebugView getDebugView() {
		return this;
	}

}
