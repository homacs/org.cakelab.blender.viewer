package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.cakelab.blender.io.Generic3DObject;
import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.Lamp;
import org.cakelab.oge.RenderAssets;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.VisualObject;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;
import org.joml.Vector3f;
import org.joml.Vector4f;



public class PhongTexPerFragmentRenderer extends Renderer {
	private int uniform_diffuse_color;
	private int uniform_specular_color;
	private int uniform_light_pos;
	private int uniform_specular_power;
	private int uniform_ambient_color;
	
	
	public PhongTexPerFragmentRenderer() throws GLException, IOException {
		loadShaders();
	}

	private void loadShaders() throws GLException, IOException{
		File file = new File("resources/shaders/phonglighting/per-fragment-phong-tex.vs.glsl");
		VertexShader vs = new VertexShader("per-fragment-tex phong vertex shader", 
				new FileInputStream(file));
		FragmentShader fs = new FragmentShader("per-fragment-tex phong fragment shader", 
				new FileInputStream("resources/shaders/phonglighting/per-fragment-phong-tex.fs.glsl"));
		Program program = new Program("phong shader program", vs, fs);
		setShaderProgram(program);
		vs.delete();
		fs.delete();
		
		
		uniform_light_pos = shaderProgram.getUniformLocation("light_pos");
		uniform_diffuse_color = shaderProgram.getUniformLocation("diffuse_color");
		uniform_specular_color = shaderProgram.getUniformLocation("specular_color");
		uniform_specular_power = shaderProgram.getUniformLocation("specular_power");
		uniform_ambient_color = shaderProgram.getUniformLocation("ambient_color");
		
	}

	public void delete() {
	}

	
	@Override
	public void prepareRenderPass(GraphicContext context, double currentTime) {
		// TODO support multiple light sources
		ArrayList<Lamp> activeLamps = context.getActiveLamps();
		Lamp light = activeLamps.get(0);
		Vector3f light_color = light.getColor();
		
		BRLampRenderData lampRenderData = (BRLampRenderData) light.getRenderData();
		Vector4f light_pos = lampRenderData.getViewSpacePosition();

		glUniform3f(uniform_light_pos, light_pos.x, light_pos.y, light_pos.z);
		glUniform3f(uniform_specular_color, light_color.x, light_color.y, light_color.z);
		glUniform1f(uniform_specular_power, 128.0f);
		glUniform3f(uniform_ambient_color, 0.1f, 0.1f, 0.1f);
	}

	@Override
	public void draw(double currentTime, VisualObject vobj) {
		Generic3DObject o = (Generic3DObject) vobj;
		RenderAssets assets = o.getRenderAssets();

		assets.bind();
		// TODO mix material color with light color
		// TODO mix material specular with light color?

		Vector4f basecolor = o.getBaseColor();
		glUniform3f(uniform_diffuse_color, basecolor.x, basecolor.y, basecolor.z);

		glDrawArrays(assets.getDrawingMethod(), 0, assets.getNumVertices());
	}

	@Override
	public boolean needsNormals() {
		return true;
	}

}
