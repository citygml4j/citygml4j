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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.GenericsModule;

public abstract class AbstractGenericAttribute implements GenericsModuleComponent, Child, Copyable {
	private String name;
	private GenericsModule module;
	private ModelObject parent;
	
	public AbstractGenericAttribute() {
		
	}
	
	public AbstractGenericAttribute(GenericsModule module) {
		this.module = module;
	}
	
	public String getName() {
		return name;
	}

	public boolean isSetName() {
		return name != null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void unsetName() {
		name = null;
	}

	public final GenericsModule getCityGMLModule() {
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

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractGenericAttribute copy = (AbstractGenericAttribute)target;
		
		if (isSetName())
			copy.setName(copyBuilder.copy(name));
		
		copy.unsetParent();
		
		return copy;
	}

}
