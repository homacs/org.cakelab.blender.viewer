package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform4f;

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
import org.joml.Vector4f;



public class SimpleBaseColorTexRenderer extends Renderer {
	private int uniform_basecolor;

	public SimpleBaseColorTexRenderer() throws GLException, IOException {
		loadShaders();
		
	}


	private void loadShaders() throws GLException, IOException{
		VertexShader vs = new VertexShader("basecolor_tex vertex shader", 
				new FileInputStream("resources/shaders/basecolor_tex/render.vs.glsl"));
		FragmentShader fs = new FragmentShader("basecolor_tex fragment shader", 
				new FileInputStream("resources/shaders/basecolor_tex/render.fs.glsl"));

		setShaderProgram(new Program("basecolor_tex shader program", vs, fs));
		
		vs.delete();
		fs.delete();
		
		String uniform_name = "basecolor";
		uniform_basecolor = glGetUniformLocation(this.shaderProgram.getProgramId(), uniform_name);
		if (uniform_basecolor == -1) throw new GLException("uniform attribute "+ uniform_name + " not found");

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
		Vector4f basecolor = o.getBaseColor();
		glUniform4f(uniform_basecolor, basecolor.x, basecolor.y, basecolor.z, basecolor.w);

		
		glDrawArrays(assets.getDrawingMethod(), 0, assets.getNumVertices());
	}


	@Override
	public boolean needsNormals() {
		return false;
	}

}
