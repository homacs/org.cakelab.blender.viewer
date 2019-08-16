package org.cakelab.blender.render.renderers.r2d;

import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;
import static org.lwjgl.opengl.GL20.glUseProgram;

import org.cakelab.oge.Renderer;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.utils.BufferedMatrix4f;

public abstract class SingleProg2DRendererBase implements Renderer {
	protected Program shaderProgram;

	protected BufferedMatrix4f mv_matrix = new BufferedMatrix4f();
	protected int uniform_mv_matrix;
	private int uniform_proj_matrix;

	private double preparedLast;
	
	public void setShaderProgram(Program program) throws GLException {
		shaderProgram = program;
		uniform_mv_matrix = shaderProgram.getUniformLocation("mv_matrix");
		uniform_proj_matrix = shaderProgram.getUniformLocation("proj_matrix");
	}

	public void delete() {
		shaderProgram.delete();
	}

	public Program getProgram() {
		return shaderProgram;
	}

	public int getProjectionMatrixUniform() {
		return uniform_proj_matrix;
	}

	/**
	 * This method is supposed to contain code that needs to be executed
	 * exactly once per render pass. That means in case there are multiple
	 * objects to be rendered by a particular renderer, contents of this 
	 * method is executed once while the {@link #render(ApplicationContext, double, VisualEntity)}
	 * is executed for each object.
	 * 
	 * This method calls prepareRenderPass exactly once for each render pass.
	 */
	public void prepare(ApplicationContext context, double currentTime) {
		if (preparedLast != currentTime) {
			glUseProgram(shaderProgram.getProgramId());
			glUniformMatrix4fv(uniform_proj_matrix, false, context.getProjectionTransform2D().getFloatBuffer());
			prepareRenderPass(context, currentTime);
			preparedLast = currentTime;
		}
	}


	
	public abstract void prepareRenderPass(ApplicationContext context, double currentTime);

	public void render(ApplicationContext context, double currentTime, VisualEntity vobj) {
		mv_matrix.identity()
//			.mul(camera.getMatrices().getViewTransform())
			.mul(vobj.getMatrices().getWorldTransform())
		;
		
		glUniformMatrix4fv(uniform_mv_matrix, false, mv_matrix.getFloatBuffer());
		draw(currentTime, vobj);
	}

	public abstract void draw(double currentTime, VisualEntity vobj);

	public abstract boolean needsNormals();

	public int getUniformLocation(String string) throws GLException {
		return shaderProgram.getUniformLocation(string);
	}

}
