package org.cakelab.blender.render.debug.console;

import java.io.IOException;

import org.cakelab.blender.render.RenderSetup;
import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.blender.render.renderers.r2d.Renderer2DLibrary;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.module.Module;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.oge.shader.GLException;


public class ConsoleControl {
	
	private boolean active;

	private Frame frame;
	private Text text;

	private Module module;

	public ConsoleControl(Module module, RenderSetup setup) throws GLException, IOException {
		super();
		this.module = module;
		
		RenderSetup setup2d = new RenderSetup(module, new Renderer2DLibrary(module)); 
		
		
		int width = 256;
		int height = 70;
		
		frame = new Frame(width, height);
		setup2d.setup(frame);
		text = new Text(height, width);
		setup2d.setup(text);
		
		frame.setPosition(-width/2, -height/2);
		text.setPosition(-width/2, -height/2);
		active = true;
	}


	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public void render(ApplicationContext context, double currentTime) {
		
		render(context, currentTime, frame);
		render(context, currentTime, text);
		
	}
	
	private void render(ApplicationContext context, double currentTime, VisualMeshEntity o) {
		BRObjectRenderData data = (BRObjectRenderData) o.getModuleData(module.getModuleId());
		Renderer renderer = data.getRenderer();
		renderer.prepare(context,currentTime);
		renderer.render(context, currentTime, o);
		
	}
	

}
