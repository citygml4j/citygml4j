/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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

import java.util.List;

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
