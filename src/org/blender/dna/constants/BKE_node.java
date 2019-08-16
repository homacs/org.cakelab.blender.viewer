package org.blender.dna.constants;

public final class BKE_node {

	
	
	
	

	public static final int TEX_NODE_OUTPUT = 401;
	public static final int TEX_NODE_CHECKER = 402;
	public static final int TEX_NODE_TEXTURE = 403;
	public static final int TEX_NODE_BRICKS = 404;
	public static final int TEX_NODE_MATH = 405;
	public static final int TEX_NODE_MIX_RGB = 406;
	public static final int TEX_NODE_RGBTOBW = 407;
	public static final int TEX_NODE_VALTORGB = 408;
	public static final int TEX_NODE_IMAGE = 409;
	public static final int TEX_NODE_CURVE_RGB = 410;
	public static final int TEX_NODE_INVERT = 411;
	public static final int TEX_NODE_HUE_SAT = 412;
	public static final int TEX_NODE_CURVE_TIME = 413;
	public static final int TEX_NODE_ROTATE = 414;
	public static final int TEX_NODE_VIEWER = 415;
	public static final int TEX_NODE_TRANSLATE = 416;
	public static final int TEX_NODE_COORD = 417;
	public static final int TEX_NODE_DISTANCE = 418;
	public static final int TEX_NODE_COMPOSE = 419;
	public static final int TEX_NODE_DECOMPOSE = 420;
	public static final int TEX_NODE_VALTONOR = 421;
	public static final int TEX_NODE_SCALE = 422;
	public static final int TEX_NODE_AT = 423;

/* 501-599 reserved. Use like this: TEX_NODE_PROC + TEX_CLOUDS, etc */
	public static final int TEX_NODE_PROC = 500;
	public static final int TEX_NODE_PROC_MAX = 600;

	
	
	
	
	
	
	
	
/* note: types are needed to restore callbacks, don't change values */
/* range 1 - 100 is reserved for common nodes */
/* using toolbox, we add node groups by assuming the values below
 * don't exceed NODE_GROUP_MENU for now. */

//	public static final int SH_NODE_OUTPUT = 1;

//	public static final int SH_NODE_MATERIAL = 100;
	public static final int SH_NODE_RGB = 101;
	public static final int SH_NODE_VALUE = 102;
	public static final int SH_NODE_MIX_RGB = 103;
	public static final int SH_NODE_VALTORGB = 104;
	public static final int SH_NODE_RGBTOBW = 105;
	public static final int SH_NODE_SHADERTORGB = 106;
//	public static final int SH_NODE_TEXTURE = 106;
	public static final int SH_NODE_NORMAL = 107;
//	public static final int SH_NODE_GEOMETRY = 108;
	public static final int SH_NODE_MAPPING = 109;
	public static final int SH_NODE_CURVE_VEC = 110;
	public static final int SH_NODE_CURVE_RGB = 111;
	public static final int SH_NODE_CAMERA = 114;
	public static final int SH_NODE_MATH = 115;
	public static final int SH_NODE_VECT_MATH = 116;
	public static final int SH_NODE_SQUEEZE = 117;
//	public static final int SH_NODE_MATERIAL_EXT = 118;
	public static final int SH_NODE_INVERT = 119;
	public static final int SH_NODE_SEPRGB = 120;
	public static final int SH_NODE_COMBRGB = 121;
	public static final int SH_NODE_HUE_SAT = 122;
	public static final int NODE_DYNAMIC = 123;

