package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.MultiPointProperty;

public interface Address extends CoreModuleComponent, AbstractFeature {
	public XalAddressProperty getXalAddress();
	public MultiPointProperty getMultiPoint();
	public List<ADEComponent> getGenericApplicationPropertyOfAddress();
	public boolean isSetXalAddress();
	public boolean isSetMultiPoint();
	public boolean isSetGenericApplicationPropertyOfAddress();
	
	public void setXalAddress(XalAddressProperty xalAddress);
	public void setMultiPoint(MultiPointProperty multiPoint);	
	public void addGenericApplicationPropertyOfAddress(ADEComponent ade);
	public void setGenericApplicationPropertyOfAddress(List<ADEComponent> ade);
	public void unsetXalAddress();
	public void unsetMultiPoint();
	public void unsetGenericApplicationPropertyOfAddress();
	public boolean unsetGenericApplicationPropertyOfAddress(ADEComponent ade);
}
