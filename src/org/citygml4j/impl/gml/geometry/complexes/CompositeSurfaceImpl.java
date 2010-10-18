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
package org.citygml4j.impl.gml.geometry.complexes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.impl.gml.geometry.primitives.AbstractSurfaceImpl;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;

public class CompositeSurfaceImpl extends AbstractSurfaceImpl implements CompositeSurface {
	private List<SurfaceProperty> surfaceMember;
	
	public void addSurfaceMember(SurfaceProperty surfaceMember) {
		if (this.surfaceMember == null)
			this.surfaceMember = new ChildList<SurfaceProperty>(this);
		
		this.surfaceMember.add(surfaceMember);
	}

	public List<SurfaceProperty> getSurfaceMember() {
		if (surfaceMember == null)
			surfaceMember = new ChildList<SurfaceProperty>(this);
		
		return surfaceMember;
	}

	public boolean isSetSurfaceMember() {
		return surfaceMember != null && !surfaceMember.isEmpty();
	}

	public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
		this.surfaceMember = new ChildList<SurfaceProperty>(this, surfaceMember);
	}

	public void unsetSurfaceMember() {
		if (isSetSurfaceMember())
			surfaceMember.clear();
		
		surfaceMember = null;
	}

	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember) {
		return isSetSurfaceMember() ? this.surfaceMember.remove(surfaceMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : getSurfaceMember())
				if (surfaceProperty.isSetSurface())
					bbox.update(surfaceProperty.getSurface().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeSurface copy = (target == null) ? new CompositeSurfaceImpl() : (CompositeSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetSurfaceMember()) {
			for (SurfaceProperty part : surfaceMember) {
				SurfaceProperty copyPart = (SurfaceProperty)copyBuilder.copy(part);
				copy.addSurfaceMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
