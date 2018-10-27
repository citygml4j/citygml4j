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

public class GeometricPrimitiveProperty extends GeometryProperty<AbstractGeometricPrimitive> {

	public GeometricPrimitiveProperty() {

	}

	public GeometricPrimitiveProperty(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		super(abstractGeometricPrimitive);
	}

	public GeometricPrimitiveProperty(String href) {
		super(href);
	}
	
	public AbstractGeometricPrimitive getGeometricPrimitive() {
		return super.getGeometry();
	}

	public boolean isSetGeometricPrimitive() {
		return super.isSetGeometry();
	}

	public void setGeometricPrimitive(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		super.setGeometry(abstractGeometricPrimitive);
	}

	public void unsetGeometricPrimitive() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_PRIMITIVE_PROPERTY;
	}

	@Override
	public Class<AbstractGeometricPrimitive> getAssociableClass() {
		return AbstractGeometricPrimitive.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricPrimitiveProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricPrimitiveProperty copy = (target == null) ? new GeometricPrimitiveProperty() : (GeometricPrimitiveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
