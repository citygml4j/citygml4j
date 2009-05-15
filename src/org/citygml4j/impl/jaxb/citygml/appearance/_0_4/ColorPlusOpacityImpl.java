package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;

public class ColorPlusOpacityImpl implements ColorPlusOpacity {
	private Color color;
	private Double opacity = 1.0;

	public ColorPlusOpacityImpl() {
		color = new ColorImpl();
	}

	public ColorPlusOpacityImpl(Color color, Double opacity) {
		this.color = color;

		if (opacity >= 0.0 && opacity < 1.0)
			this.opacity = opacity;
	}

	public ColorPlusOpacityImpl(Double defaultColorValue, Double opacity) {
		this(new ColorImpl(defaultColorValue), opacity);
	}

	public ColorPlusOpacityImpl(Double defaulColorValue) {
		this(new ColorImpl(defaulColorValue), 1.0);
	}

	public ColorPlusOpacityImpl(Double red, Double green, Double blue, Double opacity) {
		this(new ColorImpl(red, green, blue), opacity);
	}

	public ColorPlusOpacityImpl(Double red, Double green, Double blue) {
		this(new ColorImpl(red, green, blue), 1.0);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.COLORPLUSOPACITY;
	}

	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	public Double getBlue() {
		return color.getBlue();
	}

	public List<Double> toList() {
		List<Double> colorPlusOpacity = new ArrayList<Double>();

		colorPlusOpacity.addAll(color.toList());

		if (opacity != null)
			colorPlusOpacity.add(opacity);

		return colorPlusOpacity;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColorPlusOpacity(List<Double> colorPlusOpacity) {
		if (colorPlusOpacity.size() >= 3) {
			color.setRed(colorPlusOpacity.get(0));
			color.setGreen(colorPlusOpacity.get(1));
			color.setBlue(colorPlusOpacity.get(2));

			if (colorPlusOpacity.size() >= 4)
				if (colorPlusOpacity.get(3) >= 0.0 && colorPlusOpacity.get(3) <= 1.0)
					opacity = colorPlusOpacity.get(3);
		}
	}

	public void setGreen(Double green) {
		color.setGreen(green);
	}

	public void setOpacity(Double opacity) {
		if (opacity >= 0.0 && opacity <= 1.0)
			this.opacity = opacity;
	}

	public void setRed(Double red) {
		color.setRed(red);
	}

	public boolean equals(ColorPlusOpacity colorPlusOpacity) {
		if (color.equals(colorPlusOpacity.getColor()) &&
				opacity.doubleValue() == colorPlusOpacity.getOpacity().doubleValue())
			return true;
		
		return false;
	}
	
}
