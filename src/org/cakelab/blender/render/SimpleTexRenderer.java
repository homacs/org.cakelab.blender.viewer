package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL11.glDrawArrays;

import java.io.FileInputStream;
import java.io.IOException;

import org.cakelab.blender.io.Generic3DObject;
import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.RenderAssets;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.VisualObject;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;



public class SimpleTexRenderer extends Renderer {
	public SimpleTexRenderer() throws GLException, IOException {
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
	public void prepareRenderPass(GraphicContext context, double currentTime) {
	}

	@Override
	public void draw(double currentTime, VisualObject vobj) {
		Generic3DObject o = (Generic3DObject) vobj;
		RenderAssets assets = o.getRenderAssets();

		// not the fastest method of course ..
		assets.bind();
		
		glDrawArrays(assets.getDrawingMethod(), 0, assets.getNumVertices());
	}


	@Override
	public boolean needsNormals() {
		return false;
	}

}
