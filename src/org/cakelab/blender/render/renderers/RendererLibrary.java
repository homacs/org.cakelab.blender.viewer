package org.cakelab.blender.render.renderers;

import org.cakelab.oge.Renderer;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.GLException;

public interface RendererLibrary {
	Renderer selectRenderer(VisualEntity gob) throws GLException;
}
