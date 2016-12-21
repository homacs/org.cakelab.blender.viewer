package org.cakelab.blender.io;

import org.cakelab.oge.RenderAssets;
import org.cakelab.soapbox.model.TriangleMesh;
import org.joml.Vector4f;

public class Generic3DRenderAssets extends RenderAssets {

	private Generic3DMaterial material;

	public Generic3DRenderAssets(TriangleMesh mesh) {
		super(mesh, false);
		this.material = new Generic3DMaterial(new Vector4f(0,0,0,1), null, 0f);
	}

	public Generic3DRenderAssets(TriangleMesh mesh, Generic3DMaterial material) {
		super(mesh, false);
		this.material = material;
	}

	@Override
	public void bind() {
		super.bind();
		if (material != null) {
			Generic3DTextureImage texture = material.getColorTexture();
			if (texture != null) texture.getRenderData().bind();
		}
	}

	public Generic3DMaterial getMaterial() {
		return material;
	}
	
}
