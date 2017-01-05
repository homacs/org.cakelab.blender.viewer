package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL20.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.cakelab.blender.render.data.BRLightRenderData;
import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.scene.LightSource;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;
import org.cakelab.oge.utils.SingleProgramRendererBase;
import org.joml.Vector3f;
import org.joml.Vector4f;



public class PhongPerVertexRenderer extends SingleProgramRendererBase {
	private int uniform_diffuse_color;
	private int uniform_specular_color;
	private int uniform_light_pos;
	private int uniform_specular_power;
	private int uniform_ambient_color;
	
	
	public PhongPerVertexRenderer() throws GLException, IOException {
		loadShaders();
		
	}

	private void loadShaders() throws GLException, IOException{
		File file = new File("resources/shaders/phonglighting/per-vertex-phong.vs.glsl");
		VertexShader vs = new VertexShader("per-vertex phong vertex shader", 
				new FileInputStream(file));
		FragmentShader fs = new FragmentShader("per-vertex phong fragment shader", 
				new FileInputStream("resources/shaders/phonglighting/per-vertex-phong.fs.glsl"));
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
	public void prepareRenderPass(ApplicationContext context, double currentTime) {
		// TODO support multiple light sources
		ArrayList<LightSource> activeLamps = context.getActiveLamps();
		LightSource light = activeLamps.get(0);
		Vector3f light_color = light.getColor();
		
		BRLightRenderData lampRenderData = (BRLightRenderData) light.getRenderData();
		Vector4f light_pos = lampRenderData.getViewSpacePosition();

		glUniform3f(uniform_light_pos, light_pos.x, light_pos.y, light_pos.z);
		glUniform3f(uniform_specular_color, light_color.x, light_color.y, light_color.z);
		glUniform1f(uniform_specular_power, 128.0f);
		glUniform3f(uniform_ambient_color, 0.1f, 0.1f, 0.1f);
	}

	@Override
	public void draw(double currentTime, VisualEntity o) {
		BRObjectRenderData assets = (BRObjectRenderData) o.getRenderData();

		assets.bind();
		// TODO mix material color with light color
		// TODO mix material specular with light color?

		Vector4f basecolor = o.getMaterial().getColor();
		glUniform3f(uniform_diffuse_color, basecolor.x, basecolor.y, basecolor.z);

		assets.draw();
	}

	@Override
	public boolean needsNormals() {
		return true;
	}

}
