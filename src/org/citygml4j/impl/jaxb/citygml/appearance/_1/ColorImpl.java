package org.citygml4j.impl.jaxb.citygml.appearance._1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.Color;

public class ColorImpl implements Color {
	private Double red = 0.0;
	private Double green = 0.0;
	private Double blue = 0.0;

	public ColorImpl() {

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

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.COLOR;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v1_0_0;
	}

	@Override
	public Double getBlue() {
		return blue;
	}

	@Override
	public List<Double> toList() {
		List<Double> color = new ArrayList<Double>();

		color.add(red);
		color.add(green);
		color.add(blue);

		return color;
	}

	@Override
	public Double getGreen() {
		return green;
	}

	@Override
	public Double getRed() {
		return red;
	}

	@Override
	public void setBlue(Double blue) {
		if (blue >= 0.0 && blue <= 1.0)
			this.blue = blue;
	}

	@Override
	public void setColor(List<Double> color) {
		if (color.size() >= 3) {
			if (color.get(0) >= 0.0 && color.get(0) <= 1.0)
				red = color.get(0);

			if (color.get(1) >= 0.0 && color.get(1) <= 1.0)
				green = color.get(1);

			if (color.get(2) >= 0.0 && color.get(2) <= 1.0)
				blue = color.get(2);
		}
	}

	@Override
	public void setGreen(Double green) {
		if (green >= 0.0 && green <= 1.0)
			this.green = green;
	}

	@Override
	public void setRed(Double red) {
		if (red >= 0.0 && red <= 1.0)
			this.red = red;
	}
	
	@Override
	public boolean equals(Color color) {
		if (red.doubleValue() == color.getRed().doubleValue() &&
				green.doubleValue() == color.getGreen().doubleValue() &&
				blue.doubleValue() == color.getBlue().doubleValue())
			return true;
		
		return false;
	}

}
