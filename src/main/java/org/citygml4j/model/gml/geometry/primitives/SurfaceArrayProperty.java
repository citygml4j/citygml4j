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

public class SurfaceArrayProperty extends GeometryArrayProperty<AbstractSurface> {
	
	public SurfaceArrayProperty() {

	}

	public SurfaceArrayProperty(AbstractSurface abstractSurface) {
		super(abstractSurface);
	}

	public SurfaceArrayProperty(List<AbstractSurface> abstractSurface) {
		super(abstractSurface);
	}
	
	public SurfaceArrayProperty(AbstractSurface... abstractSurface) {
		super(abstractSurface);
	}
	
	public void addSurface(AbstractSurface abstractSurface) {
		super.addGeometry(abstractSurface);
	}

	public List<? extends AbstractSurface> getSurface() {
		return super.getGeometry();
	}

	public boolean isSetSurface() {
		return super.isSetGeometry();
	}

	@SuppressWarnings("unchecked")
	public void setSurface(List<? extends AbstractSurface> abstractSurface) {
		super.setGeometry((List<AbstractSurface>)abstractSurface);
	}

	public void unsetSurface() {
		super.unsetGeometry();
	}

	public boolean unsetSurface(AbstractSurface abstractSurface) {
		return super.unsetGeometry(abstractSurface);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_ARRAY_PROPERTY;
	}

	public Class<AbstractSurface> getAssociableClass() {
		return AbstractSurface.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceArrayProperty copy = (target == null) ? new SurfaceArrayProperty() : (SurfaceArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
