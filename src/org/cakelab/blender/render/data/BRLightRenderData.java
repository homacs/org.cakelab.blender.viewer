package org.cakelab.blender.render.data;

import org.cakelab.oge.Camera;
import org.cakelab.oge.app.ApplicationContext;
import org.cakelab.oge.scene.LightSource;
import org.cakelab.oge.scene.ModuleData;
import org.joml.Matrix4f;
import org.joml.Vector4f;

public class BRLightRenderData implements ModuleData {
	Matrix4f modelViewTransform = new Matrix4f();
	Matrix4f worldTransform = new Matrix4f();
	LightSource lamp;
	
	Vector4f position = new Vector4f();
	
	
	public BRLightRenderData(LightSource lamp) {
		this.lamp = lamp;
	}
	
	public void update(ApplicationContext context, double currentTime) {
		Camera camera = context.getActiveCamera();
		position.set(lamp.getX(), lamp.getY(), lamp.getZ(), 1.f);
		position.mul(camera.matrices.getViewTransform());
	}
	
	public Vector4f getViewSpacePosition() {
		return position;
	}

	@Override
	public void delete() {
		// nothing to delete
	}

	
}
