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
package org.citygml4j.impl.gml.valueObjects;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.Value;
import org.citygml4j.model.gml.valueObjects.ValueArrayProperty;

public class ValueArrayPropertyImpl extends ArrayAssociationImpl<Value> implements ValueArrayProperty {
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_ARRAY_PROPERTY;
	}

	public List<Value> getValue() {
		return super.getObject();
	}

	public boolean isSetValue() {
		return super.isSetObject();
	}

	public void setValue(List<Value> value) {
		super.setObject(value);
	}

	public void addValue(Value value) {
		super.addObject(value);
	}

	public void unsetValue() {
		super.unsetObject();
	}

	public boolean unsetValue(Value value) {
		return super.unsetObject(value);
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArrayProperty copy = (target == null) ? new ValueArrayPropertyImpl() : (ValueArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArrayPropertyImpl(), copyBuilder);
	}

}
