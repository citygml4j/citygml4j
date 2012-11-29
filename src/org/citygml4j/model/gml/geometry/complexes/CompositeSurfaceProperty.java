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
 * $Id$
 */
package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class CompositeSurfaceProperty extends GeometryProperty<CompositeSurface> {

	public CompositeSurfaceProperty() {

	}

	public CompositeSurfaceProperty(CompositeSurface compositeSurface) {
		super(compositeSurface);
	}

	public CompositeSurfaceProperty(String href) {
		super(href);
	}
	
	public CompositeSurface getCompositeSurface() {
		return super.getGeometry();
	}

	public boolean isSetCompositeSurface() {
		return super.isSetGeometry();
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		super.setGeometry(compositeSurface);
	}

	public void unsetCompositeSurface() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_SURFACE_PROPERTY;
	}

	@Override
	public Class<CompositeSurface> getAssociableClass() {
		return CompositeSurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeSurfaceProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeSurfaceProperty copy = (target == null) ? new CompositeSurfaceProperty() : (CompositeSurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
