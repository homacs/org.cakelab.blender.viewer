package org.cakelab.blender.io;

import org.joml.Vector4f;

public class Generic3DMaterial {

	private Vector4f basecolor;
	private Generic3DTextureImage colorTexture;
	private float emitter_intensity;

	public Generic3DMaterial(Vector4f basecolor, Generic3DTextureImage texture, float emitter_intensity) {
		this.basecolor = basecolor;
		this.colorTexture = texture;
		this.emitter_intensity = emitter_intensity;
	}

	public boolean hasTextures() {
		return colorTexture != null;
	}

	public boolean isEmitter() {
		return emitter_intensity > 0.00001;
	}

	public float getEmitterIntensity() {
		return emitter_intensity;
	}
	
	public Vector4f getBaseColor() {
		return basecolor;
	}

	public Generic3DTextureImage getColorTexture() {
		return colorTexture;
	}

}
