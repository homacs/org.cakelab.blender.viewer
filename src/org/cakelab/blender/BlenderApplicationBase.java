package org.cakelab.blender;


import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.app.AbstractAplicationBase;
import org.cakelab.oge.shader.GLException;
import org.lwjgl.glfw.*;
import org.lwjgl.system.Platform;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*; // for constants like GL_TRUE
import static org.lwjgl.system.MemoryUtil.*;




public abstract class BlenderApplicationBase extends AbstractAplicationBase {
	

	
	public BlenderApplicationBase(String windowTitle) throws GLException {
		this();
		info.title = windowTitle;
	}
	
	public BlenderApplicationBase() throws GLException {
		info.setWindowWidth(800);
		info.setWindowHeight(600);
		if (Platform.get()== Platform.MACOSX) {
			info.majorVersion = 3;
			info.minorVersion = 2;
		} else {
			info.majorVersion = 4;
			info.minorVersion = 3;
		}
		info.samples = 4;
		info.flags.cursor = true;
		info.flags.fullscreen = false;
		info.flags.stereo = false;
		info.flags.vsync = false;
		if (DEBUG) {
			info.flags.debug = true;
		}
	}
	
	
	
	@Override
	public void createWindow() {


		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, info.majorVersion);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, info.minorVersion);
		// using compatibility profile to support older opengl functions
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_COMPAT_PROFILE);
		
		if (DEBUG) {
			glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GL_TRUE);
		}
		
		glfwWindowHint(GLFW_SAMPLES, info.samples);
		glfwWindowHint(GLFW_STEREO, info.flags.stereo ? GL_TRUE : GL_FALSE);

		glfwWindowHint(GLFW_ALPHA_BITS, 0);
		glfwWindowHint(GLFW_DEPTH_BITS, 32);
		glfwWindowHint(GLFW_STENCIL_BITS, 0);
		long monitor = 0;
		if (info.flags.fullscreen) {
			monitor = glfwGetPrimaryMonitor();
			GLFWVidMode mode = glfwGetVideoMode(monitor);

			info.setWindowWidth(mode.width());
			info.setWindowHeight(mode.height());
			glfwWindowHint(GLFW_RED_BITS, mode.redBits());
			glfwWindowHint(GLFW_GREEN_BITS, mode.greenBits());
			glfwWindowHint(GLFW_BLUE_BITS, mode.blueBits());
		} else {
			glfwWindowHint(GLFW_RED_BITS, 8);
			glfwWindowHint(GLFW_GREEN_BITS, 8);
			glfwWindowHint(GLFW_BLUE_BITS, 8);
		}

		window = glfwCreateWindow(info.getWindowWidth(), info.getWindowHeight(),
				info.title, monitor, 0);

		if (info.flags.fullscreen) setVSync(info.flags.vsync);
		
		if (window == NULL) {
			glfwTerminate();
			throw new RuntimeException("Failed to open window\n");
		}
	}



	public void run() throws GLException {

		exitStatus = 0;
		try {
		

			init();
			
			startup();
	
			boolean running = true;
			while (running) {

				context.setViewport(0, 0, info.getWindowWidth(), info.getWindowHeight());
				context.clearRGBA(0.5f, 0.5f, 0.5f, 1.0f);
				context.clearDepth(1.0f);

				
				render(glfwGetTime(), context);
	
				// Both buffers are full, one is displayed and the other waits to be swapped in after sync
				glfwSwapBuffers(window);
				// TODO: triple buffering, would allow rendering ahead of static and predictable objects
				
		        /* Poll for and process events */
		        glfwPollEvents();
	
				if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS){
					running = false;
				} else if (glfwWindowShouldClose(window)) {
					running = false;
				}
			}
	
			shutdown();

		} catch (Throwable t) {
			t.printStackTrace();
			exitStatus = -1;
		}

		exit(exitStatus);
	}

	protected abstract void startup() throws Throwable;

	/** called from main loop to render the next frame */
	protected abstract void render(double currentTime, GraphicContext gcontext) throws Throwable;
	
	protected abstract void shutdown() throws Throwable;




}
