package org.cakelab.blender.render.debug.coords.resources;

import org.cakelab.appbase.gui.GUIResourcesUtils;

public class CoordPlaneResources extends GUIResourcesUtils {
	private static final String RESOURCES_PATH = CoordPlaneResources.class.getPackage().getName().replace('.', '/') + '/';

	public static final String VERTEX_SHADER = RESOURCES_PATH + "render.vs.glsl";
	public static final String FRAGMENT_SHADER = RESOURCES_PATH + "render.fs.glsl";

}
