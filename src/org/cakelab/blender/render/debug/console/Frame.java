package org.cakelab.blender.render.debug.console;

import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.soapbox.model.Mesh;
import org.cakelab.soapbox.model.Mesh.FrontFaceVertexOrder;
import org.cakelab.soapbox.model.QuadMesh;
import org.joml.Vector4f;


public class Frame extends VisualMeshEntity {
	
	private int width;
	private int height;
	private Vector4f bgcolor;

	public Frame(int width, int height) {
		super();
		this.setSize(width, height);
		
		bgcolor = new Vector4f(0.1f,0.1f,0.1f,0.5f);
		

		super.mesh = createMesh();

		super.material = new Material(bgcolor);
		
	}

	public void setSize(int width, int height) {
		super.setScale(width, height, 1f);
	}

	public void setPosition(int x, int y) {
		super.setPosition(x,-y,0);
	}


	private Mesh createMesh() {
		int vectorSize = 4;
		int uvPos = 2;
		
		float uvWidth = 1.0f;
		float uvHeight = 1.0f;
		float w = 1.0f;
		float h = 1.0f;
		// origin top left
		float[] coords = new float[]{
				 0,  0,  0,       0,
				 0, -h,  uvWidth, 0,
				 w, -h,  uvWidth, uvHeight,
				 w,  0,  0,       uvHeight
		};
		return new QuadMesh(FrontFaceVertexOrder.CounterClockwise, vectorSize, coords, uvPos, -1).toTriangleMesh();
	}


}
