package org.cakelab.blender.io.convert.mesh;

import java.io.IOException;

public class Triangulator {



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
