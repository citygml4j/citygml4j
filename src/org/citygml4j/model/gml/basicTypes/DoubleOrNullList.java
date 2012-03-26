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
package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.DoubleOrNullList;

public class DoubleOrNullList implements GML, Child, Copyable {
	private List<DoubleOrNull> doubleOrNull;
	private ModelObject parent;

	public void addDoubleOrNull(DoubleOrNull doubleOrNull) {
		if (this.doubleOrNull == null)
			this.doubleOrNull = new ChildList<DoubleOrNull>(this);
		
		this.doubleOrNull.add(doubleOrNull);
	}

	public List<DoubleOrNull> getDoubleOrNull() {
		if (doubleOrNull == null)
			doubleOrNull = new ChildList<DoubleOrNull>(this);
		
		return doubleOrNull;
	}

	public boolean isSetDoubleOrNull() {
		return doubleOrNull != null && !doubleOrNull.isEmpty();
	}

	public void setDoubleOrNull(List<DoubleOrNull> doubleOrNull) {
		this.doubleOrNull = new ChildList<DoubleOrNull>(this, doubleOrNull);
	}

	public void unsetDoubleOrNull() {
		if (isSetDoubleOrNull())
			doubleOrNull.clear();
		
		doubleOrNull = null;
	}

	public boolean unsetDoubleOrNull(DoubleOrNull doubleOrNull) {
		return isSetDoubleOrNull() ? this.doubleOrNull.remove(doubleOrNull) : false;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.DOUBLE_OR_NULL_LIST;
	}

	public ModelObject getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DoubleOrNullList(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DoubleOrNullList copy = (target == null) ? new DoubleOrNullList() : (DoubleOrNullList)target;
		
		if (isSetDoubleOrNull()) {
			for (DoubleOrNull part : doubleOrNull) {
				DoubleOrNull copyPart = (DoubleOrNull)copyBuilder.copy(part);
				copy.addDoubleOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
