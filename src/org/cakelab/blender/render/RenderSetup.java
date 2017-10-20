package org.cakelab.blender.render;

import java.io.IOException;

import org.cakelab.appbase.log.Log;
import org.cakelab.blender.render.data.BRLightRenderData;
import org.cakelab.blender.render.data.BRMeshRenderData;
import org.cakelab.blender.render.data.BRObjectRenderData;
import org.cakelab.blender.render.data.BRTextureRenderData;
import org.cakelab.blender.render.renderers.RendererLibrary;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.module.Module;
import org.cakelab.oge.opengl.MeshVertexArray;
import org.cakelab.oge.opengl.BufferObject.Usage;
import org.cakelab.oge.scene.LightSource;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.scene.VisualEntity;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.texture.GPUTexture;
import org.cakelab.oge.texture.TextureImageIO;
import org.cakelab.soapbox.model.Mesh;
import org.lwjgl.opengl.GL11;

public class RenderSetup {
	
	public static final int VERTEX_ATTRIBUTE_COORDS = 0;
	public static final int VERTEX_ATTRIBUTE_NORMAL = 1;
	public static final int VERTEX_ATTRIBUTE_UV = 4;

	private Module engine;
	private RendererLibrary library;

	
	
	public RenderSetup(Module module, RendererLibrary library) {
		this.engine = module;
		this.library = library;
		
	}
	
	public RendererLibrary getLibrary() {
		return library;
	}
	
	public void setup(VisualEntity ob) throws GLException {
		
		try {
			if (!(ob instanceof VisualMeshEntity)) {
				Log.warn("Renderer has no proper method to render objects without a mesh");
			} else {
				setup((VisualMeshEntity)ob);
			}
		} catch (IOException e) {
			throw new GLException(e);
		}
	}


	public void setupLamp(LightSource lamp) throws GLException {
		BRLightRenderData renderData = new BRLightRenderData(lamp);
		lamp.setRenderData(renderData);
	}

	private void setup(VisualMeshEntity gob) throws GLException, IOException {
		
		Mesh mesh = gob.getMesh();
		Material material = gob.getMaterial();
		MeshVertexArray vao = new MeshVertexArray(mesh, VERTEX_ATTRIBUTE_COORDS, Usage.STATIC_DRAW);
		TextureImage textureImage = material.getColorTexture();
		Renderer renderer;
		
		boolean usesTextures = textureImage != null && mesh.hasUVCoordinates();
		
		if (usesTextures) {
			setupTexture(mesh, vao, textureImage);
		}

		renderer = library.selectRenderer(gob);

		if (renderer.needsNormals()) {
			int normalsOffset = mesh.getNormalsOffset();
			assert(mesh.hasNormals());
			vao.declareAttribute(VERTEX_ATTRIBUTE_NORMAL, normalsOffset, 3);
		}

		mesh.setRenderData(new BRMeshRenderData(vao));
		
		BRObjectRenderData renderAssets = new BRObjectRenderData(mesh, material);
		
		renderAssets.setRenderer(renderer);
		gob.setModuleData(engine.getModuleId(), renderAssets);
		
	}

	private void setupTexture(Mesh mesh, MeshVertexArray vao, TextureImage textureImage) throws IOException {
		int attrIdxTexCoord = VERTEX_ATTRIBUTE_UV;
		int uvOffset 	    = mesh.getUVOffset(); /* offset to uv coords in each vector */
		int size 		    = 2;
		vao.declareAttribute(attrIdxTexCoord, uvOffset, size);
		
		
		GPUTexture gpuTexture = createGPUTexture(textureImage);
		BRTextureRenderData renderData = new BRTextureRenderData(gpuTexture);
		textureImage.setRenderData(renderData);
		
	}

	private GPUTexture createGPUTexture(TextureImage image) throws IOException {
		return new TextureImageIO(image.getImage(), 
				image.getPixelFormat(), image.isFlipped(), false, GL11.GL_NEAREST, GL11.GL_NEAREST);
	}
	
}
