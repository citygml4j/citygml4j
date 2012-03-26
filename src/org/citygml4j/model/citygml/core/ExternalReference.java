/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
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

	public ModelType getModelType() {
		return ModelType.CITYGML;
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
