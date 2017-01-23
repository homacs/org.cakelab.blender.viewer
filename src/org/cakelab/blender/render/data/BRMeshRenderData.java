package org.cakelab.blender.render.data;

import org.cakelab.oge.module.ModuleData;
import org.cakelab.oge.opengl.VertexArrayObject;

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
		vao.delete(true);
	}

	public VertexArrayObject getVertexArrayObject() {
		return vao;
	}


}
