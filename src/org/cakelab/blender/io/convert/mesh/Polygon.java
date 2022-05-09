package org.cakelab.blender.io.convert.mesh;

import org.joml.Vector3f;

/** used to calculate normal vectors for corners. */
class Polygon {
	/** index in converted vector array */
	int coordsStart;
	/** normal vector of this face (transformed) */
	Vector3f normal;
	/** number of vertices effectively written to output buffer (considering triangulation) */
	int numVertices;
	int vertexIdsStart;
	
	public Polygon(int coordsStart, int vertexIdsStart, int numVertices, int sliceLength, Vector3f normal) {
		assert (vertexIdsStart == coordsStart/sliceLength);

		this.coordsStart = coordsStart;
		this.vertexIdsStart = vertexIdsStart;
		this.numVertices = numVertices;
		this.normal = normal;
	}
}
