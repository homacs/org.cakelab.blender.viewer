package org.cakelab.blender.render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.io.IOException;

import org.cakelab.blender.io.Generic3DMaterial;
import org.cakelab.blender.io.Generic3DObject;
import org.cakelab.blender.io.Generic3DRenderAssets;
import org.cakelab.blender.io.Generic3DTextureImage;
import org.cakelab.oge.GraphicContext;
import org.cakelab.oge.Lamp;
import org.cakelab.oge.RenderEngine;
import org.cakelab.oge.Renderer;
import org.cakelab.oge.Scene;
import org.cakelab.oge.VisualObject;
import org.cakelab.oge.opengl.VertexArrayObject;
import org.cakelab.oge.shader.GLException;
import org.cakelab.oge.texture.GPUTexture;
import org.cakelab.oge.texture.TextureImageIO;
import org.cakelab.oge.utils.BufferedMatrix4f;
import org.cakelab.soapbox.model.Mesh;
import org.lwjgl.opengl.GL11;

public class BlenderRenderEngine implements RenderEngine {
	
	private static final int VERTEX_ATTRIBUTE_COORDS = 0;
	private static final int VERTEX_ATTRIBUTE_NORMAL = 1;
	private static final int VERTEX_ATTRIBUTE_UV = 4;

	
	private BufferedMatrix4f projection = new BufferedMatrix4f();
	private SimpleBaseColorTexRenderer simpleBaseColorTexRenderer;
	private SimpleBaseColorRenderer simpleBaseColorRenderer;
	private PhongPerVertexRenderer phongPerVertexRenderer;
	private PhongPerFragmentRenderer phongPerFragmentRenderer;
	private PhongTexPerFragmentRenderer phongTexPerFragmentRenderer;
	private NormalRenderer normalRenderer;
	private boolean renderNormals;
	private boolean renderMesh;
	
	
	@Override
	public void setup(Scene scene) throws GLException {

		setupRenders();
		
		
		// TODO: not for transparent objects
		glEnable(GL_CULL_FACE);
		// front face counter clockwise
		glFrontFace(GL_CCW);

		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		
		
		for (VisualObject ob : scene.getVisualObjects()) {
			try {
				setup(ob);
			} catch (IOException e) {
				throw new GLException(e);
			}
		}
		
		for (Lamp lamp : scene.getLamps()) {
			setupLamp(lamp);
		}
	}

	private void setupLamp(Lamp lamp) {
		BRLampRenderData renderData = new BRLampRenderData(lamp);
		lamp.setRenderData(renderData);
	}

	private void setupRenders() throws GLException {
		try {
			simpleBaseColorTexRenderer = new SimpleBaseColorTexRenderer();
			simpleBaseColorRenderer = new SimpleBaseColorRenderer();
			phongPerVertexRenderer = new PhongPerVertexRenderer();
			phongPerFragmentRenderer = new PhongPerFragmentRenderer();
			phongTexPerFragmentRenderer = new PhongTexPerFragmentRenderer();
			normalRenderer = new NormalRenderer();
		} catch (IOException e) {
			throw new GLException(e);
		}
		
	}

	private void setup(VisualObject ob) throws GLException, IOException {
		Generic3DObject gob = (Generic3DObject) ob;
		
		Generic3DRenderAssets renderAssets = (Generic3DRenderAssets) gob.getRenderAssets();
		
		Renderer renderer = setupAssets(renderAssets);
		
		
		BRObjectRenderData renderData = new BRObjectRenderData();
		
		// TODO select renderer based on object information
		renderData.setRenderer(renderer);
		gob.setRenderData(renderData);
	}

	private Renderer setupAssets(Generic3DRenderAssets renderAssets) throws IOException {
		Generic3DMaterial material = renderAssets.getMaterial();
		
		Mesh mesh = renderAssets.getMesh();
		VertexArrayObject vao = new VertexArrayObject(mesh, VERTEX_ATTRIBUTE_COORDS, GL_STATIC_DRAW);
		Generic3DTextureImage textureImage = material.getColorTexture();
		Renderer renderer;
		if (textureImage != null && mesh.hasUVCoordinates()) {
			
			/*
			 * TODO determine attribute arguments from mesh data
			 */
			int attrIdxTexCoord = VERTEX_ATTRIBUTE_UV;
			int uvOffset 	    = mesh.getUVOffset(); /* offset to uv coords in each vector */
			int size 		    = 2;
			vao.declareVertexAttribute(attrIdxTexCoord, uvOffset, size);
			
			
			GPUTexture gpuTexture = createGPUTexture(textureImage);
			BRTextureRenderData renderData = new BRTextureRenderData(gpuTexture);
			textureImage.setRenderData(renderData);
			
			if (material.isEmitter()) {
				renderer = simpleBaseColorTexRenderer;
			} else {
				renderer = phongTexPerFragmentRenderer;
			}
		} else {
			if (material.isEmitter()) {
				renderer = simpleBaseColorRenderer;
			} else {
				renderer = phongPerFragmentRenderer;
			}
		}

		
		
		if (renderer.needsNormals()) {
			int normalsOffset = mesh.getNormalsOffset();
			vao.declareVertexAttribute(VERTEX_ATTRIBUTE_NORMAL, normalsOffset, 3);
		}
		
		
		mesh.setRenderData(new BRMeshRenderData(vao));
		
		
		return renderer;
	}

	private GPUTexture createGPUTexture(Generic3DTextureImage image) throws IOException {
		return new TextureImageIO(image.getImage(), 
				image.getPixelFormat(), image.isFlipped(), false, GL11.GL_NEAREST, GL11.GL_NEAREST);
	}
	
	@Override
	public void setView(int width, int height, float fov) {
		float aspectRatio = (float) width / (float) height;
		projection.setPerspective(50.0f, aspectRatio, 0.1f, 1000.0f);
	}

	@Override
	public void render(GraphicContext context, double currentTime, Scene scene) {
		
		context.setProjectionTransform(projection);

		for (Lamp lamp : context.getActiveLamps()) {
			BRLampRenderData renderData = (BRLampRenderData) lamp.getRenderData();
			renderData.update(context, currentTime);
		}
		
		Renderer previousRenderer = null;
		for (VisualObject vobj : scene.getVisualObjects()) {
			BRObjectRenderData renderData = (BRObjectRenderData) vobj.getRenderData();
			Renderer renderer = renderData.getRenderer();
			if (renderer != previousRenderer) {
				// XXX remove hack
				currentTime++;
				previousRenderer = renderer;
			}
			renderer.prepare(context, currentTime);
			renderer.render(context, currentTime, vobj);
		}
		
		if (renderNormals) {
			for (VisualObject vobj : scene.getVisualObjects()) {
				Renderer renderer = normalRenderer;
				renderer.prepare(context, currentTime);
				renderer.render(context, currentTime, vobj);
			}
		}
	}

	@Override
	public void toggleNormalView() {
		this.renderNormals = !this.renderNormals;
	}
	@Override
	public void toggleMeshView() {
		this.renderMesh = !this.renderMesh;
	}
}
