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
package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Triangle;
import org.citygml4j.model.gml.geometry.primitives.TrianglePatchArrayProperty;

public class TrianglePatchArrayPropertyImpl extends SurfacePatchArrayPropertyImpl implements TrianglePatchArrayProperty {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGLE_PATCH_ARRAY_PROPERTY;
	}

	public void addTriangle(Triangle triangle) {
		super.addSurfacePatch(triangle);
	}

	@SuppressWarnings("unchecked")
	public List<Triangle> getTriangle() {
		return (List<Triangle>)super.getSurfacePatch();
	}

	public boolean isSetTriangle() {
		return super.isSetSurfacePatch();
	}

	public void setTriangle(List<Triangle> triangle) {
		super.setSurfacePatch(triangle);
	}

	public void unsetTriangle() {
		super.unsetSurfacePatch();
	}

	public boolean unsetTriangle(Triangle triangle) {
		return super.unsetSurfacePatch(triangle);
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrianglePatchArrayProperty copy = (target == null) ? new TrianglePatchArrayPropertyImpl() : (TrianglePatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrianglePatchArrayPropertyImpl(), copyBuilder);
	}

}
