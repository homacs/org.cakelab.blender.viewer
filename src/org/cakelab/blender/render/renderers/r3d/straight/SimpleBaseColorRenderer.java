package org.cakelab.blender.render.renderers.r3d.straight;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform4f;

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
import org.joml.Vector4f;



public class SimpleBaseColorRenderer extends SingleProgramRendererBase {
	private int uniform_basecolor;
	private int module;

	public SimpleBaseColorRenderer(Module module) throws GLException, IOException {
		this.module = module.getModuleId();
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
	public void prepareRenderPass(ApplicationContext context, double currentTime) {
	}

	@Override
	public void draw(double currentTime, VisualEntity o) {
		BRObjectRenderData assets = (BRObjectRenderData) o.getModuleData(module);

		// not the fastest method of course ..
		assets.bind();
		Vector4f basecolor = o.getMaterial().getColor();
		if (assets.getMaterial().isLightEmitting()) {
			basecolor = new Vector4f(basecolor);
			basecolor.mul(assets.getMaterial().getEmitterIntensity());
		}
		glUniform4f(uniform_basecolor, basecolor.x, basecolor.y, basecolor.z, basecolor.w);

		assets.draw();
	}


	@Override
	public boolean needsNormals() {
		return false;
	}


	@Override
	public boolean needsUv() {
		return false;
	}

}
