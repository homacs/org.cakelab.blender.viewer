package org.cakelab.blender.io.convert;

import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;

/**
 * Converts from one coordinate system into another.
 * @author homac
 */
public interface CoordinateSystemConverter {
	/**
	 * Converts a single vector with len (3 or 4) dimensions 
	 * starting at startIndex in the given array in-place.
	 * @param array
	 * @param vectorStart
	 * @param len
	 */
	void convertVector(float[] array, int vectorStart, int len) ;

	/**
	 * Convert the given vector in-place.
	 * @param v
	 */
	void convertVector(Vector3f v);

	/**
	 * Convert the given vector in-place.
	 * @param v
	 */
	void convertVector(Vector4f v);

	/**
	 * Converts scale in x,y and z dimension to match the output coordinate system.
	 * Writes the result in the array 'scale'.
	 * @param scale Scale 
	 * @param startIndex
	 */
	void convertScale(float[] scale, int startIndex) ;

	/**
	 * Converts the Euler rotation given in the array 'rotation' starting at 'startIndex'. 
	 * Result is returned as a new quaternion.
	 * @param rotation
	 * @param vectorStart
	 * @return Quaternion matching the given Euler rotation
	 */
	Quaternionf convertEulerRotation(float[] rotation, int vectorStart);
	
	/**
	 * Converts a given camera orientation in-place. Forward and up define the camera 
	 * orientation of the source system. Both vectors will be adjusted to match the
	 * camera orientation standards of the target system. The given Euler rotation will be 
	 * translated in a quaternion for the target system too.
	 * @param forward Forward direction of the camera. Will be changed in-place.
	 * @param up Up vector of the camera. Will be changed in-place.
	 * @param eulerRotation Rotation of the camera (read only).
	 * @return Quaternion of the rotation in the target system.
	 */
	Quaternionf convertCameraOrientation(Vector3f forward, Vector3f up, float[] eulerRotation);
	
	Vector4f convertColor(float r, float g, float b, float alpha);

	Vector4f convertColor(float r, float g, float b);



}
