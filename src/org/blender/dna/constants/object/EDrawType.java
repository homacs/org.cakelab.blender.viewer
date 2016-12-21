package org.blender.dna.constants.object;

public enum EDrawType {
	OB_BOUNDBOX   (1),
	OB_WIRE      (2),
	OB_SOLID     (3),
	OB_MATERIAL  (4),
	OB_TEXTURE   (5),
	OB_RENDER    (6),

	OB_PAINT     (100);  /* temporary used in draw code */
	
	
	public final int v;
	EDrawType (int v) {
		this.v = v;
	}
	
	
}
