package org.cakelab.blender.io.convert.mesh;

import java.io.IOException;

public interface VertexOutput {
	void put(int vertexId) throws IOException;
}
