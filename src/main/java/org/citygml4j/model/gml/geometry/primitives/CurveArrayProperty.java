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

public class CurveArrayProperty extends GeometryArrayProperty<AbstractCurve> {

	public CurveArrayProperty() {

	}

	public CurveArrayProperty(AbstractCurve abstractCurve) {
		super(abstractCurve);
	}

	public CurveArrayProperty(List<AbstractCurve> abstractCurve) {
		super(abstractCurve);
	}
	
	public CurveArrayProperty(AbstractCurve... abstractCurve) {
		super(abstractCurve);
	}

	public void addCurve(AbstractCurve abstractCurve) {
		super.addGeometry(abstractCurve);
	}

	public List<? extends AbstractCurve> getCurve() {
		return super.getGeometry();
	}

	public boolean isSetCurve() {
		return super.isSetGeometry();
	}

	@SuppressWarnings("unchecked")
	public void setCurve(List<? extends AbstractCurve> abstractCurve) {
		super.setGeometry((List<AbstractCurve>)abstractCurve);
	}

	public void unsetCurve() {
		super.unsetGeometry();
	}

	public boolean unsetCurve(AbstractCurve abstractCurve) {
		return super.unsetGeometry(abstractCurve);
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_ARRAY_PROPERTY;
	}

	public Class<AbstractCurve> getAssociableClass() {
		return AbstractCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveArrayProperty copy = (target == null) ? new CurveArrayProperty() : (CurveArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
