package org.cakelab.blender;

import org.cakelab.oge.Camera;
import org.cakelab.oge.math.CameraMatrices;
import org.cakelab.oge.scene.DynamicEntity;
import org.cakelab.oge.scene.LightSource;
import org.cakelab.oge.scene.Material;
import org.cakelab.oge.scene.Pose;
import org.cakelab.oge.scene.Scene;
import org.cakelab.oge.scene.VisualMeshEntity;
import org.cakelab.soapbox.MovementAdapter;
import org.cakelab.soapbox.model.Mesh.FrontFaceVertexOrder;
import org.cakelab.soapbox.model.TriangleMesh;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class TestScene extends Scene {
	public class DynamicTriangle extends Triangle implements DynamicEntity {
		Vector3f velocity = new Vector3f(0.1f,0,0);

		public DynamicTriangle(float x, float y, float z, Vector4f color) {
			super(x, y, z, color);
			setRotation(0, 0, (float) Math.toRadians(90));
		}

		@Override
		public void update(double currentTime) {
			float x = getX();
			if(x > 5 || x < -5) velocity.x = -velocity.x;
			setX(x + velocity.x);
		}

	}

	public class StaticCamera extends Camera {

		private Matrix4f orientationTransform = new Matrix4f();
		private Matrix4f viewTransform = new Matrix4f();

		public StaticCamera(float x, float y, float z, Vector3f forward, Vector3f up) {
			super(x, y, z, forward, up);
			viewTransform.lookAlong(forward, up);
			viewTransform.translate(x, y, z).invert();
			orientationTransform.lookAlong(forward, up);
			matrices = new CameraMatrices() {

				@Override
				public Matrix4f getViewTransform() {
					return StaticCamera.this.viewTransform;
				}

				@Override
				public void update() {
				}
				
			};
		}

		@Override
		public void set(Camera that) {
		}

		@Override
		public void setX(float x) {
		}

		@Override
		public void setY(float y) {
		}

		@Override
		public void setZ(float z) {
		}

		@Override
		public void apply(Quaternionfc rotation) {
		}

		@Override
		public void addPitch(float pitch) {
		}

		@Override
		public void addYaw(float yaw) {
		}

		@Override
		public void addRoll(float roll) {
		}

		@Override
		public void addRotation(float pitch, float yaw, float roll) {
		}

		@Override
		public void setRotation(float pitch, float yaw, float roll) {
		}


		@Override
		public void setPosition(float x, float y, float z) {
		}

		@Override
		public void setRotation(Quaternionfc rotation) {
		}

	}

	public static Vector4f red = new Vector4f(1,0,0,1);
	public static Vector4f green = new Vector4f(0,1,0,1);
	public static Vector4f blue = new Vector4f(0,0,1,1);
	public static Vector4f yellow = new Vector4f(1,1,0,1);
	
	public class Triangle extends VisualMeshEntity {

		public Triangle(float x, float y, float z, Vector4f color) {
			super(new Material(color), x, y, z);
			float v = 1;
			float nx = 0;
			float ny = 0;
			float nz = 1;
			float[] vertices = new float[]{
				0,0,0, nx,ny,nz,
				v,0,0, nx,ny,nz,
				v,v,0, nx,ny,nz
			};
			this.mesh = new TriangleMesh(FrontFaceVertexOrder.CounterClockwise, 6, vertices, -1, 3);
		}
	}

	public TestScene(MovementAdapter userMovement) {
		add(new Triangle(0, 0, 0, red));
		add(new Triangle(3, 0, 0, green));
		add(new Triangle(0, 3, 0, blue));
		add(new Triangle(0, 0, 3, yellow));
		add(new DynamicTriangle(0, 0, 3, yellow));
		addLightSource(new LightSource(0,0, 10, new Vector3f(1,1,1)));
		userMovement.init(new Pose(0, 0, 10, new Vector3f(0,0,-1), new Vector3f(0,1,0)));
//		userMovement.init(new StaticCamera(0, 0, 10, new Vector3f(0,0,-1), new Vector3f(0,1,0)));
//		player.setCamera(new Camera(0, 0, 10, new Vector3f(0,0,-1), new Vector3f(0,1,0)));
//		player.setCamera(new HeadCamera(0, 0, 10, new Vector3f(0,0,-1), new Vector3f(0,1,0)));
	}

	
}
