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

public class MultiSurfaceProperty extends GeometryProperty<MultiSurface> {
	
	public MultiSurfaceProperty() {

	}

	public MultiSurfaceProperty(MultiSurface multiSurface) {
		super(multiSurface);
	}

	public MultiSurfaceProperty(String href) {
		super(href);
	}
	
	public MultiSurface getMultiSurface() {
		return super.getGeometry();
	}

	public boolean isSetMultiSurface() {
		return super.isSetGeometry();
	}

	public void setMultiSurface(MultiSurface multiSurface) {
		super.setGeometry(multiSurface);
	}

	public void unsetMultiSurface() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_SURFACE_PROPERTY;
	}

	@Override
	public Class<MultiSurface> getAssociableClass() {
		return MultiSurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiSurfaceProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiSurfaceProperty copy = (target == null) ? new MultiSurfaceProperty() : (MultiSurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
