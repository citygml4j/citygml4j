/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.common.child;

import org.citygml4j.model.common.base.ModelObject;

import java.util.ArrayList;
import java.util.Collection;

public class ChildList<T extends Child> extends ArrayList<T> {
	private static final long serialVersionUID = 1L;
	private ModelObject parent;

	public ChildList(ModelObject parent) {
		this.parent = parent;
	}
	
	public ChildList(ModelObject parent, Collection<? extends T> c) {
		super(c);
		this.parent = parent;

		for (final T child : this)
			if (child != null)
				child.setParent(parent);
	}

	public ChildList(ModelObject parent, int initialCapacity) {
		super(initialCapacity);
		this.parent = parent;
	}
	
	@Override
	public void add(int index, T element) {
		if (element != null)
			element.setParent(parent);
		
		super.add(index, element);
	}

	@Override
	public boolean add(T o) {
		if (o != null)
			o.setParent(parent);
		
		return super.add(o);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (final T child : c)
			if (child != null)
				child.setParent(parent);
		
		return super.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		for (final T child : c)
			if (child != null)
				child.setParent(parent);
		
		return super.addAll(index, c);
	}

	@Override
	public void clear() {
		for (final T child : this)
			if (child != null)
				child.unsetParent();
		
		super.clear();
	}

	@Override
	public T remove(int index) {
		final T child = super.remove(index);
		if (child != null)
			child.unsetParent();
		
		return child;
	}

	@Override
	public boolean remove(Object o) {
		int index = super.indexOf(o);
		if (index == - 1)
			return false;
		
		T child = super.get(index);
		if (child != null)
			child.unsetParent();
		
		return super.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (final T child : this)
			if (child != null && c.contains(child))
				child.unsetParent();
		
		return super.removeAll(c);
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		for (int index = fromIndex; index < toIndex; ++index) {
			T child = super.get(index);
			if (child != null)
				child.unsetParent();
		}
		
		super.removeRange(fromIndex, toIndex);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		for (final T child : this)
			if (child != null && !c.contains(child))
				child.unsetParent();

		return super.retainAll(c);
	}

	@Override
	public T set(int index, T element) {
		final T child = super.set(index, element);
		
		if (element != null)
			element.setParent(parent);
		
		if (child != null)
			child.unsetParent();

		return child;
	}	
	
}
