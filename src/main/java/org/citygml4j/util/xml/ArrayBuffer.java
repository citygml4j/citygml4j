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
package org.citygml4j.util.xml;

import java.lang.reflect.Array;

public class ArrayBuffer<T> {
	private final static int DEFAULT_SIZE = 512;

	private T[] items;
	private ArrayBuffer<T> next;
	private ArrayBuffer<T> previous;

	private int ptr;

	@SuppressWarnings("unchecked")
	protected ArrayBuffer(Class<T> c, int size, ArrayBuffer<T> previous) {
		items = (T[])Array.newInstance(c, size);
		this.previous = previous;
	}

	protected ArrayBuffer(Class<T> c, int size) {
		this(c, size, null);
	}

	protected ArrayBuffer(Class<T> c, ArrayBuffer<T> previous) {
		this(c, DEFAULT_SIZE, previous);
	}

	protected ArrayBuffer(Class<T> c) {
		this(c, DEFAULT_SIZE, null);
	}

	public int size() {
		return items.length;
	}

	public int currentPtr() {
		return ptr;
	}

	public void decrementPtr() {
		if (ptr > 0)
			ptr--;
	}

	public ArrayBuffer<T> nextBuffer() {
		return next;
	}

	public ArrayBuffer<T> previousBuffer() {
		return previous;
	}

	public void dropPreviousBuffer() {
		previous = null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayBuffer<T> appendBuffer() {
		ArrayBuffer<T> next = new ArrayBuffer(items.getClass().getComponentType(), items.length, this);
		this.next = next;
		return next;
	}

	public ArrayBuffer<T> rewindToHeadBuffer() {
		ArrayBuffer<T> head = this;
		ptr = 1;

		while (head.previous != null) {
			head = head.previous;
			head.ptr = 1;
		}

		return head;
	}

	public ArrayBuffer<T> dropBuffer() {
		if (previous == null)
			return this;

		ArrayBuffer<T> previous = this.previous;
		previous.next = null;
		return previous;
	}

	public void push(T item) {
		if (ptr == items.length)
			throw new IllegalStateException("Cannot push onto a full buffer.");			

		items[ptr++] = item;
	}

	public T peek() {
		if (ptr == 0)
			return previous != null ? previous.peek() : null;

		return items[ptr - 1];
	}

	public T pop() {
		if (ptr == 0)
			throw new IllegalStateException("Cannot pop from on an empty buffer.");

		T tmp = items[--ptr];
		items[ptr] = null;

		return tmp;
	}

	public T next(boolean release) {
		if (ptr == 0)
			throw new IllegalStateException("Cannot call next on an empty buffer.");

		T tmp = items[ptr -1];
		if (release)
			items[ptr - 1] = null;

		ptr++;
		return tmp;
	}

}