	/** Material Output Node */
	public static final int SH_NODE_OUTPUT_MATERIAL = 124;
	public static final int SH_NODE_OUTPUT_WORLD = 125;
	public static final int SH_NODE_OUTPUT_LIGHT = 126;
	public static final int SH_NODE_FRESNEL = 127;
	public static final int SH_NODE_MIX_SHADER = 128;
	public static final int SH_NODE_ATTRIBUTE = 129;
	public static final int SH_NODE_BACKGROUND = 130;
	public static final int SH_NODE_BSDF_ANISOTROPIC = 131;
	public static final int SH_NODE_BSDF_DIFFUSE = 132;
	public static final int SH_NODE_BSDF_GLOSSY = 133;
	public static final int SH_NODE_BSDF_GLASS = 134;
	public static final int SH_NODE_BSDF_TRANSLUCENT = 137;
	public static final int SH_NODE_BSDF_TRANSPARENT = 138;
	public static final int SH_NODE_BSDF_VELVET = 139;
	public static final int SH_NODE_EMISSION = 140;
	public static final int SH_NODE_NEW_GEOMETRY = 141;
	public static final int SH_NODE_LIGHT_PATH = 142;
	public static final int SH_NODE_TEX_IMAGE = 143;
	public static final int SH_NODE_TEX_SKY = 145;
	public static final int SH_NODE_TEX_GRADIENT = 146;
	public static final int SH_NODE_TEX_VORONOI = 147;
	public static final int SH_NODE_TEX_MAGIC = 148;
	public static final int SH_NODE_TEX_WAVE = 149;
	public static final int SH_NODE_TEX_NOISE = 150;
	public static final int SH_NODE_TEX_MUSGRAVE = 152;
	public static final int SH_NODE_TEX_COORD = 155;
	public static final int SH_NODE_ADD_SHADER = 156;
	public static final int SH_NODE_TEX_ENVIRONMENT = 157;
	public static final int SH_NODE_OUTPUT_TEXTURE = 158;
	public static final int SH_NODE_HOLDOUT = 159;
	public static final int SH_NODE_LAYER_WEIGHT = 160;
	public static final int SH_NODE_VOLUME_ABSORPTION = 161;
	public static final int SH_NODE_VOLUME_SCATTER = 162;
	public static final int SH_NODE_GAMMA = 163;
	public static final int SH_NODE_TEX_CHECKER = 164;
	public static final int SH_NODE_BRIGHTCONTRAST = 165;
	public static final int SH_NODE_LIGHT_FALLOFF = 166;
	public static final int SH_NODE_OBJECT_INFO = 167;
	public static final int SH_NODE_PARTICLE_INFO = 168;
	public static final int SH_NODE_TEX_BRICK = 169;
	public static final int SH_NODE_BUMP = 170;
	public static final int SH_NODE_SCRIPT = 171;
	public static final int SH_NODE_AMBIENT_OCCLUSION = 172;
	public static final int SH_NODE_BSDF_REFRACTION = 173;
	public static final int SH_NODE_TANGENT = 174;
	public static final int SH_NODE_NORMAL_MAP = 175;
	public static final int SH_NODE_HAIR_INFO = 176;
	public static final int SH_NODE_SUBSURFACE_SCATTERING = 177;
	public static final int SH_NODE_WIREFRAME = 178;
	public static final int SH_NODE_BSDF_TOON = 179;
	public static final int SH_NODE_WAVELENGTH = 180;
	public static final int SH_NODE_BLACKBODY = 181;
	public static final int SH_NODE_VECT_TRANSFORM = 182;
	public static final int SH_NODE_SEPHSV = 183;
	public static final int SH_NODE_COMBHSV = 184;
	public static final int SH_NODE_BSDF_HAIR = 185;
	public static final int SH_NODE_LAMP = 186;
	public static final int SH_NODE_UVMAP = 187;
	public static final int SH_NODE_SEPXYZ = 188;
	public static final int SH_NODE_COMBXYZ = 189;
	public static final int SH_NODE_OUTPUT_LINESTYLE = 190;
	public static final int SH_NODE_UVALONGSTROKE = 191;
	public static final int SH_NODE_TEX_POINTDENSITY = 192;
	/** Principle BSDF Surface Node */
	public static final int SH_NODE_BSDF_PRINCIPLED = 193;
	public static final int SH_NODE_TEX_IES = 194;
	public static final int SH_NODE_EEVEE_SPECULAR = 195;
	public static final int SH_NODE_BEVEL = 197;
	public static final int SH_NODE_DISPLACEMENT = 198;
	public static final int SH_NODE_VECTOR_DISPLACEMENT = 199;
	public static final int SH_NODE_VOLUME_PRINCIPLED = 200;
/* 201..700 occupied by other node types, continue from 701 */
	public static final int SH_NODE_BSDF_HAIR_PRINCIPLED = 701;
	public static final int SH_NODE_MAP_RANGE = 702;
	public static final int SH_NODE_CLAMP = 703;

/* custom defines options for Material node */
	public static final int SH_NODE_MAT_DIFF = 1;
	public static final int SH_NODE_MAT_SPEC = 2;
	public static final int SH_NODE_MAT_NEG = 4;

}
