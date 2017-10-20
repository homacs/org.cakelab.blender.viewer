package org.cakelab.blender.render.debug.console;

import java.awt.Font;

import org.cakelab.blender.render.debug.console.text.GlyphTextureAtlas;
import org.cakelab.blender.render.debug.console.text.TextMeshBuffer;
import org.cakelab.oge.scene.DynamicEntity;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.joml.Vector4f;


public class Text extends VisualMeshEntity implements DynamicEntity {
	
	private TextureImage tex;
	private GlyphTextureAtlas glyphAtlas;
	private Vector4f textcolor;
	private TextMeshBuffer buffer;

	

	public Text(int width, int height) {
		super();
		
		
		textcolor = new Vector4f(0.7f,0.7f,0.7f,0.0f);
		glyphAtlas = new GlyphTextureAtlas();
		glyphAtlas.selectFont(new Font("Courier", 0, 12));
		tex = glyphAtlas.getTextureAtlas();
		
		super.material = new Material(textcolor, tex, 1f);

		setText("");
//		super.mesh = glyphAtlas.createDebugText();
//		super.mesh = glyphAtlas.createDebugTableMesh();
		
	}

	public void setPosition(int x, int y) {
		super.setPosition(x,-y,0);
	}

	public void setText(String text) {
		// TODO: optimise text rendering
		buffer = new TextMeshBuffer(glyphAtlas);

		buffer.append(text);
		
		super.mesh = buffer.toMesh();
	}
	
	@Override
	public void update(double currentTime) {
		
		// TODO change the texture
	}

	

}
