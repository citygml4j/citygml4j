package org.citygml4j.impl.gml.base;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;
import org.citygml4j.model.gml.base.Associable;

public abstract class ArrayAssociationImpl<T extends Associable> implements ArrayAssociation<T> {
	private List<T> object;
	private Object parent;
	
	public void addObject(T object) {
		if (this.object == null)
			this.object = new ChildList<T>(this);
		
		this.object.add(object);
	}

	public List<T> getObject() {
		if (object == null)
			object = new ChildList<T>(this);
		
		return object;
	}

	public boolean isSetObject() {
		return object != null && !object.isEmpty();
	}

	public void setObject(List<T> object) {
		this.object = new ChildList<T>(this, object);
	}

	public void unsetObject() {
		if (isSetObject())
			object.clear();
		
		object = null;
	}

	public boolean unsetObject(T object) {
		return isSetObject() ? this.object.remove(object) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ARRAY_ASSOCIATION;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		ArrayAssociation<T> copy = (ArrayAssociation<T>)target;
		
		if (isSetObject()) {
			for (T part : object) {
				T copyPart = (T)copyBuilder.copy(part);
				copy.addObject(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
