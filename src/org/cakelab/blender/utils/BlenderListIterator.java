package org.cakelab.blender.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.blender.dna.ListBase;
import org.cakelab.blender.nio.CPointer;

public class BlenderListIterator<T> implements Iterator<T> {

	private T current;
	private Method getNext;
	private Class<? extends Object> clazz;

	public BlenderListIterator(T listElement) {
		
		try {
			if (listElement != null) {
				clazz = listElement.getClass();
				getNext = clazz.getMethod("getNext");
				// test if this method is accessible
				_getNext(listElement);
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
			if (e instanceof IllegalArgumentException) throw (IllegalArgumentException)e;
			else throw new IllegalArgumentException(e);
		}
		
		current = listElement;
	}

	public static <T> Iterator<T> create(T listElement) {
		return new BlenderListIterator<T>(listElement);
	}

	public static <T> Iterator<T> create(CPointer<T> listElementPointer) throws IOException {
		T list = null;
		if (!listElementPointer.isNull()) {
			list = listElementPointer.get();
		}
		return new BlenderListIterator<T>(list);
	}
	public static <T> Iterator<T> create(ListBase listBase, Class<T> elemType) throws IOException {
		CPointer<T> first = listBase.getFirst().cast(elemType);
		return create(first);
	}


	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T prev = current;
		try {
			current = _getNext(current);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
			throw new RuntimeException(e);
		}
		return prev;
	}
	
	@SuppressWarnings("unchecked")
	private T _getNext(T from) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		CPointer<?> pointer = ((CPointer<?>) getNext.invoke(from));
		if (!pointer.isNull()) {
			return (T) pointer.cast(clazz).get();
		} else {
			return null;
		}
		
	}

}
