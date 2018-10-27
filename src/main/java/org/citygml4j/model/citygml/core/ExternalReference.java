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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.CoreModule;

public class ExternalReference implements CoreModuleComponent, Child, Copyable {
	private String informationSystem;
	private ExternalObject externalObject;
	private CoreModule module;
	private ModelObject parent;

	public ExternalReference() {
		
	}
	
	public ExternalReference(CoreModule module) {
		this.module = module;
	}
	
	public ExternalObject getExternalObject() {
		return externalObject;
	}

	public String getInformationSystem() {
		return informationSystem;
	}

	public boolean isSetExternalObject() {
		return externalObject != null;
	}

	public boolean isSetInformationSystem() {
		return informationSystem != null;
	}

	public void setExternalObject(ExternalObject externalObject) {
		if (externalObject != null)
			externalObject.setParent(this);
		
		this.externalObject = externalObject;
	}

	public void setInformationSystem(String informationSystem) {
		this.informationSystem = informationSystem;
	}

	public void unsetExternalObject() {
		if (isSetExternalObject())
			externalObject.unsetParent();
		
		externalObject = null;
	}

	public void unsetInformationSystem() {
		informationSystem = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.EXTERNAL_REFERENCE;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ExternalReference(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ExternalReference copy = (target == null) ? new ExternalReference() : (ExternalReference)target;
		
		if (isSetInformationSystem())
			copy.setInformationSystem(copyBuilder.copy(informationSystem));
		
		if (isSetExternalObject()) {
			copy.setExternalObject((ExternalObject)copyBuilder.copy(externalObject));
			if (copy.getExternalObject() == externalObject)
				externalObject.setParent(this);
		}
		
		copy.unsetParent();

		return copy;
	}

}
