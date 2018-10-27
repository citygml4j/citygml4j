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
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class GeometricComplexProperty extends GeometryProperty<AbstractGeometry> {

	public GeometricComplexProperty() {

	}

	public GeometricComplexProperty(AbstractGeometry abstractGeometry) {
		setObject(abstractGeometry);
	}

	public GeometricComplexProperty(String href) {
		super(href);
	}
	
	@Override
	public void setObject(AbstractGeometry geometry) {
		if (geometry instanceof CompositeCurve ||
				geometry instanceof CompositeSolid ||
				geometry instanceof CompositeSurface ||
				geometry instanceof GeometricComplex)		
			super.setObject(geometry);
	}

	public CompositeCurve getCompositeCurve() {
		return (super.getGeometry() instanceof CompositeCurve) ? (CompositeCurve)super.getGeometry() : null;
	}

	public CompositeSolid getCompositeSolid() {
		return (super.getGeometry() instanceof CompositeSolid) ? (CompositeSolid)super.getGeometry() : null;
	}

	public CompositeSurface getCompositeSurface() {
		return (super.getGeometry() instanceof CompositeSurface) ? (CompositeSurface)super.getGeometry() : null;
	}

	public GeometricComplex getGeometricComplex() {
		return (super.getGeometry() instanceof GeometricComplex) ? (GeometricComplex)super.getGeometry() : null;
	}

	public boolean isSetCompositeCurve() {
		return (super.getGeometry() instanceof CompositeCurve);
	}

	public boolean isSetCompositeSolid() {
		return (super.getGeometry() instanceof CompositeSolid);
	}

	public boolean isSetCompositeSurface() {
		return (super.getGeometry() instanceof CompositeSurface);
	}

	public boolean isSetGeometricComplex() {
		return (super.getGeometry() instanceof GeometricComplex);
	}

	public void setCompositeCurve(CompositeCurve compositeCurve) {
		super.setObject(compositeCurve);
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		super.setObject(compositeSolid);
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		super.setObject(compositeSurface);
	}

	public void setGeometricComplex(GeometricComplex geometricComplex) {
		super.setGeometry(geometricComplex);
	}

	public void unsetCompositeCurve() {
		super.unsetGeometry();
	}

	public void unsetCompositeSolid() {
		super.unsetGeometry();
	}

	public void unsetCompositeSurface() {
		super.unsetGeometry();
	}

	public void unsetGeometricComplex() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_COMPLEX_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricComplexProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricComplexProperty copy = (target == null) ? new GeometricComplexProperty() : (GeometricComplexProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
