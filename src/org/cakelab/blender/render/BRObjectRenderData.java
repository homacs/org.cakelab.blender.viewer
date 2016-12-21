package org.cakelab.blender.render;

import org.cakelab.oge.RenderData;
import org.cakelab.oge.Renderer;

public class BRObjectRenderData implements RenderData {

	private Renderer renderer;

	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}

	public Renderer getRenderer() {
		return renderer;
	}

}
