package org.cakelab.blender.render;

import org.cakelab.oge.Camera;
import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.Lamp;
import org.cakelab.oge.LampRenderData;
import org.joml.Matrix4f;
import org.joml.Vector4f;

public class BRLampRenderData implements LampRenderData {
	Matrix4f modelViewTransform = new Matrix4f();
	Matrix4f worldTransform = new Matrix4f();
	Lamp lamp;
	
	Vector4f position = new Vector4f();
	
	
	public BRLampRenderData(Lamp lamp) {
		this.lamp = lamp;
	}
	
	public void update(GraphicContext context, double currentTime) {
		Camera camera = context.getActiveCamera();
		position.set(lamp.getX(), lamp.getY(), lamp.getZ(), 1.f);
		position.mul(camera.getViewTransform());
	}
	
	public Vector4f getViewSpacePosition() {
		return position;
	}

	
}
