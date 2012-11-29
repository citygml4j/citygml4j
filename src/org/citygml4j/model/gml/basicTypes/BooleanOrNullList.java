/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
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
 * 
 * $Id: BooleanOrNullList.java 542 2012-11-29 20:56:44Z nagel $
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

public class BooleanOrNullList implements GML, Child, Copyable {
	private List<BooleanOrNull> booleanOrNull;
	private ModelObject parent;

	public void addBooleanOrNull(BooleanOrNull booleanOrNull) {
		if (this.booleanOrNull == null)
			this.booleanOrNull = new ChildList<BooleanOrNull>(this);
		
		this.booleanOrNull.add(booleanOrNull);
	}

	public List<BooleanOrNull> getBooleanOrNull() {
		if (booleanOrNull == null)
			booleanOrNull = new ChildList<BooleanOrNull>(this);
		
		return booleanOrNull;
	}

	public boolean isSetBooleanOrNull() {
		return booleanOrNull != null && !booleanOrNull.isEmpty();
	}

	public void setBooleanOrNull(List<BooleanOrNull> booleanOrNull) {
		this.booleanOrNull = new ChildList<BooleanOrNull>(this, booleanOrNull);
	}

	public void unsetBooleanOrNull() {
		if (isSetBooleanOrNull())
			booleanOrNull.clear();
		
		booleanOrNull = null;
	}

	public boolean unsetBooleanOrNull(BooleanOrNull booleanOrNull) {
		return isSetBooleanOrNull() ? this.booleanOrNull.remove(booleanOrNull) : false;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.BOOLEAN_OR_NULL_LIST;
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
		return copyTo(new BooleanOrNullList(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BooleanOrNullList copy = (target == null) ? new BooleanOrNullList() : (BooleanOrNullList)target;
		
		if (isSetBooleanOrNull()) {
			for (BooleanOrNull part : booleanOrNull) {
				BooleanOrNull copyPart = (BooleanOrNull)copyBuilder.copy(part);
				copy.addBooleanOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
