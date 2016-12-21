package org.cakelab.blender.io;

import org.cakelab.oge.RenderAssets;
import org.cakelab.oge.VisualObject;
import org.joml.Vector4f;

public class Generic3DObject extends VisualObject {

	private Generic3DRenderAssets assets;

	public Generic3DObject(Generic3DRenderAssets assets) {
		this.assets = assets;
	}

	public Generic3DObject(Generic3DRenderAssets assets, float x, float y, float z) {
		super(x,y,z);
		this.assets = assets;
	}

	
	public RenderAssets getRenderAssets() {
		return assets;
	}

	public Vector4f getBaseColor() {
		// TODO reconsider base color and materials
		return assets.getMaterial().getBaseColor();
	}
}
