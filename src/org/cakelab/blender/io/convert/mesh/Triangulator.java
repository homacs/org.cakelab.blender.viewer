package org.cakelab.blender.io.convert.mesh;

import java.io.IOException;

public class Triangulator {
	/** 
	 * Turns given polygon into triangles using existing vertices only.
	 * <b>Polygon must be concave and planar!</b> 
	 * <p>
	 * Starting at the first two vertices,
	 * the algorithm cuts the polygon into pieces along a zick-zack-line over
	 * all vertices, alternately adding the next vertex from the back and the 
	 * front, in reverse (back) respectively forward (front) direction.
	 * </p>
	 * <p>
	 * Vertices are virtually ordered in a list and each vertex is
	 * referenced by a vertex index (its position in the list).
	 * Each generated triangle is only represented by list of three vertex 
	 * indices. The vertex input is responsible to map the given vertex index
	 * to a vertex ID, that is understood by the vertex output. The 
	 * corresponding vertex IDs are then provided to the vertex output
	 * in the order which reflects the front-facing order of the given
	 * polygon.
	 * </p>
	 * 
	 * @param in Vertex input, providing vertex IDs for a given vertex index.
	 * @param out Vertex output, receiving generated triangles in triplets of vertex IDs.
	 * @param nvertices Number of vertices of the polygon to be triangulated.
	 * @throws IOException
	 */
	public void triangulate(VertexInput in, VertexOutput out, int nvertices) throws IOException {
		int ntriangles = nvertices -2;
		
		int i, j, k; // indices of the vertices of one particular triangle
		int front = 0, back = nvertices-1;
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
			
			out.put(in.getVertexId(i));
			out.put(in.getVertexId(j));
			out.put(in.getVertexId(k));
		}
	}

}
