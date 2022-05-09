package org.cakelab.blender.io.convert.mesh;

import java.io.IOException;

import org.blender.dna.MPoly;

class BlenderVertexInput implements VertexInput {
	private int loopstart = -1;

	public void init() {
	}

	public void setPolygon(MPoly poly) throws IOException {
		loopstart = poly.getLoopstart();
	}
	
	@Override
	public int getVertexId(int index) throws IOException {
		return loopstart + index;
	}

}