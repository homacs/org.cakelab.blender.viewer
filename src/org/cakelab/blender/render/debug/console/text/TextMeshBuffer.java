package org.cakelab.blender.render.debug.console.text;

import java.util.Arrays;

import org.cakelab.soapbox.model.Mesh;
import org.cakelab.soapbox.model.Mesh.FrontFaceVertexOrder;
import org.cakelab.soapbox.model.TriangleMesh;
import org.joml.Vector2f;

public class TextMeshBuffer {
	
	
	Vector2f uv = new Vector2f();
	Vector2f uvW = new Vector2f();
	
	private static final int VECTORSIZE = 4;
	private static final int UVPOS = 2;
	private static final int VERTSPERCHAR = VECTORSIZE*6;
	private static final int CHUNKSIZE = VERTSPERCHAR*32;

	private static final int NORMALPOS = -1;
	
	private GlyphTextureAtlas glyphAtlas;
	
	private float[] buffer; // vertex buffer
	private int size;       // current vertex buffer size
	
	private float h;     // char height
	private float w;     // char width
	private float x;     // cursor x
	private float y;     // cursor y
	private float xAdv;  // horizontal advance to next char
	private float yAdv;  // vertical advance to next line
	private float yReset;
	private float xReset;
	
	// horizontal space between characters
	private float hspace = 0;
	// vertical space between lines
	private float vspace = 2;

	public TextMeshBuffer(GlyphTextureAtlas glyphAtlas) {
		this.glyphAtlas = glyphAtlas;

		buffer = new float[CHUNKSIZE];
		
		w = glyphAtlas.getCharWidth();
		h = glyphAtlas.getCharHeight();
		
		xAdv = w + hspace;
		yAdv = -(h + vspace);

		xReset = 0;
		yReset = 0-h;
		
		x = xReset;
		y = yReset;
		
	}

	public TextMeshBuffer append(String text) {
		
		char[] chars = text.toCharArray();
		allocbuffer(chars.length);
		
		for (char c : chars) {
			append(c);
		}
		return this;
	}

	public TextMeshBuffer append(char c) {
		allocbuffer(+1);
		switch (c) {
		case '\n':
			newLine();
			break;
		default:
			write(c, x, y);
			break;
		}
		
		return this;
	}

	
	
	/**
	 * write character at current position
	 * @param c
	 */
	private void write(char c, float x, float y) {
		glyphAtlas.getUvCoords(c, uv, uvW);

		// first triangle 
		
		buffer[size++] = x;
		buffer[size++] = y;
		buffer[size++] = uv.x;
		buffer[size++] = uv.y;
		
		buffer[size++] = x+w;
		buffer[size++] = y;
		buffer[size++] = uv.x+uvW.x;
		buffer[size++] = uv.y;
		
		buffer[size++] = x+w;
		buffer[size++] = y+h;
		buffer[size++] = uv.x+uvW.x;
		buffer[size++] = uv.y+uvW.y;

		// second triangle
		
		buffer[size++] = x+w;
		buffer[size++] = y+h;
		buffer[size++] = uv.x+uvW.x;
		buffer[size++] = uv.y+uvW.y;
		
		buffer[size++] = x;
		buffer[size++] = y+h;
		buffer[size++] = uv.x;
		buffer[size++] = uv.y+uvW.y;
		
		buffer[size++] = x;
		buffer[size++] = y;
		buffer[size++] = uv.x;
		buffer[size++] = uv.y;
		
		x += xAdv;
	}

	
	private void newLine() {
		y += yAdv;
		x = xReset;
	}

	/**
	 * Checks buffer size and resizes it if necessary.
	 * Called each time new data is about to be added to the end
	 * of the buffer. 
	 * @param diff
	 */
	private void allocbuffer(int diff) {
		int newSize = size + (diff*VERTSPERCHAR);
		if (newSize > buffer.length) {
			int capacity = buffer.length;
			while (capacity < newSize) capacity += CHUNKSIZE;
			buffer = Arrays.copyOf(buffer, capacity);
		}
	}

	public Mesh toMesh() {
		return new TriangleMesh(FrontFaceVertexOrder.CounterClockwise, VECTORSIZE, buffer, UVPOS, NORMALPOS, size);
	}

}
