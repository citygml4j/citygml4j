/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id$
 */
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.CoreModule;

public class ExternalObject implements CoreModuleComponent, Child, Copyable {
	private String name;
	private String uri;
	private CoreModule module;
	private ModelObject parent;
	
	public ExternalObject() {
		
	}
	
	public ExternalObject(CoreModule module) {
		this.module = module;
	}
	
	public String getName() {
		return name;
	}

	public String getUri() {
		return uri;
	}

	public boolean isSetName() {
		return name != null;
	}

	public boolean isSetUri() {
		return uri != null;
	}

	public void setName(String name) {
		this.name = name;
		unsetUri();
	}

	public void setUri(String uri) {
		this.uri = uri;
		unsetName();
	}

	public void unsetName() {
		name = null;
	}

	public void unsetUri() {
		uri = null;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.EXTERNAL_OBJECT;
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
		return copyTo(new ExternalObject(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ExternalObject copy = (target == null) ? new ExternalObject() : (ExternalObject)target;
		
		if (isSetName())
			copy.setName(copyBuilder.copy(name));
		
		if (isSetUri())
			copy.setUri(copyBuilder.copy(uri));
		
		copy.unsetParent();

		return copy;
	}

}
