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
 * $Id: ColorPlusOpacity.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class ColorPlusOpacity implements AppearanceModuleComponent, Child, Copyable {
	private Color color;
	private Double opacity = 1.0;
	private AppearanceModule module;
	private ModelObject parent;

	public ColorPlusOpacity() {
		color = new Color();
	}

	public ColorPlusOpacity(AppearanceModule module) {
		this();
		this.module = module;
	}
	
	public ColorPlusOpacity(Color color, Double opacity) {
		this.color = color;

		if (opacity >= 0.0 && opacity < 1.0)
			this.opacity = opacity;
	}

	public ColorPlusOpacity(Double defaultColorValue, Double opacity) {
		this(new Color(defaultColorValue), opacity);
	}

	public ColorPlusOpacity(Double defaulColorValue) {
		this(new Color(defaulColorValue), 1.0);
	}

	public ColorPlusOpacity(Double red, Double green, Double blue, Double opacity) {
		this(new Color(red, green, blue), opacity);
	}

	public ColorPlusOpacity(Double red, Double green, Double blue) {
		this(new Color(red, green, blue), 1.0);
	}
	
	public Double getBlue() {
		return color.getBlue();
	}

	public Color getColor() {
		return color;
	}

	public Double getGreen() {
		return color.getGreen();
	}

	public Double getOpacity() {
		return opacity;
	}

	public Double getRed() {
		return color.getRed();
	}

	public void setBlue(Double blue) {
		color.setBlue(blue);
	}

	public void setColor(Color color) {
		if (color != null)
			color.setParent(this);

		this.color = color;
	}

	public void setColorPlusOpacity(List<Double> colorPlusOpacity) {
		if (colorPlusOpacity.size() >= 3)
			color.setColor(colorPlusOpacity.subList(0, 3));

		if (colorPlusOpacity.size() >= 4) {
			Double opacity = colorPlusOpacity.get(3);
			if (opacity >= 0.0 && opacity <= 1.0)
				this.opacity = opacity;
		}
	}

	public void setGreen(Double green) {
		color.setGreen(green);
	}

	public void setOpacity(Double opacity) {
		this.opacity = opacity;
	}

	public void setRed(Double red) {
		color.setRed(red);
	}

	public List<Double> toList() {
		List<Double> colorPlusOpacity = color.toList();
		if (opacity != null)
			colorPlusOpacity.add(opacity);

		return colorPlusOpacity;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.COLOR_PLUS_OPACITY;
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
		return copyTo(new ColorPlusOpacity(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ColorPlusOpacity copy = (target == null) ? new ColorPlusOpacity() : (ColorPlusOpacity)target;
		
		if (color != null) {
			copy.setColor((Color)copyBuilder.copy(color));
			if (copy.getColor() == color)
				color.setParent(this);
		}
		
		copy.setOpacity((Double)copyBuilder.copy(opacity));
		
		copy.unsetParent();
		
		return copy;
	}

}
