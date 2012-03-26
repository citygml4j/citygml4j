/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.base;

import java.util.HashMap;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.association.Association;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public abstract class ArrayAssociation<T extends Associable & Child> implements GML, Association<T>, Child, Copyable {
	private List<T> object;
	private HashMap<String, Object> localProperties;
	private ModelObject parent;
	
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

	public ModelType getModelType() {
		return ModelType.GML;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ARRAY_ASSOCIATION;
	}
	
	public Object getLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.get(name);
			
		return null;
	}

	public void setLocalProperty(String name, Object value) {
		if (localProperties == null)
			localProperties = new HashMap<String, Object>();
		
		localProperties.put(name, value);
	}

	public boolean hasLocalProperty(String name) {
		return localProperties != null && localProperties.containsKey(name);
	}

	public Object unsetLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.remove(name);
		
		return null;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
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
