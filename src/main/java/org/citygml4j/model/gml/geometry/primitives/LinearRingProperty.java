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
import org.citygml4j.model.gml.geometry.InlineGeometryProperty;

public class LinearRingProperty extends InlineGeometryProperty<LinearRing> {
	
	public LinearRingProperty() {

	}

	public LinearRingProperty(LinearRing linearRing) {
		super(linearRing);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINEAR_RING_PROPERTY;
	}

	public LinearRing getLinearRing() {
		return super.getGeometry();
	}

	public boolean isSetLinearRing() {
		return super.isSetGeometry();
	}

	public void setLinearRing(LinearRing linearRing) {
		super.setGeometry(linearRing);
	}

	public void unsetLinearRing() {
		super.unsetGeometry();
	}

	public Class<LinearRing> getAssociableClass() {
		return LinearRing.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LinearRingProperty copy = (target == null) ? new LinearRingProperty() : (LinearRingProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LinearRingProperty(), copyBuilder);
	}
	
}
