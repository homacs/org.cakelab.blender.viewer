package org.cakelab.blender.io;

import java.awt.image.BufferedImage;

import org.cakelab.blender.render.TextureRenderData;

public class Generic3DTextureImage {

	private BufferedImage image;
	private int pixelFormat;
	private boolean flipped;
	private TextureRenderData renderData;

	public Generic3DTextureImage(BufferedImage image, int pixelFormat, boolean flipped) {
		this.image = image;
		this.pixelFormat = pixelFormat;
		this.flipped = flipped;
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getPixelFormat() {
		return pixelFormat;
	}

	public boolean isFlipped() {
		return flipped;
	}

	public void setRenderData(TextureRenderData renderData) {
		this.renderData = renderData;
	}
	
	public TextureRenderData getRenderData() {
		return renderData;
	}



}
