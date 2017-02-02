package org.cakelab.blender.render.debug.coords;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.io.IOException;

import org.cakelab.blender.render.debug.coords.resources.CoordPlaneResources;
import org.cakelab.oge.Camera;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.module.Module;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.FragmentShader;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;
import org.cakelab.oge.shader.VertexShader;
import org.cakelab.oge.utils.SingleProgramRendererBase;


public class CoordPlaneRenderer extends SingleProgramRendererBase {

	private int vao;

	public CoordPlaneRenderer (Module module) throws GLException, IOException {
		
		loadModel();
		
		VertexShader vertexShader = new VertexShader("CoordPlane Vertex Shader", CoordPlaneResources.asInputStream(CoordPlaneResources.VERTEX_SHADER));
		FragmentShader fragmentShader = new FragmentShader("CoordPlane Fragment Shader", CoordPlaneResources.asInputStream(CoordPlaneResources.FRAGMENT_SHADER));

		setShaderProgram(new Program("CoordPlane Shader Program", vertexShader, fragmentShader));
		
		vertexShader.delete();
		fragmentShader.delete();
	}

	private void loadModel() {
		vao = glGenVertexArrays();
	}

	
	
	@Override
	public void prepareRenderPass(ApplicationContext context, double currentTime) {
		glBindVertexArray(vao);
	}
	
	public void render(ApplicationContext context, double currentTime, VisualEntity vobj) {
		Camera camera = context.getActiveCamera();
		mv_matrix.identity()
			.mul(vobj.getMatrices().getWorldTransform())
			.rotate(camera.getMatrices().getInverseRotation())
		;
		
		glUniformMatrix4fv(uniform_mv_matrix, false, mv_matrix.getFloatBuffer());
		draw(currentTime, vobj);
	}

	@Override
	public void draw(double currentTime, VisualEntity cube) {
		// Draw 3 lines (i.e. 6 vertices)
        glDrawArrays(GL_LINES, 0, 6);
        
	}

	@Override
	public void delete() {
		glDeleteVertexArrays(vao);
		super.delete();
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
