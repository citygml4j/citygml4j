/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.util;

import java.util.*;

public class ArrayBuffer<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 4096;

    private Object[] elements;
    private final int capacity;
    private int size;
    private int modCount;

    public ArrayBuffer(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            elements = new Object[DEFAULT_CAPACITY];
        }

        this.capacity = elements.length;
    }

    public ArrayBuffer() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elements[index];
    }

    public void add(E element) {
        modCount++;
        if (size == elements.length) {
            grow(elements.length + capacity);
        }

        elements[size++] = element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        modCount++;
        elements = new Object[capacity];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayBufferIterator();
    }

    private void grow(int newCapacity) {
        if (newCapacity < 0) {
            throw new OutOfMemoryError();
        }

        elements = Arrays.copyOf(elements, newCapacity);
    }

    private class ArrayBufferIterator implements Iterator<E> {
        private final int expectedModCount = modCount;
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            } else if (cursor >= size) {
                throw new NoSuchElementException();
            }

            return (E) elements[cursor++];
        }
    }
}
