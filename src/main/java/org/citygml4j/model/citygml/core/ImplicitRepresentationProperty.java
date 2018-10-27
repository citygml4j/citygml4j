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
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.module.citygml.CoreModule;

public class ImplicitRepresentationProperty extends AssociationByRepOrRef<ImplicitGeometry> implements CoreModuleComponent {
	private CoreModule module;
	
	public ImplicitRepresentationProperty() {
		
	}
	
	public ImplicitRepresentationProperty(ImplicitGeometry implicitGeometry) {
		super(implicitGeometry);
	}
	
	public ImplicitRepresentationProperty(String href) {
		super(href);
	}
	
	public ImplicitRepresentationProperty(CoreModule module) {
		this.module = module;
	}
	
	public ImplicitGeometry getImplicitGeometry() {
		return super.getObject();
	}

	public boolean isSetImplicitGeometry() {
		return super.isSetObject();
	}

	public void setImplicitGeometry(ImplicitGeometry implicitGeometry) {
		super.setObject(implicitGeometry);
	}

	public void unsetImplicitGeometry() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.IMPLICIT_REPRESENTATION_PROPERTY;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public Class<ImplicitGeometry> getAssociableClass() {
		return ImplicitGeometry.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ImplicitRepresentationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ImplicitRepresentationProperty copy = (target == null) ? new ImplicitRepresentationProperty() : (ImplicitRepresentationProperty)target;
		return super.copyTo(copy, copyBuilder);		
	}

}
