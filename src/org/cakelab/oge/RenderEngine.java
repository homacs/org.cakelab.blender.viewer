package org.cakelab.oge;

import org.cakelab.oge.shader.GLException;

public interface RenderEngine {
	// TODO clarify rendering model (engine, renderer, shader, shader program, render tasks, render data, etc.)
	void setup(Scene scene) throws GLException;

	void setView(int width, int height, float fov) throws GLException;

	void render(GraphicContext context, double currentTime, Scene scene) throws GLException;

	void toggleNormalView();

	void toggleMeshView();

}
