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
	// TODO: text console
	
	private boolean active;

	private Frame frame;
	private Text text;

	
	private int width = 230;
	private int height = 80;

	private RenderSetup setup2d;
	private Module module;

	public ConsoleControl(Module module, RenderSetup setup) throws GLException, IOException {
		super();
		this.module = module;
		
		setup2d = new RenderSetup(module, new Renderer2DLibrary(module)); 
		
		
		
		frame = new Frame(width, height);
		setup2d.setup(frame);
		text = new Text(width, height);
		setup2d.setup(text);

		// initially we put the console in the centre
		frame.setPosition(-width/2, -height/2);
		text.setPosition(-width/2, -height/2);
		active = true;
	}

	/** updates position of the console on changes to window size */
	public void setView(int winWidth, int winHeight) {
		int x = -winWidth/2;
		int y = -winHeight/2;
		int horizontal_border = 15;
		int vertical_border = 5;
		frame.setPosition(x, y);
		text.setPosition(x+horizontal_border, y+vertical_border);
	}
	

	public void setText(String _text) {
		text.setText(_text);
		try {
			// update mesh
			setup2d.setup(text);
		} catch (GLException e) {
			// TODO throw?
			e.printStackTrace();
		}

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
