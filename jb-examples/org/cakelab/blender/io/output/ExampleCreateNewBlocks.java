package org.cakelab.blender.io.output;

import static org.blender.utils.BlenderFactory.*;

import java.io.File;
import java.io.IOException;

import org.blender.dna.Scene;
import org.blender.utils.BlenderFactory;
import org.blender.utils.MainLib;
import org.cakelab.blender.io.BlenderFile;

import static org.cakelab.blender.io.block.BlockCodes.*;

import org.cakelab.blender.nio.CArrayFacade;
import org.cakelab.blender.nio.CPointer;

public class ExampleCreateNewBlocks {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BlenderFile blend = newBlenderFile(new File("my.blend"));
		
		//
		// create a main library to manage references on data in blender file.
		//
		MainLib main = new MainLib(blend);

		//
		// Allocate a scene block and get a facet to access its data.
		// The new scene is already part of the blender file.
		//
		Scene scene = newCStructBlock(ID_SCE, Scene.class, blend);
		
		
		//
		// Blocks for structs
		//
		CArrayFacade<Scene> scenes = newCStructBlock(ID_SCE, Scene.class, 2, blend);
		scene = scenes.get(0);
		scene = scenes.get(1);
		// ..
		

		
		//
		// Blocks for arrays
		//

		// 1-dim float array with 4 elems
		CArrayFacade<Float> rgba = BlenderFactory.newCArrayBlock(ID_DATA, Float.class, 4, blend);
		rgba.fromArray(new float[]{0,0,0,1});
		
		
		// 2-dim 4x4 float array
		Class<?>[] typeList = new Class[]{CArrayFacade.class, Float.class};
		int[] dimensions = new int[]{4,4};
		CArrayFacade<CArrayFacade<Float>> mv_mat4x4 = newCArrayBlock(ID_DATA, typeList, dimensions, blend);
		
		
		// 1-dim array of pointers on bytes (e.g. strings)
		typeList = new Class[]{CArrayFacade.class, CPointer.class, Byte.class};
		dimensions = new int[]{4};
		CArrayFacade<CPointer<Byte>> fileList = newCArrayBlock(ID_DATA, typeList, dimensions, blend);
		

		
		//
		// Blocks for Pointers
		//
		
		// block with 1 pointer
		typeList = new Class[]{Byte.class};
		CPointer<CPointer<Byte>> pointer = newCPointerBlock(ID_DATA, typeList, blend);
		pointer.set(fileList.get(0));
		
		// block with set of 3 pointers
		typeList = new Class[]{Byte.class};
		CArrayFacade<CPointer<Byte>> pointerSet = newCPointerBlock(ID_DATA, typeList, 3, blend);
		pointerSet.set(0, fileList.get(0));
		
		//
		// write new file to disk.
		//
		blend.write();
	}

}
