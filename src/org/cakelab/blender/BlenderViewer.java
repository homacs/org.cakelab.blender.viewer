package org.cakelab.blender;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.cakelab.appbase.log.ConsoleLog;
import org.cakelab.appbase.log.Log;
import org.cakelab.blender.io.BlenderInput;
import org.cakelab.blender.render.BlenderRenderEngine;
import org.cakelab.oge.Camera;
import org.cakelab.oge.RenderEngine;
import org.cakelab.oge.app.ApplicationBase;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.scene.DynamicEntity;
import org.cakelab.oge.scene.Scene;
import org.cakelab.soapbox.MovementAdapter;
import org.cakelab.soapbox.FreeCamera;
import org.cakelab.soapbox.Player;
import org.lwjgl.glfw.GLFW;
public class BlenderViewer extends ApplicationBase {
	private RenderEngine engine;
	private Scene scene;
	private MovementAdapter userMovement;
	private Camera camera;

	
	// TODO support switching between fullscreen and windowed mode
	
	public BlenderViewer() throws Throwable {
		super("Blender Viewer");
		Log.addLogListener(new ConsoleLog());

		engine = new BlenderRenderEngine();
		
		info.settings.fullscreen = true;
		info.settings.vsync = true;
		info.settings.fps = 0; // off
		info.settings.softwareThrottle = false;
//		createFreeCam();
		createHeadCam();
//		String filename = "/media/homac/DATA/Graphics/2.7/Barrel/Barrel-Ready.blend";
//		String filename = "examples/suzanne-scene.blend";
		String filename = "examples/xyz-scene.blend";
		loadScene(filename);

//		scene = new TestScene(userMovement);

	}

	private void createHeadCam() {
		Player player = new Player();
		userMovement = player;
		camera = player.getCamera();
	}

	private void createFreeCam() {
		FreeCamera c = new FreeCamera();
		userMovement = c;
		camera = c;
	}

	public void loadScene(String filename) throws IOException {
		BlenderInput io = new BlenderInput(new File(filename));
		scene = io.loadScene(0,1);
		
		// setup camera
		ArrayList<Camera> cams = io.getCameras();
		if (!cams.isEmpty()) {
			// TODO: init cam and movement adapter
			userMovement.init(cams.get(0));
//			player.getCamera().set(cams.get(0));
		}

	}

	@Override
	protected void startup() throws Throwable {
		engine.setup(scene);
		setVirtualCursor(true);
	}

	@Override
	public void process(double currentTime, ApplicationContext context) throws Throwable {
		userMovement.update(currentTime);
		
		for (DynamicEntity vobj : scene.getDynamicEntities()) {
			vobj.update(currentTime);
		}
		context.setActiveCamera(camera);
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
	            case 'W': userMovement.addTranslationVelocity(0f, 0f, move);
	                break;
	            case 'S': userMovement.addTranslationVelocity(0f, 0f, -move);
	                break;
	            case 'A': userMovement.addTranslationVelocity(move, 0f, 0f);
	                break;
	            case 'D': userMovement.addTranslationVelocity(-move, 0f, 0f);
	                break;
	            case 'R': userMovement.addTranslationVelocity(0f, move, 0f);
	            	break;
	            case 'F': userMovement.addTranslationVelocity(0f, -move, 0f);
	                break;
	            case 'Q': userMovement.addRotationVelocity(0f, 0f, -move*5);
	            	break;
	            case 'E': userMovement.addRotationVelocity(0f, 0f, move*5);
            		break;
	            case 'N': if ((action == GLFW.GLFW_PRESS)) engine.toggleNormalView();
        			break;
	            case 'M': if ((action == GLFW.GLFW_PRESS)) engine.toggleMeshView();
	            	break;
	            case GLFW.GLFW_KEY_LEFT_SHIFT:
	            case GLFW.GLFW_KEY_RIGHT_SHIFT:
	            	userMovement.setVelocityMultiplyier(((action == GLFW.GLFW_PRESS) ? 2.0f : 1.0f));
	            	break;
	            case GLFW.GLFW_KEY_LEFT_CONTROL:
	            case GLFW.GLFW_KEY_RIGHT_CONTROL:
	            	userMovement.setVelocityMultiplyier(((action == GLFW.GLFW_PRESS) ? 0.5f : 1.0f));
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
		if (xmov != 0 || ymov != 0) {
			/* In screen space Y is upside down but X is as normal.
			 */
			// If we move the mouse up (-y), we want the pitch to go up
			// which is a negative turn around our local X axis.
			float pitch = (float) (ymov * f);
			
			// If we move the mouse to the right (+x) we want yaw to turn right, which is 
			// a negative turn around our local y axis
			float yaw = (float) -(xmov * f);
			userMovement.addRotation(pitch, yaw, 0);
		}
	}

	@Override
	protected synchronized void onResize(int w, int h) throws Throwable {
		super.onResize(w, h);
		engine.setView(w, h, camera.getFoV());
	}

	
	public static void main (String[] args) throws Throwable {
		System.setProperty("joml.nounsafe", "true");
		BlenderViewer viewer = new BlenderViewer();
		viewer.run();
	}
}
