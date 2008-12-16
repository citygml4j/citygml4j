package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.core.CityGMLBase;

public interface TextureCoordinates extends CityGMLBase {
	public List<Double> getValue();
	public String getRing();
	public boolean isSetValue();
	public boolean isSetRing();
	
	public void setValue(List<Double> value);
	public void addValue(Double value);
	public void setRing(String ring);
	public void unsetValue();
	public void unsetRing();
}
