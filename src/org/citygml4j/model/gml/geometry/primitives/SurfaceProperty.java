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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
	package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class SurfaceProperty extends GeometryProperty<AbstractSurface> {
	
	public SurfaceProperty() {

	}

	public SurfaceProperty(AbstractSurface abstractSurface) {
		super(abstractSurface);
	}

	public SurfaceProperty(String href) {
		super(href);
	}
	
	public AbstractSurface getSurface() {
		return super.getGeometry();
	}

	public boolean isSetSurface() {
		return super.isSetGeometry();
	}

	public void setSurface(AbstractSurface abstractSurface) {
		super.setGeometry(abstractSurface);
	}

	public void unsetSurface() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_PROPERTY;
	}

	@Override
	public Class<AbstractSurface> getAssociableClass() {
		return AbstractSurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceProperty copy = (target == null) ? new SurfaceProperty() : (SurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
