package org.blender.dna.constants.object;


public enum ObjectMode {
	OB_MODE_OBJECT        (0),
	OB_MODE_EDIT          (1 << 0),
	OB_MODE_SCULPT        (1 << 1),
	OB_MODE_VERTEX_PAINT  (1 << 2),
	OB_MODE_WEIGHT_PAINT  (1 << 3),
	OB_MODE_TEXTURE_PAINT (1 << 4),
	OB_MODE_PARTICLE_EDIT (1 << 5),
	OB_MODE_POSE          (1 << 6),
	OB_MODE_GPENCIL       (1 << 7); 	/* NOTE: Just a dummy to make the UI nicer */

	public final int v;
	ObjectMode(int v) {
		this.v = v;
	}
}