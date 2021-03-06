package org.cakelab.blender.render.renderers.r3d.straight;


import java.io.FileInputStream;
import java.io.IOException;

import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.module.Module;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;
import org.cakelab.oge.utils.SingleProgramRendererBase;



public class SimpleTexRenderer extends SingleProgramRendererBase {
	private int module;


	public SimpleTexRenderer(Module module) throws GLException, IOException {
		this.module = module.getModuleId();
		loadShaders();
		
	}


	private void loadShaders() throws GLException, IOException{
		VertexShader vs = new VertexShader("simpletex vertex shader", 
				new FileInputStream("resources/shaders/simpletex/render.vs.glsl"));
		FragmentShader fs = new FragmentShader("simpletex fragment shader", 
				new FileInputStream("resources/shaders/simpletex/render.fs.glsl"));

		setShaderProgram(new Program("simpletex shader program", vs, fs));
		
		vs.delete();
		fs.delete();
	}

	public void delete() {
	}

	
	@Override
	public void prepareRenderPass(ApplicationContext context, double currentTime) {
	}

	@Override
	public void draw(double currentTime, VisualEntity o) {
		BRObjectRenderData assets = (BRObjectRenderData) o.getModuleData(module);
		assets.bind();
		assets.draw();
	}


	@Override
	public boolean needsNormals() {
		return false;
	}


	@Override
	public boolean needsUv() {
		return true;
	}

}
