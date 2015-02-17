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
package org.citygml4j.model.gml.valueObjects;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;

public class ValueArray extends CompositeValue {
	private String codeSpace;
	private String uom;
	
	public ValueArray() {
		
	}
	
	public ValueArray(List<Value> values) {
		for (Value value : values)
			addValueComponent(new ValueProperty(value));
	}
	
	public ValueArray(Value... values) {
		this(Arrays.asList(values));
	}
	
	public String getCodeSpace() {
		return codeSpace;
	}

	public String getUom() {
		return uom;
	}

	public boolean isSetCodeSpace() {
		return codeSpace != null;
	}

	public boolean isSetUom() {
		return uom != null;
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
	}

	public void unsetUom() {
		uom = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_ARRAY;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArray copy = (target == null) ? new ValueArray() : (ValueArray)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArray(), copyBuilder);
	}

	@Override
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
