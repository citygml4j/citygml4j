/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
package org.citygml4j.impl.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.IntegerOrNull;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;

public class IntegerOrNullListImpl implements IntegerOrNullList {
	private List<IntegerOrNull> integerOrNull;
	private ModelObject parent;

	public void addIntegerOrNull(IntegerOrNull integerOrNull) {
		if (this.integerOrNull == null)
			this.integerOrNull = new ChildList<IntegerOrNull>(this);
		
		this.integerOrNull.add(integerOrNull);
	}

	public List<IntegerOrNull> getIntegerOrNull() {
		if (integerOrNull == null)
			integerOrNull = new ChildList<IntegerOrNull>(this);
		
		return integerOrNull;
	}

	public boolean isSetIntegerOrNull() {
		return integerOrNull != null && !integerOrNull.isEmpty();
	}

	public void setIntegerOrNull(List<IntegerOrNull> integerOrNull) {
		this.integerOrNull = new ChildList<IntegerOrNull>(this, integerOrNull);
	}

	public void unsetIntegerOrNull() {
		if (isSetIntegerOrNull())
			integerOrNull.clear();
		
		integerOrNull = null;
	}

	public boolean unsetIntegerOrNull(IntegerOrNull integerOrNull) {
		return isSetIntegerOrNull() ? this.integerOrNull.remove(integerOrNull) : false;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.INTEGER_OR_NULL_LIST;
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
		return copyTo(new IntegerOrNullListImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntegerOrNullList copy = (target == null) ? new IntegerOrNullListImpl() : (IntegerOrNullList)target;
		
		if (isSetIntegerOrNull()) {
			for (IntegerOrNull part : integerOrNull) {
				IntegerOrNull copyPart = (IntegerOrNull)copyBuilder.copy(part);
				copy.addIntegerOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
