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

public class CurveProperty extends GeometryProperty<AbstractCurve> {
	
	public CurveProperty() {

	}

	public CurveProperty(AbstractCurve abstractCurve) {
		super(abstractCurve);
	}

	public CurveProperty(String href) {
		super(href);
	}
	
	public AbstractCurve getCurve() {
		return super.getGeometry();
	}

	public boolean isSetCurve() {
		return super.isSetGeometry();
	}

	public void setCurve(AbstractCurve curve) {
		super.setGeometry(curve);
	}

	public void unsetCurve() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_PROPERTY;
	}

	@Override
	public Class<AbstractCurve> getAssociableClass() {
		return AbstractCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveProperty copy = (target == null) ? new CurveProperty() : (CurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
