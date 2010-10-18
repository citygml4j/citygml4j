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
package org.citygml4j.impl.citygml.appearance;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class TextureCoordinatesImpl implements TextureCoordinates {
	private List<Double> value;
	private String ring;
	private AppearanceModule module;
	private ModelObject parent;
	
	public TextureCoordinatesImpl() {
		
	}
	
	public TextureCoordinatesImpl(AppearanceModule module) {
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
		return copyTo(new TextureCoordinatesImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TextureCoordinates copy = (target == null) ? new TextureCoordinatesImpl() : (TextureCoordinates)target;
		
		if (isSetValue())
			copy.setValue((List<Double>)copyBuilder.copy(value));
		
		if (isSetRing())
			copy.setRing(copyBuilder.copy(ring));
		
		copy.unsetParent();
		
		return copy;
	}

}
