package org.cakelab.blender;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;


import org.cakelab.oge.Camera;
import org.cakelab.oge.scene.DynamicEntity;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.oge.texture.TextureImageIO;
import org.cakelab.soapbox.model.Mesh;
import org.cakelab.soapbox.model.Mesh.FrontFaceVertexOrder;
import org.lwjgl.opengl.GL11;
import org.cakelab.soapbox.model.QuadMesh;
import org.joml.Vector3f;
import org.joml.Vector4f;


/**
 * This is a prototype for true head-up display (HUD) elements: Dynamic transparent 
 * items in front of the viewers eye. 
 * 
 * TODO: move to examples
 * 
 * @author homac
 *
 */
public class HudExample extends VisualMeshEntity implements DynamicEntity {
	
	private Color bgcolor;
	private TextureImage tex;
	private int width;
	private int height;
	private boolean active;
	private Color textColor;
	private Font textFont;

	public HudExample(Camera camera) {
		super();
		bgcolor = new Color(0.5f,0.5f,0.5f,0.5f);
		textColor = new Color(1f,1f,1f,1f);
		textFont = new Font("Serif", Font.BOLD, 20);
		
		
		width = 256;
		// TODO width and height may be different
		height = width;

		super.mesh = createMesh(width, height);

		super.material = createMaterial(width, height);
		// face towards camera
		super.setOrientation(new Vector3f(0,0,-1), new Vector3f(0,1,0));
		//super.setScale(1.0f/height/2.0f, 1.0f/height/2.0f, 1);
		
		// TODO always align with the camera
		setReferenceSystem(camera);

		draw();
	}

	private void draw() {
		BufferedImage img = tex.getImage();
		Graphics2D g = img.createGraphics();
        g.setColor(bgcolor);
        g.fillRect(0,0,width,height);
        
        g.setPaint(textColor);
        g.setFont(textFont);
        String s = "Hello, world!";
        FontMetrics fm = g.getFontMetrics();
        // right aligned
        int x = img.getWidth() - fm.stringWidth(s) - 5;
        int y = fm.getHeight();
        g.drawString(s, x, y);
        
		g.drawLine(0,0,width/2, height/2);
		
        g.dispose();
	}

	private Material createMaterial(int width, int height) {
		tex = createTexture(width, height);
		return new Material(new Vector4f(1,0,0,0), tex, 1f);
	}

	private TextureImage createTexture(int width, int height) {
		WritableRaster raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, width, height, 4, null);
		BufferedImage image = new BufferedImage(TextureImageIO.glAlphaColorModel, raster, false, new Hashtable<String, Object>());
		return new TextureImage(image, GL11.GL_RGBA, true);
	}

	private Mesh createMesh(int width, int height) {
		// TODO vector size of 2 would be great
		int vectorSize = 5;
		int uvPos = 3;
		float uvWidth = 1.0f;
		float uvHeight = 1.0f;
		float z = -.5f;
		float hw = 1.0f/8.0f;
		float hh = 1.0f/8.0f;
		
		float[] coords = new float[]{
				-hw, -hh, z,  0,       0,
				 hw, -hh, z,  uvWidth, 0,
				 hw,  hh, z,  uvWidth, uvHeight,
				-hw,  hh, z,  0,       uvHeight
		};
		return new QuadMesh(FrontFaceVertexOrder.CounterClockwise, vectorSize, coords, uvPos, -1).toTriangleMesh();
	}

	@Override
	public void update(double currentTime) {
		// TODO change the texture
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
