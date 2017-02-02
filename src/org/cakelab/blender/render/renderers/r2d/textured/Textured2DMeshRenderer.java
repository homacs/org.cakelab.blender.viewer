package org.cakelab.blender.render.renderers.r2d.textured;

import static org.lwjgl.opengl.GL20.glUniform4f;

import java.io.IOException;

import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.blender.render.renderers.r2d.SingleProg2DRendererBase;
import org.cakelab.blender.render.renderers.r2d.textured.glsl.T2DMResources;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.module.Module;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;
import org.joml.Vector4f;


public class Textured2DMeshRenderer extends SingleProg2DRendererBase {

	private int uniform_basecolor;
	private int moduleId;

	public Textured2DMeshRenderer (Module module) throws GLException, IOException {
		moduleId = module.getModuleId();
		VertexShader vertexShader = new VertexShader("Console Vertex Shader", T2DMResources.asInputStream(T2DMResources.VERTEX_SHADER));
		FragmentShader fragmentShader = new FragmentShader("Console Fragment Shader", T2DMResources.asInputStream(T2DMResources.FRAGMENT_SHADER));

		setShaderProgram(new Program("Console Shader Program", vertexShader, fragmentShader));
		
		vertexShader.delete();
		fragmentShader.delete();
		
		uniform_basecolor = super.getUniformLocation("basecolor");
	}
	

	public void prepareRenderPass(ApplicationContext context, double currentTime) {
	}
	

	public void draw(double currentTime, VisualEntity o) {
		BRObjectRenderData assets = (BRObjectRenderData) o.getModuleData(moduleId);
		assets.bind();

		Vector4f basecolor = o.getMaterial().getColor();
		glUniform4f(uniform_basecolor, basecolor.x, basecolor.y, basecolor.z, basecolor.w);

		assets.draw();
	}

	public void delete() {
		shaderProgram.delete();
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
