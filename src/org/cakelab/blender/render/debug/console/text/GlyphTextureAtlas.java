package org.cakelab.blender.render.debug.console.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.texture.TextureImageIO;
import org.cakelab.soapbox.model.Mesh;
import org.cakelab.soapbox.model.QuadMesh;
import org.cakelab.soapbox.model.Mesh.FrontFaceVertexOrder;
import org.joml.Vector2f;
import org.lwjgl.opengl.GL11;

public class GlyphTextureAtlas {

	public static class Point {
		float x;
		float y;
	}
	
	
	
	private int atlasWidth;
	private int atlasHeight;
	private float charWidth;
	private float charHeight;
	private int rows;
	private int columns;
	private char firstChar;
	private char lastChar;
	private TextureImage tex;
	private int totalNumChars;
	private FontMetrics fontMetrics;
	private float charUvHeight;
	private float charUvWidth;
	private int charBase;

	public void selectFont(Font font) {
		calcAtlasMetrics(font);
		createAtlasTexture(font);
	}
	
	public void createAtlasTexture(Font font) {
		tex = createTexture(atlasWidth, atlasHeight);
		
		BufferedImage img = tex.getImage();
		Graphics2D g = img.createGraphics();
		
		// font color white 
		// background is transparent
		// -> shader can add color by: fontColor * color;
		Color bgcolor = new Color(0.0f,0.0f,0.0f,0.0f);
		g.setBackground(bgcolor);
		g.clearRect(0, 0, atlasWidth, atlasHeight);
        g.setColor(Color.WHITE);
        g.setFont(font);

        float x = 0;
        float y = -charBase;

        char c = firstChar;  // starting at ascii <space>
        int i;
        for (i = 0; i < totalNumChars; i++, c++) {
            g.drawString(String.valueOf(c), x, y);
            
        	if ((i+1)%columns == 0) {
                y += charHeight;
                x = 0;
        	} else {
        		x+=charWidth;
        	}
        }

        g.dispose();
	}

	private void calcAtlasMetrics(Font font) {
		// create fake image just to get a configured graphics context
		BufferedImage img = createImage(1,1);
		Graphics2D g = img.createGraphics();
		
        g.setFont(font);
        fontMetrics = g.getFontMetrics();

        
        firstChar = 32;            // ASCII <SPC>
        lastChar  = 126;           // ASCII < ~ >
        totalNumChars = lastChar-firstChar+1;  // total num chars
        Rectangle2D bounds = fontMetrics.getMaxCharBounds(g);
        charBase = (int)Math.ceil(bounds.getY());
//        charWidth = fontMetrics.getMaxAdvance(); // char width
//        charHeight = fontMetrics.getHeight();    // char height
        charWidth = (int)Math.ceil(bounds.getWidth()); // char width
        charHeight = (int)Math.ceil(bounds.getHeight());    // char height
        
        
        /*
         * w: char width
         * h: char height
         * n: chars per row (aka columns)
         * m: num rows
         * 
         * conditions:
         *     n * m    = numChars              [1]
         *     n * w    = m * h                 [2]
         * (2)/w:
         *       n      = m * h / w             [3]
         * (3)->(1):
         *   m^2 * h/w  = numChars
         *   m          = (numChars*w/h)^(1/2)  [4]
         */
        // expected: 7/14
        rows = (int) Math.round(  Math.sqrt(((double)totalNumChars)*((double)charWidth)/charHeight)  );
        columns = (int) Math.ceil((float)totalNumChars/rows);

        atlasHeight = (int)Math.ceil(charHeight * rows);
        atlasWidth  = (int)Math.ceil(charWidth * columns);
        charUvWidth = ((float)1f)/columns;
        charUvHeight = ((float)1f)/rows;
        g.dispose();
	}

	private BufferedImage createImage(int width, int height) {
		WritableRaster raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, width, height, 4, null);
		return new BufferedImage(TextureImageIO.glAlphaColorModel, raster, false, new Hashtable<String, Object>());
	}
	
	private TextureImage createTexture(int width, int height) {
		BufferedImage image = createImage(width,height);
		return new TextureImage(image, GL11.GL_RGBA, false);
	}

	public TextureImage getTextureAtlas() {
		return tex;
	}

	public float getCharWidth() {
		return charWidth;
	}

	public float getCharHeight() {
		return charHeight;
	}

	public void getUvCoords(char c, Vector2f uvStart, Vector2f uvWidth) {
		
		int index = c - firstChar;
		int row = index/columns;
		int column = index%columns;
		
		uvStart.x = ((float)column/columns);
		uvStart.y = ((float)row)/rows +charUvHeight;
		uvWidth.x = charUvWidth;
		uvWidth.y = -charUvHeight;
	}


	public Mesh createDebugTableMesh() {
		int vectorSize = 5;
		int uvPos = 3;
		
		float scale = 2f;
		
		
		float uvWidth = 1.0f;
		float uvHeight = 1.0f;
		float z = 0f;
		float hw = scale * (atlasWidth);
		float hh = scale * (atlasHeight);
		
		float[] coords = new float[]{
				  0,   0, z,  0,       0,
				 hw,   0, z,  uvWidth, 0,
				 hw,  hh, z,  uvWidth, uvHeight,
				  0,  hh, z,  0,       uvHeight
		};
		return new QuadMesh(FrontFaceVertexOrder.CounterClockwise, vectorSize, coords, uvPos, -1).toTriangleMesh();
	}


	public Mesh createDebugText() {
		TextMeshBuffer buffer = new TextMeshBuffer(this);
		char c = 32;
		for (int i = 0; c <= 126; i++, c++) {
        	buffer.append(c);
        	if ((i)%12 == 0) {
        		buffer.append('\n');
        	}
        }
		return buffer.toMesh();
	}
	
	
}
