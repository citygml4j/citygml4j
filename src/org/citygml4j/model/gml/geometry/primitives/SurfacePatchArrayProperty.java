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

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

public class SurfacePatchArrayProperty extends ArrayAssociation<AbstractSurfacePatch> {
	
	public SurfacePatchArrayProperty() {

	}

	public SurfacePatchArrayProperty(AbstractSurfacePatch abstractSurfacePatch) {
		super(abstractSurfacePatch);
	}

	@SuppressWarnings("unchecked")
	public SurfacePatchArrayProperty(List<? extends AbstractSurfacePatch> abstractSurfacePatch) {
		super((List<AbstractSurfacePatch>)abstractSurfacePatch);
	}
	
	public SurfacePatchArrayProperty(AbstractSurfacePatch... abstractSurfacePatch) {
		super(abstractSurfacePatch);
	}
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		super.addObject(surfacePatch);
	}

	public List<? extends AbstractSurfacePatch> getSurfacePatch() {
		return super.getObject();
	}

	public boolean isSetSurfacePatch() {
		return super.isSetObject();
	}

	@SuppressWarnings("unchecked")
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		super.setObject((List<AbstractSurfacePatch>)surfacePatch);
	}

	public void unsetSurfacePatch() {
		super.unsetObject();
	}

	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch) {
		return super.unsetObject(surfacePatch);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_ARRAY_PROPERTY;
	}

	public Class<AbstractSurfacePatch> getAssociableClass() {
		return AbstractSurfacePatch.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfacePatchArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfacePatchArrayProperty copy = (target == null) ? new SurfacePatchArrayProperty() : (SurfacePatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
