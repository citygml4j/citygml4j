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
 * $Id: TriangulatedSurface.java 542 2012-11-29 20:56:44Z nagel $
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
