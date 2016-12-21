package org.cakelab.blender.test;


import org.cakelab.appbase.log.ConsoleLog;
import org.cakelab.appbase.log.Log;
import org.cakelab.blender.BlenderApplicationBase;
import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.shader.GLException;
import org.lwjgl.system.Platform;

import static org.lwjgl.glfw.GLFW.*;




public abstract class TestBase extends BlenderApplicationBase {
	

	
	public TestBase(Class<?> clazz) throws GLException {
		Log.addLogListener(new ConsoleLog());

		info.title = "Testing " + clazz.getSimpleName();
		info.setWindowWidth(800);
		info.setWindowHeight(600);
		if (Platform.get()== Platform.MACOSX) {
			info.majorVersion = 3;
			info.minorVersion = 2;
		} else {
			info.majorVersion = 4;
			info.minorVersion = 3;
		}
		info.samples = 0;
		info.flags.cursor = true;
		info.flags.fullscreen = false;
		info.flags.stereo = false;
		info.flags.vsync = false;
		if (DEBUG) {
			info.flags.debug = true;
		}
	}
	
	
	
	public void run() throws GLException {

		exitStatus = 0;
		try {
		

			init();
			
			startup();
	

			context.setViewport(0, 0, info.getWindowWidth(), info.getWindowHeight());
			context.clearRGBA(0.0f, 0.0f, 0.0f, 1.0f);
			context.clearDepth(1.0f);

			
			test(context);

			// Both buffers are full, one is displayed and the other waits to be swapped in after sync
			glfwSwapBuffers(window);
			// TODO: triple buffering, would allow rendering ahead of static and predictable objects
			
	        /* Poll for and process events */
	        glfwPollEvents();

			shutdown();

		} catch (Throwable t) {
			t.printStackTrace();
			exitStatus = -1;
		}

		exit(exitStatus);
	}

	protected void startup() throws Throwable {
		// default: empty
	}

	@Override
	protected void render(double currentTime, GraphicContext gcontext) throws Throwable {
		// intentionally left empty
	}

	/** called from main loop to render the next frame */
	protected abstract void test(GraphicContext gcontext) throws Throwable;
	
	protected void shutdown() throws Throwable {
		// default: empty
	}




}
