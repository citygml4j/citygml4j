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

public class CompositeSolidProperty extends GeometryProperty<CompositeSolid> {

	public CompositeSolidProperty() {

	}

	public CompositeSolidProperty(CompositeSolid compositeSolid) {
		super(compositeSolid);
	}

	public CompositeSolidProperty(String href) {
		super(href);
	}

	public CompositeSolid getCompositeSolid() {
		return super.getGeometry();
	}

	public boolean isSetCompositeSolid() {
		return super.isSetGeometry();
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		super.setGeometry(compositeSolid);
	}

	public void unsetCompositeSolid() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_SOLID_PROPERTY;
	}

	@Override
	public Class<CompositeSolid> getAssociableClass() {
		return CompositeSolid.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeSolidProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeSolidProperty copy = (target == null) ? new CompositeSolidProperty() : (CompositeSolidProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
