package org.citygml4j.impl.citygml.texturedsurface;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public class _ColorImpl implements _Color {
	private Double red = 0.0;
	private Double green = 0.0;
	private Double blue = 0.0;
	private TexturedSurfaceModule module;
	private Object parent;
	
	public _ColorImpl() {
		
	}
	
	public _ColorImpl(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public _ColorImpl(Double defaultValue) {
		if (defaultValue > 0.0 && defaultValue <= 1.0)
			red = green = blue = defaultValue;
	}

	public _ColorImpl(Double red, Double green, Double blue) {
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
		return CityGMLClass._COLOR;
	}

	public final TexturedSurfaceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _ColorImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_Color copy = (target == null) ? new _ColorImpl() : (_Color)target;
		
		copy.setRed((Double)copyBuilder.copy(red));
		copy.setGreen((Double)copyBuilder.copy(green));
		copy.setBlue((Double)copyBuilder.copy(blue));
		
		copy.unsetParent();
		
		return copy;
	}

}
