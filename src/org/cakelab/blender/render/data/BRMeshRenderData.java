package org.cakelab.blender.render.data;

import org.cakelab.oge.module.ModuleData;
import org.cakelab.oge.opengl.VertexArray;

public class BRMeshRenderData implements ModuleData {

	private VertexArray vao;

	public BRMeshRenderData(VertexArray vertexArrayObject) {
		this.vao = vertexArrayObject;
	}

	public void bind() {
		vao.bind();
	}

	@Override
	public void delete() {
		vao.delete(true);
	}

	public VertexArray getVertexArrayObject() {
		return vao;
	}


}
