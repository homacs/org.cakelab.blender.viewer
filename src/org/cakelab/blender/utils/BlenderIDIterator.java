package org.cakelab.blender.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.blender.dna.ID;
import org.cakelab.blender.nio.CPointer;

public class BlenderIDIterator<T> implements Iterator<T> {

	private T current;
	private Method getId;
	private Class<? extends Object> clazz;

	public BlenderIDIterator(T objectWithId) {
		
		try {
			clazz = objectWithId.getClass();
			getId = clazz.getMethod("getId");
			// test if this method is accessible
			ID id = (ID) getId.invoke(objectWithId);
			id.getNext();
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		current = objectWithId;
	}

	public static <T> Iterator<T> create(T objectWithId) {
		return new BlenderIDIterator<T>(objectWithId);
	}

	public static <T> Iterator<T> create(CPointer<T> pointerOnObjectWithId) throws IOException {
		T objectWithId = null;
		if (!pointerOnObjectWithId.isNull()) {
			objectWithId = pointerOnObjectWithId.get();
		}
		return new BlenderIDIterator<T>(objectWithId);
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T next() {
		T prev = current;
		try {
			ID id = (ID) getId.invoke(current);
			CPointer<T> pointer = (CPointer<T>) id.getNext().cast(clazz);
			if (pointer.isNull()) {
				current = null;
			} else {
				current = pointer.get();
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
			throw new RuntimeException(e);
		}
		return prev;
	}

}
