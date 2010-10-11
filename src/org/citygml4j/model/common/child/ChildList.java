package org.citygml4j.model.common.child;

import java.util.ArrayList;
import java.util.Collection;

import org.citygml4j.model.common.base.ModelObject;

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
		T child = super.get(super.indexOf(o));
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
