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
import org.citygml4j.impl.gml.geometry.AbstractGeometryImpl;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;

public class GeometricComplexImpl extends AbstractGeometryImpl implements GeometricComplex {
	private List<GeometricPrimitiveProperty> element;

	public void addElement(GeometricPrimitiveProperty element) {
		if (this.element == null)
			this.element = new ChildList<GeometricPrimitiveProperty>(this);

		this.element.add(element);
	}

	public List<GeometricPrimitiveProperty> getElement() {
		if (element == null)
			element = new ChildList<GeometricPrimitiveProperty>(this);

		return element;
	}

	public boolean isSetElement() {
		return element != null && !element.isEmpty();
	}

	public void setElement(List<GeometricPrimitiveProperty> element) {
		this.element = new ChildList<GeometricPrimitiveProperty>(this, element);
	}

	public void unsetElement() {
		if (isSetElement())
			element.clear();

		element = null;
	}

	public boolean unsetElement(GeometricPrimitiveProperty element) {
		return isSetElement() ? this.element.remove(element) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetElement()) {
			for (GeometricPrimitiveProperty part : element)
				if (part.isSetGeometricPrimitive())
					bbox.update(part.getGeometricPrimitive().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_COMPLEX;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricComplexImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricComplex copy = (target == null) ? new GeometricComplexImpl() : (GeometricComplex)target;
		super.copyTo(copy, copyBuilder);

		if (isSetElement()) {
			for (GeometricPrimitiveProperty part : element) {
				GeometricPrimitiveProperty copyPart = (GeometricPrimitiveProperty)copyBuilder.copy(part);
				copy.addElement(copyPart);

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
