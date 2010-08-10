package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface AbstractSurfaceData extends AppearanceModuleComponent, AbstractFeature {
	public Boolean getIsFront();
	public List<ADEComponent> getGenericApplicationPropertyOfSurfaceData();
	public boolean isSetIsFront();
	public boolean isSetGenericApplicationPropertyOfSurfaceData();

	public void setIsFront(Boolean isFront);	
	public void addGenericApplicationPropertyOfSurfaceData(ADEComponent ade);
	public void setGenericApplicationPropertyOfSurfaceData(List<ADEComponent> ade);
	public void unsetIsFront();
	public void unsetGenericApplicationPropertyOfSurfaceData();	
	public boolean unsetGenericApplicationPropertyOfSurfaceData(ADEComponent ade);	
}
