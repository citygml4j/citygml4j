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
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class ColorImpl implements Color {
	private Double red = 0.0;
	private Double green = 0.0;
	private Double blue = 0.0;
	private AppearanceModule module;
	private ModelObject parent;
	
	public ColorImpl() {
		
	}
	
	public ColorImpl(AppearanceModule module) {
		this.module = module;
	}
	
	public ColorImpl(Double defaultValue) {
		if (defaultValue > 0.0 && defaultValue <= 1.0)
			red = green = blue = defaultValue;
	}

	public ColorImpl(Double red, Double green, Double blue) {
		if (red > 0.0 && red <= 1.0)
			this.red = red;

		if (green > 0.0 && green <= 1.0)
			this.green = green;

		if (blue > 0.0 && blue <= 1.0)
			this.blue = blue;
	}
	
	public Double getBlue() {
		return blue;
	}

	public Double getGreen() {
		return green;
	}

	public Double getRed() {
		return red;
	}

	public void setBlue(Double blue) {
		if (blue >= 0.0 && blue <= 1.0)
			this.blue = blue;
	}

	public void setColor(List<Double> color) {
		if (color.size() >= 3) {
			for (int i = 0; i < 3 ; ++i) {
				double value = color.get(i);
				
				if (value >= 0.0 && value <= 1.0) {
					switch (i) {
					case 0:
						red = value;
						break;
					case 1:
						green = value;
						break;
					case 2:
						blue = value;
						break;
					}
				}
			}
		}
	}

	public void setGreen(Double green) {
		if (green >= 0.0 && green <= 1.0)
			this.green = green;
	}

	public void setRed(Double red) {
		if (red >= 0.0 && red <= 1.0)
			this.red = red;
	}

	public List<Double> toList() {
		List<Double> color = new ArrayList<Double>();

		color.add(red);
		color.add(green);
		color.add(blue);

		return color;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.COLOR;
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
		return copyTo(new ColorImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Color copy = (target == null) ? new ColorImpl() : (Color)target;
		
		copy.setRed((Double)copyBuilder.copy(red));
		copy.setGreen((Double)copyBuilder.copy(green));
		copy.setBlue((Double)copyBuilder.copy(blue));
		
		copy.unsetParent();
		
		return copy;
	}

}
