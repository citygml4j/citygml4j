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
package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class CompositeCurveProperty extends GeometryProperty<CompositeCurve> {
	
	public CompositeCurveProperty() {
		
	}
	
	public CompositeCurveProperty(CompositeCurve compositeCurve) {
		super(compositeCurve);
	}
	
	public CompositeCurveProperty(String href) {
		super(href);
	}
	
	public CompositeCurve getCompositeCurve() {
		return super.getGeometry();
	}
	
	public boolean isSetCompositeCurve() {
		return super.isSetGeometry();
	}
	
	public void setCompositeCurve(CompositeCurve compositeCurve) {
		super.setGeometry(compositeCurve);
	}
	
	public void unsetCompositeCurve() {
		super.unsetGeometry();
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_CURVE_PROPERTY;
	}
	
	@Override
	public Class<CompositeCurve> getAssociableClass() {
		return CompositeCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeCurveProperty(), copyBuilder);
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeCurveProperty copy = (target == null) ? new CompositeCurveProperty() : (CompositeCurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
}
