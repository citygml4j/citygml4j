package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;

public interface ReliefFeature extends CityObject {
	public int getLod();
	public List<ReliefComponentProperty> getReliefComponent();
	public List<ADEComponent> getGenericApplicationPropertyOfReliefFeature();
	public boolean isSetLod();
	public boolean isSetReliefComponent();
	public boolean isSetGenericApplicationPropertyOfReliefFeature();

	public void setLod(int lod);
	public void addReliefComponent(ReliefComponentProperty reliefComponent);
	public void setReliefComponent(List<ReliefComponentProperty> reliefComponent);	
	public void addGenericApplicationPropertyOfReliefFeature(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfReliefFeature(List<ADEComponent> adeObject);
	public void unsetReliefComponent();
	public boolean unsetReliefComponent(ReliefComponentProperty reliefComponent);
	public void unsetGenericApplicationPropertyOfReliefFeature();
	public boolean unsetGenericApplicationPropertyOfReliefFeature(ADEComponent adeObject);
}
