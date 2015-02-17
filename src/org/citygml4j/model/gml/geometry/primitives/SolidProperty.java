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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class SolidProperty extends GeometryProperty<AbstractSolid> {
	
	public SolidProperty() {

	}

	public SolidProperty(AbstractSolid abstractSolid) {
		super(abstractSolid);
	}

	public SolidProperty(String href) {
		super(href);
	}
	
	public AbstractSolid getSolid() {
		return super.getGeometry();
	}

	public boolean isSetSolid() {
		return super.isSetGeometry();
	}

	public void setSolid(AbstractSolid abstractSolid) {
		super.setGeometry(abstractSolid);
	}

	public void unsetSolid() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.SOLID_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SolidProperty(), copyBuilder);
	}

	@Override
	public Class<AbstractSolid> getAssociableClass() {
		return AbstractSolid.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SolidProperty copy = (target == null) ? new SolidProperty() : (SolidProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
