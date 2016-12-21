package org.cakelab.blender.render;

import org.cakelab.oge.texture.GPUTexture;

public class BRTextureRenderData implements TextureRenderData {

	private GPUTexture gpuTexture;

	public BRTextureRenderData(GPUTexture gpuTexture) {
		this.gpuTexture = gpuTexture;
	}

	@Override
	public void bind() {
		gpuTexture.bind();
	}

}
