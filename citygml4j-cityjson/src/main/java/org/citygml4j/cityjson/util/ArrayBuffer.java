/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
