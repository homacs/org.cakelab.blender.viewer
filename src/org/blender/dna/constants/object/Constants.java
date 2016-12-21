package org.blender.dna.constants.object;

public class Constants {
	
	/** BlenderObject.getType() */
	public static final int OB_EMPTY      = 0;
	/** BlenderObject.getType() */
	public static final int OB_MESH       = 1;
	/** BlenderObject.getType() */
	public static final int OB_CURVE      = 2;
	/** BlenderObject.getType() */
	public static final int OB_SURF       = 3;
	/** BlenderObject.getType() */
	public static final int OB_FONT       = 4;
	/** BlenderObject.getType() */
	public static final int OB_MBALL      = 5;
	/** BlenderObject.getType() */
	public static final int OB_LAMP       = 10;
	/** BlenderObject.getType() */
	public static final int OB_CAMERA     = 11;

	/** BlenderObject.getType() */
	public static final int OB_SPEAKER    = 12;

	/*	OB_WAVE       = 21, */
	/** BlenderObject.getType() */
	public static final int OB_LATTICE    = 22;

	/* 23 and 24 are for life and sector (old file compat.) */
	/** BlenderObject.getType() */
	public static final int OB_ARMATURE   = 25;
	
	
	

	/* (short) transflag */
	/* flags 1 and 2 were unused or relics from past features */
	/** BlenderObject.getTransflag() */
	public static final int OB_NEG_SCALE        = 1 << 2;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLIFRAMES      = 1 << 3;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLIVERTS       = 1 << 4;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLIROT         = 1 << 5;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLINOSPEED     = 1 << 6;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLICALCDERIVED = 1 << 7; /* runtime, calculate derivedmesh for dupli before it's used */
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLIGROUP       = 1 << 8;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLIFACES       = 1 << 9;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLIFACES_SCALE = 1 << 10;
	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLIPARTS       = 1 << 11;
	/** BlenderObject.getTransflag() */
	public static final int OB_RENDER_DUPLI     = 1 << 12;
	/** BlenderObject.getTransflag() */
	public static final int OB_NO_CONSTRAINTS   = 1 << 13;  /* runtime constraints disable */
	/** BlenderObject.getTransflag() */
	public static final int OB_NO_PSYS_UPDATE   = 1 << 14;  /* hack to work around particle issue */

	/** BlenderObject.getTransflag() */
	public static final int OB_DUPLI            = OB_DUPLIFRAMES | OB_DUPLIVERTS | OB_DUPLIGROUP | OB_DUPLIFACES | OB_DUPLIPARTS;

	
	
	
	/** ob->restrictflag */
	public static final int OB_RESTRICT_VIEW    = 1 << 0;
	/** ob->restrictflag */
	public static final int OB_RESTRICT_SELECT  = 1 << 1;
	/** ob->restrictflag */
	public static final int OB_RESTRICT_RENDER  = 1 << 2;

}
