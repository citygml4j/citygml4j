package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.AbstractFeature;

public interface AbstractSurfaceData extends CityGMLBase, AbstractFeature {
	public Boolean getIsFront();
	public List<ADEComponent> getGenericApplicationPropertyOfSurfaceData();
	public boolean isSetIsFront();
	public boolean isSetGenericApplicationPropertyOfSurfaceData();

	public void setIsFront(Boolean isFront);	
	public void addGenericApplicationPropertyOfSurfaceData(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfSurfaceData(List<ADEComponent> adeObject);
	public void unsetIsFront();
	public void unsetGenericApplicationPropertyOfSurfaceData();	
	public boolean unsetGenericApplicationPropertyOfSurfaceData(ADEComponent adeObject);	
}
