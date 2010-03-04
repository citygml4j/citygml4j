package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface Color extends AppearanceModuleComponent, Child, Copyable {
	public Double getRed();
	public Double getGreen();
	public Double getBlue();
	public List<Double> toList();

	public void setRed(Double red);
	public void setGreen(Double green);
	public void setBlue(Double blue);
	public void setColor(List<Double> color);
}
