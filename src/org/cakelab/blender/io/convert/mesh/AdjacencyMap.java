package org.cakelab.blender.io.convert.mesh;

import java.util.HashSet;
import java.util.Set;

/** 
 * Used to calculate normal vectors for corners.
 * Stores for each blender vertex (index into MVert) a list of polygons, 
 * adjacent to it (using that vertex). */
class AdjacencyMap {
	Set<Polygon>[] adjacentPolies;
	
	@SuppressWarnings("unchecked")
	void init(int size) {
		adjacentPolies = new Set[size];
		for (int i = 0; i < size; i++) {
			adjacentPolies[i] = new HashSet<>();
		}
	}
	
	void add(int vertexId, Polygon poly) {
		Set<Polygon> polies = get(vertexId);
		polies.add(poly);
	}

	Set<Polygon> get(int vertexId) {
		return adjacentPolies[vertexId];
	}
}

