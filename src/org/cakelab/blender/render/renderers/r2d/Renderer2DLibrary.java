package org.cakelab.blender.render.renderers.r2d;

import java.io.IOException;

import org.cakelab.blender.render.renderers.RendererLibrary;
import org.cakelab.blender.render.renderers.r2d.colored.Colored2DMeshRenderer;
import org.cakelab.blender.render.renderers.r2d.textured.Textured2DMeshRenderer;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.module.Module;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.shader.GLException;

public class Renderer2DLibrary implements RendererLibrary {

	private boolean initialised;
	
	Textured2DMeshRenderer texturedMeshRenderer;
	Renderer coloredMeshRenderer;

	private Module module;

	

	public Renderer2DLibrary(Module module) {
		this.module = module;
	}

	@Override
	public Renderer selectRenderer(VisualEntity o) throws GLException {
		checkInit();
		Material material = o.getMaterial();
		if (material != null && material.hasTextures()) {
			return texturedMeshRenderer;
		} else {
			return coloredMeshRenderer;
		}
	}

	private void checkInit() throws GLException {
		if (initialised) return;
		
		try {
			texturedMeshRenderer = new Textured2DMeshRenderer(module);
			coloredMeshRenderer = new Colored2DMeshRenderer(module);
		} catch (IOException e) {
			throw new GLException(e);
		}
		
		initialised = true;
	}

}
