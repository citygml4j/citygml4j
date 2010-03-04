package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ColorPlusOpacity extends AppearanceModuleComponent, Child, Copyable {
	public Double getRed();
	public Double getGreen();
	public Double getBlue();
	public Color getColor();
	public Double getOpacity();
	public List<Double> toList();

	public void setRed(Double red);
	public void setGreen(Double green);
	public void setBlue(Double blue);
	public void setColor(Color color);
	public void setOpacity(Double opacity);
	public void setColorPlusOpacity(List<Double> colorPlusOpacity);
}
