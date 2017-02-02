package org.cakelab.blender.render.renderers.r3d;

import java.io.IOException;

import org.cakelab.blender.render.renderers.RendererLibrary;
import org.cakelab.blender.render.renderers.r3d.phong.PhongPerFragmentRenderer;
import org.cakelab.blender.render.renderers.r3d.phong.PhongPerVertexRenderer;
import org.cakelab.blender.render.renderers.r3d.phong.PhongTexPerFragmentRenderer;
import org.cakelab.blender.render.renderers.r3d.straight.SimpleBaseColorRenderer;
import org.cakelab.blender.render.renderers.r3d.straight.SimpleBaseColorTexRenderer;
import org.cakelab.oge.RenderEngine;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.oge.shader.GLException;
import org.cakelab.soapbox.model.Mesh;

public class Renderer3DLibrary implements RendererLibrary {
	SimpleBaseColorTexRenderer straightTexturedMeshRenderer;
	SimpleBaseColorRenderer straightColorRenderer;
	PhongPerVertexRenderer phongPerVertexRenderer;
	PhongPerFragmentRenderer shadedColorRenderer;
	PhongTexPerFragmentRenderer shadedTexturedMeshRenderer;
	RenderEngine engine;
	boolean initialised;

	public Renderer3DLibrary(RenderEngine engine) {
		this.engine = engine;
	}
	
	private void checkInit() throws GLException {
		if (initialised) return;
		try {
			straightTexturedMeshRenderer = new SimpleBaseColorTexRenderer(engine);
			straightColorRenderer = new SimpleBaseColorRenderer(engine);
			phongPerVertexRenderer = new PhongPerVertexRenderer(engine);
			shadedColorRenderer = new PhongPerFragmentRenderer(engine);
			shadedTexturedMeshRenderer = new PhongTexPerFragmentRenderer(engine);
			
			initialised = true;
		} catch (IOException e) {
			throw new GLException(e);
		}
		
	}

	@Override
	public Renderer selectRenderer(VisualEntity entity) throws GLException {
		checkInit();
		
		Mesh mesh = (entity instanceof VisualMeshEntity) ? ((VisualMeshEntity)entity).getMesh() : null;
		Material material = entity.getMaterial();
		boolean usesTextures = material.hasTextures() && mesh != null && mesh.hasUVCoordinates();
		
		Renderer renderer;
		
		if (usesTextures) {
			if (material.isLightEmitting()) {
				renderer = straightTexturedMeshRenderer;
			} else {
				renderer = shadedTexturedMeshRenderer;
			}
		} else {
			if (material.isLightEmitting()) {
				renderer = straightColorRenderer;
			} else {
				renderer = shadedColorRenderer;
			}
		}

		return renderer;
	}
}
