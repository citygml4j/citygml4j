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
package org.citygml4j.impl.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AssociationByRep;

public abstract class AssociationByRepImpl<T extends Associable & Child> implements AssociationByRep<T> {
	private T object;
	private ModelObject parent;

	public T getObject() {
		return object;
	}

	public boolean isSetObject() {
		return object != null;
	}

	public void setObject(T object) {
		if (object != null)
			object.setParent(this);
		
		this.object = object;
	}

	public void unsetObject() {
		if (isSetObject())
			object.unsetParent();
		
		object = null;
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ASSOCIATION_BY_REP;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AssociationByRep<T> copy = (AssociationByRep<T>)target;
        
		if (isSetObject()) {
			copy.setObject((T)copyBuilder.copy(object));
			if (copy.getObject() == object)
				object.setParent(this);
		}
		
		copy.unsetParent();
		
        return copy;
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

}
