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

public class Color implements AppearanceModuleComponent, Child, Copyable {
	private Double red = 0.0;
	private Double green = 0.0;
	private Double blue = 0.0;
	private AppearanceModule module;
	private ModelObject parent;
	
	public Color() {
		
	}
	
	public Color(AppearanceModule module) {
		this.module = module;
	}
	
	public Color(Double defaultValue) {
		if (defaultValue > 0.0 && defaultValue <= 1.0)
			red = green = blue = defaultValue;
	}

	public Color(Double red, Double green, Double blue) {
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
		return copyTo(new Color(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Color copy = (target == null) ? new Color() : (Color)target;
		
		copy.setRed((Double)copyBuilder.copy(red));
		copy.setGreen((Double)copyBuilder.copy(green));
		copy.setBlue((Double)copyBuilder.copy(blue));
		
		copy.unsetParent();
		
		return copy;
	}

}
