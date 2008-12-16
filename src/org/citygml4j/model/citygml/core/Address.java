package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.MultiPointProperty;

public interface Address extends CityGMLBase, AbstractFeature {
	public XalAddressProperty getXalAddress();
	public MultiPointProperty getMultiPoint();
	public List<ADEComponent> getGenericApplicationPropertyOfAddress();
	public boolean isSetXalAddress();
	public boolean isSetMultiPoint();
	public boolean isSetGenericApplicationPropertyOfAddress();
	
	public void setXalAddress(XalAddressProperty xalAddressProperty);
	public void setMultiPoint(MultiPointProperty multiPoint);	
	public void addGenericApplicationPropertyOfAddress(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfAddress(List<ADEComponent> adeObject);
	public void unsetXalAddress();
	public void unsetMultiPoint();
	public void unsetGenericApplicationPropertyOfAddress();
	public boolean unsetGenericApplicationPropertyOfAddress(ADEComponent adeObject);
}
