package org.cakelab.blender;

import java.io.File;
import java.util.ArrayList;

import org.cakelab.appbase.log.ConsoleLog;
import org.cakelab.appbase.log.Log;
import org.cakelab.blender.io.BlenderIO;
import org.cakelab.blender.render.BlenderRenderEngine;
import org.cakelab.oge.Camera;
import org.cakelab.oge.RenderEngine;
import org.cakelab.oge.app.ApplicationBase;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.scene.DynamicObject;
import org.cakelab.oge.scene.Scene;
import org.cakelab.soapbox.Player;
import org.lwjgl.glfw.GLFW;

public class BlenderViewer extends ApplicationBase {
	private RenderEngine engine;
	private Scene scene;
	private Player player;

	
	// TODO support switching between fullscreen and windowed mode
	
	public BlenderViewer() throws Throwable {
		super("Blender Viewer");
		Log.addLogListener(new ConsoleLog());

		engine = new BlenderRenderEngine();
		
		info.flags.fullscreen = true;
		info.flags.vsync = false;
		player = new Player();
//		String filename = "/media/homac/DATA/Graphics/2.7/Barrel/Barrel-Ready.blend";
//		String filename = "resources/suzanne.blend";
//		String filename = "resources/suzanne-scene.blend";
//		String filename = "resources/cube.blend";
//		String filename = "resources/common-can+mat.blend";
		String filename = "resources/xyz-scene.blend";
//		String filename = "resources/simple-cube.blend";
		BlenderIO io = new BlenderIO(new File(filename));
		scene = io.loadScene();
		
		// setup camera
		ArrayList<Camera> cams = io.getCameras();
		if (!cams.isEmpty()) player.getCamera().set(cams.get(0));

	}

	@Override
	protected void startup() throws Throwable {

		engine.setup(scene);
		// FIXME mouse cursor missing even outside of the window 
		setVirtualCursor(true);
	}

	@Override
	public void process(double currentTime, ApplicationContext context) throws Throwable {
		player.update(currentTime);
		
		for (DynamicObject vobj : scene.getDynamicObjects()) {
			vobj.update(currentTime);
		}
		context.setActiveCamera(player.getCamera());
		context.setActiveLamps(scene.getLightSources());
		engine.render(context, currentTime, scene);

	}

	@Override
	protected void shutdown() throws Throwable {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected synchronized void onKey(int key, int scancode, int action, int mods)
			throws Throwable {
	    if (action == GLFW.GLFW_PRESS || action == GLFW.GLFW_RELEASE)
	    {
	    	float move = 10f;
	    	if (action == GLFW.GLFW_RELEASE) move = -move;
	        switch (key)
	        {
	            case 'W': player.addTranslationVelocity(0f, 0f, -move);
	                break;
	            case 'S': player.addTranslationVelocity(0f, 0f, move);
	                break;
	            case 'A': player.addTranslationVelocity(-move, 0f, 0f);
	                break;
	            case 'D': player.addTranslationVelocity(move, 0f, 0f);
	                break;
	            case 'R': player.addTranslationVelocity(0f, move, 0f);
	            	break;
	            case 'F': player.addTranslationVelocity(0f, -move, 0f);
	                break;
	            case 'Q': player.addRotationVelocity(0f, 0f, move*5);
	            	break;
	            case 'E': player.addRotationVelocity(0f, 0f, -move*5);
            		break;
	            case 'N': if ((action == GLFW.GLFW_PRESS)) engine.toggleNormalView();
        			break;
	            case 'M': if ((action == GLFW.GLFW_PRESS)) engine.toggleMeshView();
	            	break;
	            case GLFW.GLFW_KEY_LEFT_SHIFT:
	            case GLFW.GLFW_KEY_RIGHT_SHIFT:
	            	player.setVelocityMultiplyier(((action == GLFW.GLFW_PRESS) ? 2.0f : 1.0f));
	            	break;
	            case GLFW.GLFW_KEY_LEFT_CONTROL:
	            case GLFW.GLFW_KEY_RIGHT_CONTROL:
	            	player.setVelocityMultiplyier(((action == GLFW.GLFW_PRESS) ? 0.5f : 1.0f));
	            	break;
	            case GLFW.GLFW_KEY_ESCAPE:
	            	requestExit(0);
	            	break;
	            default:
	                break;
	        }
	    }

	}


	@Override
	protected synchronized void onMouseMove(double xpos, double ypos, double xmov, double ymov) {
		double f = 0.03;
		player.addRotation((float)(ymov * f), (float)(xmov * -f), 0);
	}

	@Override
	protected synchronized void onResize(int w, int h) throws Throwable {
		super.onResize(w, h);
		engine.setView(w, h, player.getCamera().getFoV());
	}

	
	public static void main (String[] args) throws Throwable {
		BlenderViewer viewer = new BlenderViewer();
		viewer.run();
	}
}
