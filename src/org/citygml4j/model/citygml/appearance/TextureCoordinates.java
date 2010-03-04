package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface TextureCoordinates extends AppearanceModuleComponent, Child, Copyable {
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
