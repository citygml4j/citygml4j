package org.citygml4j.model.gml.valueObjects;

import java.util.List;

import org.citygml4j.model.gml.base.AbstractGML;

public interface CompositeValue extends AbstractGML {
	public List<ValueProperty> getValueComponent();
	public ValueArrayProperty getValueComponents();
	public boolean isSetValueComponent();
	public boolean isSetValueComponents();
	
	public void addValueComponent(ValueProperty valueComponent);
	public void setValueComponent(List<ValueProperty> valueComponent);
	public void setValueComponents(ValueArrayProperty valueComponents);
	public boolean unsetValueComponent(ValueProperty valueComponent);
	public void unsetValueComponent();
	public void unsetValueComponents();
}
