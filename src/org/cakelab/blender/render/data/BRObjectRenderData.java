package org.cakelab.blender.render.data;


import static org.lwjgl.opengl.GL11.glDrawArrays;

import org.cakelab.oge.module.ModuleData;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.TextureImage;
import org.cakelab.oge.utils.SingleProgramRendererBase;
import org.cakelab.soapbox.model.Mesh;
import org.joml.Vector4f;

public class BRObjectRenderData implements ModuleData {

	private Material material;
	// TODO [1] replace render assets by render data (which will be data associated with the render engine)
	private Mesh mesh;


	private SingleProgramRendererBase renderer;


	public BRObjectRenderData(Mesh mesh) {
		this.mesh = mesh;
		this.material = new Material(new Vector4f(0,0,0,1), null, 0f);
	}

	public BRObjectRenderData(Mesh mesh, Material material) {
		this.mesh = mesh;
		this.material = material;
	}
	
	public void setRenderer(SingleProgramRendererBase renderer) {
		this.renderer = renderer;
	}

	public SingleProgramRendererBase getRenderer() {
		return renderer;
	}

	
	public int getDrawingMethod() {
		return mesh.getGlDrawingMethod();
	}

	public int getNumVertices() {
		return mesh.getNumVertices();
	}

	public void delete() {
		mesh.getRenderData().delete();
	}

	public Mesh getMesh() {
		return mesh;
	}


	public void bind() {
		BRMeshRenderData renderData = (BRMeshRenderData) mesh.getRenderData();
		renderData.bind();
		if (material != null) {
			TextureImage texture = material.getColorTexture();
			if (texture != null) ((BRTextureRenderData)texture.getRenderData()).bind();
		}
	}

	public Material getMaterial() {
		return material;
	}

	public void draw() {
		glDrawArrays(mesh.getGlDrawingMethod(), 0, mesh.getNumVertices());
	}
	
}
