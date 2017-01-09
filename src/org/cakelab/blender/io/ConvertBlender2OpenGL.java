package org.cakelab.blender.io;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;


public class ConvertBlender2OpenGL implements CoordinateSystemConverter {
	/*
	 * OpenGL and Blender use a right handed coordination system.
	 * 
	 * OpenGL's, coordinate system has the following orientation:
	 *    X-Axis points to the right,
	 *    Y-Axis points up,
	 *    Z-Axis points towards the viewer.
	 * So, the viewer looks down the negative Z axis.
	 * 
	 * The orientation of Blenders coordinate system is different.
	 * When opening Blender with the default settings, the orientation is this:
	 *    X-Axis points towards the viewer,
	 *    Y-Axis points to the right,
	 *    Z-Axis points up.
	 * The user expects at least the up direction to be the same.
	 * Now to transform from Blenders coordinate system into OpenGL
	 * coordinate system, we have to turn its orientation, so that Y points up, which is:
	 *    1. rotate -90 around X
	 *    2. and rotate -90 around Y
	 * We transform all vectors (even vertices) by this rotation.
	 * 
	 * All other transformations, received from Blender, such as scale and rotate, 
	 * and the camera orientation will be adjusted for the new coordinate system.
	 */

	/** to transform vectors (who would have thought!) */
	private Matrix4f vectorTransform;
	/** to transform blenders coordinate system into ours */
	private Quaternionf rotationTransform;
	/** to transform our coordinate system into blenders */
	private Quaternionf inverseRotationTransform;

	/** vector for temporary use*/
	private Vector4f tmpVec4f = new Vector4f();
	/** vector for temporary use*/
	private Vector3f tmpVec3f = new Vector3f();

	public ConvertBlender2OpenGL() {
		rotationTransform = new Quaternionf();
		rotationTransform.rotateY((float) Math.toRadians(-90));
		rotationTransform.rotateX((float) Math.toRadians(-90));
		

		inverseRotationTransform = new Quaternionf(rotationTransform).invert();

		
		vectorTransform = new Matrix4f();
		vectorTransform.rotate(rotationTransform);
	}

	@Override
	public void convertVector(float[] array, int vectorStart, int len) {
		if (len == 3) {
			Vector3f vec = getTmpVector3f(array, vectorStart); 
			convertVector(vec);
			setVector(vec, array, vectorStart);
		} else {
			Vector4f vec = getTmpVector4f(array, vectorStart); 
			convertVector(vec);
			setVector(vec, array, vectorStart);
		}
	}

	@Override
	public void convertVector(Vector3f v) {
		Vector4f vt = new Vector4f(v,1);
		vectorTransform.transform(vt);
		v.x = vt.x;
		v.y = vt.y;
		v.z = vt.z;
		
	}

	@Override
	public void convertVector(Vector4f v) {
		vectorTransform.transform(v);
	}

	@Override
	public void convertScale(float[] array, int vectorStart) {
		/* To convert the scale, we just need to exchange the coordinates
		 * to match our system.
		 */
		float x = array[vectorStart + 0];
		float y = array[vectorStart + 1];
		float z = array[vectorStart + 2];
		array[vectorStart + 0] = y;
		array[vectorStart + 1] = z;
		array[vectorStart + 2] = x;
	}

	@Override
	public Quaternionf convertCameraOrientation(Vector3f forward, Vector3f up, float[] eulerRotation) {
		convertVector(forward);
		convertVector(up);
		return convertEulerRotation(eulerRotation, 0);
	}

	@Override
	public Quaternionf convertEulerRotation(float[] array, int vectorStart) {
		// Blender uses an Euler rotation with the following order of rotations:
		//    1. rotate X
		//    2. rotate Y
		//    3. rotate Z
		// To apply the Euler rotation in the new coordinate system, we first rotate
		// the coordinate system into blenders coordinate system (inverseRotationTransform)
		// then we apply the Euler rotation in Blenders coordinate system
		// and finally turn the coordinate system back into our system. The result is a
		// quaternion ready to be used in our coordinate system.
		
		
		
		Quaternionf rotation = new Quaternionf();
		
		rotation.mul(this.rotationTransform);
		rotation.rotateZ(array[2]);
		rotation.rotateY(array[1]);
		rotation.rotateX(array[0]);
		rotation.mul(inverseRotationTransform);
		
		return rotation;
	}



	public int convertToTriangles(float[] source, int srcPos, float[] target, int targetPos, int vectorSize, int nvertices) {
		// convert a polygon into a set of triangles
		// Starting with the first 3 vertices for the first triangle
		// proceed by taking the latter 2 vertices of the previous triangle and
		// add the next vertex to build another triangle.
		// FIXME: This method works for concave polygons only.
		
		int i, j, k; // indices of the vertices of one particular triangle
		int front = 0, back = nvertices-1;
		int ntriangles = nvertices -2;
		
		for (int t = 0; t < ntriangles; t++) {
			if (t%2 == 0) {
				i = front;
				j = ++front;
				k = back;
			} else {
				k = back;
				j = --back;
				i = front;
			}
			
			targetPos = createTriangle(source, srcPos, i, j, k, target, targetPos, vectorSize);
			
		}
		
		return targetPos;
	}

	
	/* **************************************************************** *
	 *            Just helper methods below                             *
	 * **************************************************************** */
	
	/** Copy the vertices i, j, k from source to target. Indices i,j and k 
	 * are relative to the given offset srcPos. targetPos is the index for
	 * the first vertex of the triangle in the target array. Method returns 
	 * the next free position in the target array (i.e. targetPos + (3*vectorSize)).
	 * */
	private int createTriangle(float[] source, int srcPos, int i, int j,
			int k, float[] target, int targetPos, int vectorSize) {
		System.arraycopy(source, srcPos +i*vectorSize, target, targetPos, vectorSize);
		targetPos += vectorSize;
		System.arraycopy(source, srcPos +j*vectorSize, target, targetPos, vectorSize);
		targetPos += vectorSize;
		System.arraycopy(source, srcPos +k*vectorSize, target, targetPos, vectorSize);
		targetPos += vectorSize;
		return targetPos;
	}

	
	private Vector4f getTmpVector4f(float[] array, int offset) {
		tmpVec4f.x = array[offset + 0];
		tmpVec4f.y = array[offset + 1];
		tmpVec4f.z = array[offset + 2];
		tmpVec4f.w = array[offset + 3];
		return tmpVec4f;
	}

	private void setVector(Vector3f vec, float[] array, int offset) {
		array[offset + 0] = vec.x;
		array[offset + 1] = vec.y;
		array[offset + 2] = vec.z;
	}

	private Vector3f getTmpVector3f(float[] array, int offset) {
		tmpVec3f.x = array[offset + 0];
		tmpVec3f.y = array[offset + 1];
		tmpVec3f.z = array[offset + 2];
		return tmpVec3f;
	}

	private void setVector(Vector4f vec, float[] array, int offset) {
		array[offset + 0] = vec.x;
		array[offset + 1] = vec.y;
		array[offset + 2] = vec.z;
		array[offset + 3] = vec.w;
	}


}
