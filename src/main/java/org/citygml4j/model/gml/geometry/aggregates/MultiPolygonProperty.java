/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class MultiPolygonProperty extends GeometryProperty<MultiPolygon> {
	
	public MultiPolygonProperty() {

	}

	public MultiPolygonProperty(MultiPolygon multiPolygon) {
		super(multiPolygon);
	}

	public MultiPolygonProperty(String href) {
		super(href);
	}
	
	public MultiPolygon getMultiPolygon() {
		return super.getGeometry();
	}

	public boolean isSetMultiPolygon() {
		return super.isSetGeometry();
	}

	public void setMultiPolygon(MultiPolygon multiPolygon) {
		super.setGeometry(multiPolygon);
	}

	public void unsetMultiPolygon() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POLYGON_PROPERTY;
	}

	@Override
	public Class<MultiPolygon> getAssociableClass() {
		return MultiPolygon.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPolygonProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPolygonProperty copy = (target == null) ? new MultiPolygonProperty() : (MultiPolygonProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
