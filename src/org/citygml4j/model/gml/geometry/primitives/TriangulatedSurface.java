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
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class TriangulatedSurface extends Surface {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGULATED_SURFACE;
	}

	public TrianglePatchArrayProperty getTrianglePatches() {
		return getPatches();
	}

	public boolean isSetTrianglePatches() {
		return super.isSetPatches();
	}

	public void setTrianglePatches(TrianglePatchArrayProperty trianglePatches) {
		super.setPatches(trianglePatches);
	}

	public void unsetTrianglePatches() {
		super.unsetPatches();
	}
	
	@Override
	public TrianglePatchArrayProperty getPatches() {
		return (TrianglePatchArrayProperty)super.getPatches();
	}

	@Override
	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches instanceof TrianglePatchArrayProperty)
			super.setPatches(patches);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TriangulatedSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TriangulatedSurface copy = (target == null) ? new TriangulatedSurface() : (TriangulatedSurface)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
