/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;

public class ExternalReference implements CoreModuleComponent, Child, Copyable {
	private String informationSystem;
	private ExternalObject externalObject;
	private ModelObject parent;
	
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
		this.externalObject = ModelObjects.setParent(externalObject, this);
	}

	public void setInformationSystem(String informationSystem) {
		this.informationSystem = informationSystem;
	}

	public void unsetExternalObject() {
		externalObject = ModelObjects.setNull(externalObject);
	}

	public void unsetInformationSystem() {
		informationSystem = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.EXTERNAL_REFERENCE;
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
