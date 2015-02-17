/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
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
import org.citygml4j.model.gml.basicTypes.IntegerOrNull;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;

public class IntegerOrNullList implements GML, Child, Copyable {
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
		return copyTo(new IntegerOrNullList(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntegerOrNullList copy = (target == null) ? new IntegerOrNullList() : (IntegerOrNullList)target;
		
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
