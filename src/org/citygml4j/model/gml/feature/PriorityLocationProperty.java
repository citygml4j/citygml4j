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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class PriorityLocationProperty extends LocationProperty {
	private String priority;
	
	public PriorityLocationProperty() {

	}

	public PriorityLocationProperty(AbstractGeometry abstractGeometry) {
		super(abstractGeometry);
	}

	public PriorityLocationProperty(String href) {
		super(href);
	}
	
	public String getPriority() {
		return priority;
	}

	public boolean isSetPriority() {
		return priority != null;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void unsetPriority() {
		priority = null;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PriorityLocationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PriorityLocationProperty copy = (target == null) ? new PriorityLocationProperty() : (PriorityLocationProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPriority())
			copy.setPriority(copyBuilder.copy(priority));
		
		return copy;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.PRIORITY_LOCATION_PROPERTY;
	}

}
