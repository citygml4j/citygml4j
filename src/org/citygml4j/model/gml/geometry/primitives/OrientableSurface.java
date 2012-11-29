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
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class OrientableSurface extends AbstractSurface {
	private SurfaceProperty baseSurface;
	private Sign orientation;

	public OrientableSurface() {
		
	}
	
	public OrientableSurface(AbstractSurface base, Sign orientation) {
		setBaseSurface(new SurfaceProperty(base));
		setOrientation(orientation);
	}
	
	public OrientableSurface(String xlink, Sign orientation) {
		setBaseSurface(new SurfaceProperty(xlink));
		setOrientation(orientation);
	}
	
	public SurfaceProperty getBaseSurface() {
		return baseSurface;
	}

	public Sign getOrientation() {
		return (orientation == null) ? Sign.PLUS : orientation;
	}

	public boolean isSetBaseSurface() {
		return baseSurface != null;
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setBaseSurface(SurfaceProperty baseSurface) {
		if (baseSurface != null)
			baseSurface.setParent(this);

		this.baseSurface = baseSurface;
	}

	public void setOrientation(Sign orientation) {
		this.orientation = orientation;
	}

	public void unsetBaseSurface() {
		if (isSetBaseSurface())
			baseSurface.unsetParent();
		
		baseSurface = null;
	}

	public void unsetOrientation() {
		orientation = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetBaseSurface() && baseSurface.isSetSurface())
			bbox.update(baseSurface.getSurface().calcBoundingBox());
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ORIENTABLE_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OrientableSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OrientableSurface copy = (target == null) ? new OrientableSurface() : (OrientableSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetBaseSurface()) {
			copy.setBaseSurface((SurfaceProperty)copyBuilder.copy(baseSurface));
			if (copy.getBaseSurface() == baseSurface)
				baseSurface.setParent(this);
		}
		
		if (isSetOrientation())
			copy.setOrientation((Sign)copyBuilder.copy(orientation));
		
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
