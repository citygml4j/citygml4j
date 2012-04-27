/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;

public class Triangle extends AbstractSurfacePatch {
	private AbstractRingProperty exterior;
	private SurfaceInterpolation interpolation;
	private ModelObject parent;

	public AbstractRingProperty getExterior() {
		return exterior;
	}

	public SurfaceInterpolation getInterpolation() {
		if (interpolation == null)
			return SurfaceInterpolation.PLANAR;
		else
			return interpolation;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public boolean isSetInterpolation() {
		return interpolation != null;
	}

	public void setExterior(AbstractRingProperty exterior) {
		if (exterior != null)
			exterior.setParent(this);

		this.exterior = exterior;
	}

	public void setInterpolation(SurfaceInterpolation interpolation) {
		this.interpolation = SurfaceInterpolation.PLANAR;
	}

	public void unsetExterior() {
		if (isSetExterior())
			exterior.unsetParent();

		exterior = null;
	}

	public void unsetInterpolation() {
		interpolation = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior() && exterior.isSetRing()) 
			bbox.update(exterior.getRing().calcBoundingBox());
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGLE;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Triangle(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Triangle copy = (target == null) ? new Triangle() : (Triangle)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetExterior()) {
			copy.setExterior((AbstractRingProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}

		if (isSetInterpolation())
			copy.setInterpolation((SurfaceInterpolation)copyBuilder.copy(interpolation));

		return copy;
	}

}
