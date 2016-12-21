package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform4f;

import java.io.FileInputStream;
import java.io.IOException;

import org.cakelab.blender.io.Generic3DObject;
import org.cakelab.blender.io.Generic3DRenderAssets;
import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.VisualObject;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;
import org.joml.Vector4f;



public class SimpleBaseColorRenderer extends Renderer {
	private int uniform_basecolor;

	public SimpleBaseColorRenderer() throws GLException, IOException {
		loadShaders();
		
	}


	private void loadShaders() throws GLException, IOException {
		VertexShader vs = new VertexShader("basecolor vertex shader", 
				new FileInputStream("resources/shaders/basecolor/render.vs.glsl"));
		FragmentShader fs = new FragmentShader("basecolor fragment shader", 
				new FileInputStream("resources/shaders/basecolor/render.fs.glsl"));

		setShaderProgram(new Program("basecolor shader program", vs, fs));
		
		vs.delete();
		fs.delete();
		
		uniform_basecolor = glGetUniformLocation(this.shaderProgram.getProgramId(), "basecolor");

	}

	public void delete() {
	}

	
	@Override
	public void prepareRenderPass(GraphicContext context, double currentTime) {
	}

	@Override
	public void draw(double currentTime, VisualObject vobj) {
		Generic3DObject o = (Generic3DObject) vobj;
		Generic3DRenderAssets assets = (Generic3DRenderAssets) o.getRenderAssets();

		// not the fastest method of course ..
		assets.bind();
		Vector4f basecolor = o.getBaseColor();
		if (assets.getMaterial().isEmitter()) {
			basecolor = new Vector4f(basecolor);
			basecolor.mul(assets.getMaterial().getEmitterIntensity());
		}
		glUniform4f(uniform_basecolor, basecolor.x, basecolor.y, basecolor.z, basecolor.w);

		
		glDrawArrays(assets.getDrawingMethod(), 0, assets.getNumVertices());
	}


	@Override
	public boolean needsNormals() {
		return false;
	}

}
