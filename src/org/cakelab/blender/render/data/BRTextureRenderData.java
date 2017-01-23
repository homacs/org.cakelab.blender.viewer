package org.cakelab.blender.render.data;

import org.cakelab.oge.module.ModuleData;
import org.cakelab.oge.texture.GPUTexture;

public class BRTextureRenderData implements ModuleData {

	private GPUTexture gpuTexture;

	public BRTextureRenderData(GPUTexture gpuTexture) {
		this.gpuTexture = gpuTexture;
	}

	public void bind() {
		gpuTexture.bind();
	}

	public void delete() {
		gpuTexture.delete();
	}

}
