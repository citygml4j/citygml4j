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
 * $Id: TextureCoordinates.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.citygml.appearance;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.AppearanceModule;

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

	public ModelType getModelType() {
		return ModelType.CITYGML;
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
