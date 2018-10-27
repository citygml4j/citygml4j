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
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class MultiPointProperty extends GeometryProperty<MultiPoint> {

	public MultiPointProperty() {

	}

	public MultiPointProperty(MultiPoint multiPoint) {
		super(multiPoint);
	}

	public MultiPointProperty(String href) {
		super(href);
	}
	
	public MultiPoint getMultiPoint() {
		return super.getGeometry();
	}

	public boolean isSetMultiPoint() {
		return super.isSetGeometry();
	}

	public void setMultiPoint(MultiPoint multiPoint) {
		super.setGeometry(multiPoint);
	}

	public void unsetMultiPoint() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POINT_PROPERTY;
	}

	@Override
	public Class<MultiPoint> getAssociableClass() {
		return MultiPoint.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPointProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPointProperty copy = (target == null) ? new MultiPointProperty() : (MultiPointProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
