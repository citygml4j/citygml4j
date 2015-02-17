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
package org.citygml4j.model.gml.geometry.aggregates;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;

public class MultiPoint extends AbstractGeometricAggregate {
	private List<PointProperty> pointMember;
	private PointArrayProperty pointMembers;
	
	public MultiPoint() {
		
	}
	
	public MultiPoint(List<Point> points) {
		for (Point point : points)
			addPointMember(new PointProperty(point));
	}
	
	public MultiPoint(Point... points) {
		this(Arrays.asList(points));
	}
	
	public void addPointMember(PointProperty pointMember) {
		if (this.pointMember == null)
			this.pointMember = new ChildList<PointProperty>(this);
		
		this.pointMember.add(pointMember);
	}

	public List<PointProperty> getPointMember() {
		if (pointMember == null)
			pointMember = new ChildList<PointProperty>(this);
		
		return pointMember;
	}

	public PointArrayProperty getPointMembers() {
		return pointMembers;
	}

	public boolean isSetPointMember() {
		return pointMember != null && !pointMember.isEmpty();
	}

	public boolean isSetPointMembers() {
		return pointMembers != null;
	}

	public void setPointMember(List<PointProperty> pointMember) {
		this.pointMember = new ChildList<PointProperty>(this, pointMember);
	}

	public void setPointMembers(PointArrayProperty pointMembers) {
		if (pointMembers != null)
			pointMembers.setParent(this);
		
		this.pointMembers = pointMembers;
	}

	public void unsetPointMember() {
		if (isSetPointMember())
			pointMember.clear();
		
		pointMember = null;
	}

	public boolean unsetPointMember(PointProperty pointMember) {
		return isSetPointMember() ? this.pointMember.remove(pointMember) : false;
	}

	public void unsetPointMembers() {
		if (isSetPointMembers())
			pointMembers.unsetParent();
		
		pointMembers = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetPointMember()) {
			for (PointProperty pointProperty : getPointMember())
				if (pointProperty.isSetPoint())
					bbox.update(pointProperty.getPoint().calcBoundingBox());
		}

		if (isSetPointMembers()) {
			PointArrayProperty pointArrayProperty = getPointMembers();
			
			if (pointArrayProperty.isSetPoint())
				for (Point point : pointArrayProperty.getPoint())
					bbox.update(point.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POINT;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPoint(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPoint copy = (target == null) ? new MultiPoint() : (MultiPoint)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPointMember()) {
			for (PointProperty part : pointMember) {
				PointProperty copyPart = (PointProperty)copyBuilder.copy(part);
				copy.addPointMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPointMembers()) {
			copy.setPointMembers((PointArrayProperty)copyBuilder.copy(pointMembers));
			if (copy.getPointMembers() == pointMembers)
				pointMembers.setParent(this);
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
