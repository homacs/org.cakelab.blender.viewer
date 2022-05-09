package org.cakelab.blender.io.convert.mesh;

import java.io.IOException;

public interface VertexInput {
	int getVertexId(int index) throws IOException;
}
