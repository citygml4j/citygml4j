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
package org.citygml4j.model.gml.geometry;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

import java.util.List;

public class GeometryArrayProperty<T extends AbstractGeometry> extends ArrayAssociation<T> {

	public GeometryArrayProperty() {
		
	}
	
	public GeometryArrayProperty(T abstractGeometry) {
		super(abstractGeometry);
	}
	
	public GeometryArrayProperty(List<T> abstractGeometry) {
		super(abstractGeometry);
	}
	
	public GeometryArrayProperty(T[] abstractGeometry) {
		super(abstractGeometry);
	}
	
	public List<T> getGeometry() {
		return super.getObject();
	}

	public boolean isSetGeometry() {
		return super.isSetObject();
	}

	public void addGeometry(T geometry) {
		super.addObject(geometry);
	}

	public void setGeometry(List<T> geometry) {
		super.setObject(geometry);
	}

	public boolean unsetGeometry(T geometry) {
		return super.unsetObject(geometry);
	}

	public void unsetGeometry() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRY_ARRAY_PROPERTY;
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getAssociableClass() {
		return (Class<T>)AbstractGeometry.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometryArrayProperty<T>(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometryArrayProperty<T> copy = (target == null) ? new GeometryArrayProperty<T>() : (GeometryArrayProperty<T>)target;
		return super.copyTo(copy, copyBuilder);
	}

}
