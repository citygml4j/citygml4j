/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.geometry.aggregates;

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

import java.util.Arrays;
import java.util.List;

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
