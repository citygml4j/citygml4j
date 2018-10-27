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

public class MultiLineStringProperty extends GeometryProperty<MultiLineString> {

	public MultiLineStringProperty() {

	}

	public MultiLineStringProperty(MultiLineString multiLineString) {
		super(multiLineString);
	}

	public MultiLineStringProperty(String href) {
		super(href);
	}
	
	public MultiLineString getMultiLineString() {
		return super.getGeometry();
	}

	public boolean isSetMultiLineString() {
		return super.isSetGeometry();
	}

	public void setMultiLineString(MultiLineString multiLineString) {
		super.setGeometry(multiLineString);
	}

	public void unsetMultiLineString() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_LINE_STRING_PROPERTY;
	}

	@Override
	public Class<MultiLineString> getAssociableClass() {
		return MultiLineString.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiLineStringProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiLineStringProperty copy = (target == null) ? new MultiLineStringProperty() : (MultiLineStringProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
