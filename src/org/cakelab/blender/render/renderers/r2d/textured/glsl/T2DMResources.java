package org.cakelab.blender.render.renderers.r2d.textured.glsl;

import org.cakelab.appbase.gui.GUIResourcesUtils;

public class T2DMResources extends GUIResourcesUtils {
	private static final String RESOURCES_PATH = T2DMResources.class.getPackage().getName().replace('.', '/') + '/';

	public static final String VERTEX_SHADER = RESOURCES_PATH + "render.vs.glsl";
	public static final String FRAGMENT_SHADER = RESOURCES_PATH + "render.fs.glsl";

}
