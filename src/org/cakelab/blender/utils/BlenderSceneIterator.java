package org.cakelab.blender.utils;

import java.io.IOException;
import java.util.Iterator;

import org.blender.dna.Base;
import org.blender.dna.Scene;

public class BlenderSceneIterator implements Iterator<Base> {
	// TODO study what scene iterator actually has to iterate
	
	
	Iterator<Base> bases;
	private Base base;
	private Scene scene;
	
	public BlenderSceneIterator(Scene scene) throws IOException {
		this.scene = scene;
		base = scene.getBase().getFirst().cast(Base.class).get();
		bases = BlenderListIterator.create(base);
	}

	@Override
	public boolean hasNext() {
		return base != null;
	}

	public Base _getNext() throws IOException {
		if (base != null && !base.getNext().isNull()) {
			/* common case, step to the next */
			return base.getNext().get();
		}
		else if (base == null && !scene.getBase().getFirst().isNull()) {
			/* first time looping, return the scenes first base */
			return scene.getBase().getFirst().cast(Base.class).get();
		}
		else {
			/* reached the end, get the next base in the set */
			while (null != (scene = scene.getSet().get())) {
				base = scene.getBase().getFirst().cast(Base.class).get();
				if (base != null) {
					return base;
				}
			}
		}

		return null;

	}
	
	@Override
	public Base next() {
		Base prev = base;
		try {
			base = _getNext();
		} catch (IOException e) {
			// TODO hidden exception
			throw new RuntimeException(e);
		}
		return prev;
	}
	
	
	
}
