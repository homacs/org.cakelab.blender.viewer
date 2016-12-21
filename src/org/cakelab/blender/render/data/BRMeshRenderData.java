package org.cakelab.blender.render.data;

import org.cakelab.oge.opengl.VertexArrayObject;
import org.cakelab.oge.scene.ModuleData;

public class BRMeshRenderData implements ModuleData {

	private VertexArrayObject vao;

	public BRMeshRenderData(VertexArrayObject vertexArrayObject) {
		this.vao = vertexArrayObject;
	}

	public void bind() {
		vao.bind();
	}

	@Override
	public void delete() {
		vao.delete();
	}

	public VertexArrayObject getVertexArrayObject() {
		return vao;
	}


}
