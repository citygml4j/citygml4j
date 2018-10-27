/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.copy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;

public abstract class CopyBuilder {
	private HashSet<Class<?>> shallowCopy = new HashSet<Class<?>>();
	private HashSet<Class<?>> nullCopy = new HashSet<Class<?>>();

	public Object copy(final Object target) {
		if (target instanceof String)
			return copy((String)target);
		else if (target instanceof Number)
			return copy((Number)target);
		else if (target instanceof Boolean)
			return copy((Boolean)target);
		else if (target instanceof Character)
			return copy((Character)target);
		else if (target instanceof Void)
			return copy((Void)target);
		else if (target instanceof Cloneable)
			try {
				return copyCloneable((Cloneable)target);
			} catch (UnsupportedOperationException e) {
				return target;
			}
		else
			return target;
	}

	public void setShallowCopy(final Class<?>... c) {
		for (final Class<?> item : c)
			shallowCopy.add(item);
	}

	public void setNullCopy(final Class<?>... c) {
		for (final Class<?> item : c)
			nullCopy.add(item);
	}

	public void unsetShallowCopy(final Class<?>... c) {
		for (final Class<?> item : c)
			shallowCopy.remove(item);
	}

	public void unsetNullCopy(final Class<?>... c) {
		for (final Class<?> item : c)
			nullCopy.remove(item);
	}

	protected boolean isNullCopy(Object target) {
		if (target == null)
			return true;

		if (nullCopy.contains(target.getClass()))
			return true;

		for (Class<?> c : target.getClass().getInterfaces())
			if (nullCopy.contains(c))
				return true;

		return false;
	}

	protected boolean isShallowCopy(Object target) {
		if (shallowCopy.contains(target.getClass()))
			return true;

		for (Class<?> c : target.getClass().getInterfaces())
			if (shallowCopy.contains(c))
				return true;

		return false;
	}

	protected boolean shallowSetContains(Class<?> c) {
		return shallowCopy.contains(c);
	}

	public String copy(String value) {
		return value != null ? (nullCopy.contains(value.getClass()) ? null : value) : null;
	}

	public Number copy(Number value) {
		return value != null ? (nullCopy.contains(value.getClass()) ? null : value) : null;
	}

	public Boolean copy(Boolean value) {
		return value != null ? (nullCopy.contains(value.getClass()) ? null : value) : null;
	}

	public Character copy(Character value) {
		return value != null ? (nullCopy.contains(value.getClass()) ? null : value) : null;
	}

	public Void copy(Void value) {
		return value != null ? (nullCopy.contains(value.getClass()) ? null : value) : null;
	}

	public Class<?> copy(Class<?> value) {
		return value != null ? (nullCopy.contains(value.getClass()) ? null : value) : null;
	}

	public long copy(long value) {
		return value;
	}

	public int copy(int value) {
		return value;
	}

	public short copy(short value) {
		return value;
	}

	public char copy(char value) {
		return value;
	}

	public byte copy(byte value) {
		return value;
	}

	public double copy(double value) {
		return value;
	}

	public float copy(float value) {
		return value;
	}

	public boolean copy(boolean value) {
		return value;
	}

	public Object[] copy(Object[] array) {
		final Object[] copy = new Object[array.length];

		for (int index = 0; index < array.length; index++) {
			final Object item = array[index];
			final Object itemCopy = copy(item);
			copy[index] = itemCopy;
		}

		return copy;
	}

	public long[] copy(long[] array) {
		final long[] copy = new long[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public int[] copy(int[] array) {
		final int[] copy = new int[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public short[] copy(short[] array) {
		final short[] copy = new short[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public char[] copy(char[] array) {
		final char[] copy = new char[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public byte[] copy(byte[] array) {
		final byte[] copy = new byte[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public double[] copy(double[] array) {
		final double[] copy = new double[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public float[] copy(float[] array) {
		final float[] copy = new float[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public boolean[] copy(boolean[] array) {
		final boolean[] copy = new boolean[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);

		return copy;
	}

	public Object copyCloneable(Cloneable object) {
		Method method = null;

		try {
			method = object.getClass().getMethod("clone", (Class[]) null);
		} catch (NoSuchMethodException nsmex) {
			method = null;
		}

		if (method == null || !Modifier.isPublic(method.getModifiers())) {
			throw new UnsupportedOperationException(
					"Could not clone object [" + object + "].",
					new CloneNotSupportedException(
							"Object class ["
							+ object.getClass()
							+ "] implements java.lang.Cloneable interface, "
							+ "but does not provide a public no-arg clone() method. "
							+ "By convention, classes that implement java.lang.Cloneable "
							+ "should override java.lang.Object.clone() method (which is protected) "
							+ "with a public method."));
		}

		final boolean wasAccessible = method.isAccessible();
		try {
			if (!wasAccessible) {
				try {
					method.setAccessible(true);
				} catch (SecurityException ignore) {
					//
				}
			}

			return method.invoke(object, (Object[]) null);
		} catch (Exception ex) {
			throw new UnsupportedOperationException(
					"Could not clone the object ["
					+ object
					+ "] as invocation of the clone() method has thrown an exception.",
					ex);
		} finally {
			if (!wasAccessible) {
				try {
					method.setAccessible(false);
				} catch (SecurityException ignore) {
					//
				}
			}
		}
	}

}
