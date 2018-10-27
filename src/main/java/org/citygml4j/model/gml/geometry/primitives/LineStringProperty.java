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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class LineStringProperty extends GeometryProperty<LineString> {

	public LineStringProperty() {

	}

	public LineStringProperty(LineString lineString) {
		super(lineString);
	}

	public LineStringProperty(String href) {
		super(href);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_PROPERTY;
	}

	public LineString getLineString() {
		return super.getGeometry();
	}

	public boolean isSetLineString() {
		return super.isSetGeometry();
	}

	public void setLineString(LineString lineString) {
		super.setGeometry(lineString);
	}

	public void unsetLineString() {
		super.unsetGeometry();
	}

	@Override
	public Class<LineString> getAssociableClass() {
		return LineString.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringProperty copy = (target == null) ? new LineStringProperty() : (LineStringProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringProperty(), copyBuilder);
	}
	
}
