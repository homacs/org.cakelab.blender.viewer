package org.cakelab.blender.render;

import java.util.ArrayList;

import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.VisualObject;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.shader.Program;

/**
 * Render stack allows to combine multiple renders in one. 
 * 
 * @author homac
 *
 */
public class RenderStack extends Renderer {
	private ArrayList<Renderer> renderers = new ArrayList<Renderer>();
	
	
	public RenderStack() {
	}

	
	
	
	
	public RenderStack(Renderer ... renderers) {
		for (Renderer renderer : renderers) this.renderers.add(renderer);
	}





	@Override
	public void prepareRenderPass(GraphicContext context, double currentTime) {
		for (Renderer renderer : renderers) {
			renderer.prepareRenderPass(context, currentTime);
		}
	}

	@Override
	public void draw(double currentTime, VisualObject vobj) {
		for (Renderer renderer : renderers) {
			renderer.draw(currentTime, vobj);
		}
	}

	@Override
	public boolean needsNormals() {
		for (Renderer renderer : renderers) {
			if (renderer.needsNormals()) return true;
		}
		return false;
	}





	@Override
	public void setShaderProgram(Program program) throws GLException {
		throw new IllegalArgumentException("not applicable for render stack");
	}





	@Override
	public void delete() {
		for (Renderer r : renderers) {
			r.delete();
		}
	}





	@Override
	public Program getProgram() {
		throw new IllegalArgumentException("not applicable for render stack");
	}





	@Override
	public int getProjectionMatrixUniform() {
		throw new IllegalArgumentException("not applicable for render stack");
	}





	@Override
	public void prepare(GraphicContext context, double currentTime) {
	}





	@Override
	public void render(GraphicContext context, double currentTime, VisualObject vobj) {
		for (Renderer r : renderers) {
			r.prepare(context, currentTime);
			r.render(context, currentTime, vobj);
		}
	}

	
	
	
}
