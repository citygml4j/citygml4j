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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.GenericsModule;

public class IntAttribute extends AbstractGenericAttribute {
	private Integer value;
	
	public IntAttribute() {

	}

	public IntAttribute(GenericsModule module) {
		super(module);
	}
	
	public Integer getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_ATTRIBUTE;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntAttribute(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntAttribute copy = (target == null) ? new IntAttribute() : (IntAttribute)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValue())
			copy.setValue((Integer)copyBuilder.copy(value));
		
		return copy;
	}

}
