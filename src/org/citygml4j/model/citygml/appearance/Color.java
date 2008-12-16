package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.core.CityGMLBase;

public interface Color extends CityGMLBase {
	public Double getRed();
	public Double getGreen();
	public Double getBlue();
	public List<Double> toList();
	public boolean equals(Color color);

	public void setRed(Double red);
	public void setGreen(Double green);
	public void setBlue(Double blue);
	public void setColor(List<Double> color);
}
