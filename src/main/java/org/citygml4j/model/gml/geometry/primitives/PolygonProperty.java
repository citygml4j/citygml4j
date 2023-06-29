/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class PolygonProperty extends GeometryProperty<Polygon> {
	
	public PolygonProperty() {

	}

	public PolygonProperty(Polygon polygon) {
		super(polygon);
	}

	public PolygonProperty(String href) {
		super(href);
	}
	
	public Polygon getPolygon() {
		return super.getGeometry();
	}

	public boolean isSetPolygon() {
		return super.isSetGeometry();
	}

	public void setPolygon(Polygon polygon) {
		super.setGeometry(polygon);
	}

	public void unsetPolygon() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.POLYGON_PROPERTY;
	}

	@Override
	public Class<Polygon> getAssociableClass() {
		return Polygon.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PolygonProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PolygonProperty copy = (target == null) ? new PolygonProperty() : (PolygonProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
