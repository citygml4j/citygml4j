package org.citygml4j.impl.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class ColorPlusOpacityImpl implements ColorPlusOpacity {
	private Color color;
	private Double opacity = 1.0;
	private AppearanceModule module;
	private ModelObject parent;

	public ColorPlusOpacityImpl() {
		color = new ColorImpl();
	}

	public ColorPlusOpacityImpl(AppearanceModule module) {
		this();
		this.module = module;
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
		return copyTo(new ColorPlusOpacityImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ColorPlusOpacity copy = (target == null) ? new ColorPlusOpacityImpl() : (ColorPlusOpacity)target;
		
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
