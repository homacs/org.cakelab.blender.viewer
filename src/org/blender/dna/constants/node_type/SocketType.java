package org.blender.dna.constants.node_type;


public class SocketType {
	public static class Type {
		public static final int UNDEFINED	 = 0;

		public static final int BOOLEAN	 = 1;
		public static final int FLOAT	 = 2;
		public static final int INT	 = 3;
		public static final int UINT	 = 4;
		public static final int COLOR	 = 5;
		public static final int VECTOR	 = 6;
		public static final int POINT	 = 7;
		public static final int NORMAL	 = 8;
		public static final int POINT2	 = 9;
		public static final int CLOSURE	 = 10;
		public static final int STRING	 = 11;
		public static final int ENUM	 = 12;
		public static final int TRANSFORM	 = 13;
		public static final int NODE	 = 14;

		public static final int BOOLEAN_ARRAY	 = 15;
		public static final int FLOAT_ARRAY	 = 16;
		public static final int INT_ARRAY	 = 17;
		public static final int COLOR_ARRAY	 = 18;
		public static final int VECTOR_ARRAY	 = 19;
		public static final int POINT_ARRAY	 = 20;
		public static final int NORMAL_ARRAY	 = 21;
		public static final int POINT2_ARRAY	 = 22;
		public static final int STRING_ARRAY	 = 23;
		public static final int TRANSFORM_ARRAY	 = 24;
		public static final int NODE_ARRAY	 = 25;
	};

	public static class Flags {
		public static final int LINKABLE	 = (1 << 0);
		public static final int ANIMATABLE	 = (1 << 1);

		public static final int SVM_INTERNAL	 = (1 << 2);
		public static final int OSL_INTERNAL	 = (1 << 3);
		public static final int INTERNAL	 = (1 << 2) | (1 << 3);

		public static final int LINK_TEXTURE_GENERATED	 = (1 << 4);
		public static final int LINK_TEXTURE_NORMAL	 = (1 << 5);
		public static final int LINK_TEXTURE_UV	 = (1 << 6);
		public static final int LINK_INCOMING	 = (1 << 7);
		public static final int LINK_NORMAL	 = (1 << 8);
		public static final int LINK_POSITION	 = (1 << 9);
		public static final int LINK_TANGENT	 = (1 << 10);
		public static final int DEFAULT_LINK_MASK = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9) | (1 << 10);
	};


}
