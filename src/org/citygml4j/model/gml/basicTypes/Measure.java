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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Measure;

public class Measure implements GML, Child, Copyable {
	private double value;
	private String uom;
	private ModelObject parent;
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.MEASURE;
	}

	public String getUom() {
		return uom;
	}

	public double getValue() {
		return value;
	}

	public boolean isSetUom() {
		return uom != null;
	}

	public boolean isSetValue() {
		return true;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void setValue(double value) {
		this.value = value;
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

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Measure copy = (target == null) ? new Measure() : (Measure)target;
		
		if (isSetValue())
			copy.setValue((Double)copyBuilder.copy(value));
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Measure(), copyBuilder);
	}
}
