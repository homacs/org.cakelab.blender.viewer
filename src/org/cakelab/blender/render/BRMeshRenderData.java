package org.cakelab.blender.render;

import org.cakelab.oge.MeshRenderData;
import org.cakelab.oge.opengl.VertexArrayObject;

public class BRMeshRenderData implements MeshRenderData {

	private VertexArrayObject vao;

	public BRMeshRenderData(VertexArrayObject vertexArrayObject) {
		this.vao = vertexArrayObject;
	}

	@Override
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
