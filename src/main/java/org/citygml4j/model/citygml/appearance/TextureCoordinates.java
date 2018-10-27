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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.AppearanceModule;

import java.util.ArrayList;
import java.util.List;

public class TextureCoordinates implements AppearanceModuleComponent, Child, Copyable {
	private List<Double> value;
	private String ring;
	private AppearanceModule module;
	private ModelObject parent;
	
	public TextureCoordinates() {
		
	}
	
	public TextureCoordinates(AppearanceModule module) {
		this.module = module;
	}
	
	public void addValue(Double value) {
		if (this.value == null)
			this.value = new ArrayList<Double>();
		
		this.value.add(value);
	}

	public String getRing() {
		return ring;
	}

	public List<Double> getValue() {
		if (value == null)
			value = new ArrayList<Double>();
		
		return value;
	}

	public boolean isSetRing() {
		return ring != null;
	}

	public boolean isSetValue() {
		return value != null && !value.isEmpty();
	}

	public void setRing(String ring) {
		this.ring = ring;
	}

	public void setValue(List<Double> value) {
		this.value = value;
	}

	public void unsetRing() {
		ring = null;
	}

	public void unsetValue() {
		value = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURE_COORDINATES;
	}

	public final AppearanceModule getCityGMLModule() {
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
		return copyTo(new TextureCoordinates(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TextureCoordinates copy = (target == null) ? new TextureCoordinates() : (TextureCoordinates)target;
		
		if (isSetValue())
			copy.setValue((List<Double>)copyBuilder.copy(value));
		
		if (isSetRing())
			copy.setRing(copyBuilder.copy(ring));
		
		copy.unsetParent();
		
		return copy;
	}

}
