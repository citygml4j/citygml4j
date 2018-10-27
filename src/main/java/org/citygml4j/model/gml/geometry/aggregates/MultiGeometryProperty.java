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

public class MultiGeometryProperty extends GeometryProperty<AbstractGeometricAggregate> {

	public MultiGeometryProperty() {

	}

	public MultiGeometryProperty(AbstractGeometricAggregate abstractGeometricAggregate) {
		super(abstractGeometricAggregate);
	}

	public MultiGeometryProperty(String href) {
		super(href);
	}
	
	public AbstractGeometricAggregate getGeometricAggregate() {
		return super.getGeometry();
	}

	public boolean isSetGeometricAggregate() {
		return super.isSetGeometry();
	}

	public void setGeometricAggregate(AbstractGeometricAggregate geometricAggregate) {
		super.setGeometry(geometricAggregate);
	}

	public void unsetGeometricAggregate() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_GEOMETRY_PROPERTY;
	}

	@Override
	public Class<AbstractGeometricAggregate> getAssociableClass() {
		return AbstractGeometricAggregate.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiGeometryProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiGeometryProperty copy = (target == null) ? new MultiGeometryProperty() : (MultiGeometryProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
