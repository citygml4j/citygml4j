/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

import java.util.List;

public class PointArrayProperty extends GeometryArrayProperty<Point> {
	
	public PointArrayProperty() {

	}

	public PointArrayProperty(Point point) {
		super(point);
	}

	public PointArrayProperty(List<Point> point) {
		super(point);
	}
	
	public PointArrayProperty(Point... point) {
		super(point);
	}
	
	public void addPoint(Point point) {
		super.addGeometry(point);
	}

	public List<Point> getPoint() {
		return super.getGeometry();
	}

	public boolean isSetPoint() {
		return super.isSetGeometry();
	}

	public void setPoint(List<Point> point) {
		super.setGeometry(point);
	}

	public void unsetPoint() {
		super.unsetGeometry();
	}

	public boolean unsetPoint(Point point) {
		return super.unsetGeometry(point);
	}

	public GMLClass getGMLClass() {
		return GMLClass.POINT_ARRAY_PROPERTY;
	}

	public Class<Point> getAssociableClass() {
		return Point.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PointArrayProperty copy = (target == null) ? new PointArrayProperty() : (PointArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
