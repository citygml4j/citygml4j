package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.PolygonProperty;

public interface ReliefComponent extends ReliefModuleComponent, CityObject {
	public int getLod();
	public PolygonProperty getExtent();
	public List<ADEComponent> getGenericApplicationPropertyOfReliefComponent();
	public boolean isSetLod();
	public boolean isSetExtent();
	public boolean isSetGenericApplicationPropertyOfReliefComponent();

	public void setLod(int lod);
	public void setExtent(PolygonProperty extent);	
	public void addGenericApplicationPropertyOfReliefComponent(ADEComponent ade);
	public void setGenericApplicationPropertyOfReliefComponent(List<ADEComponent> ade);
	public void unsetExtent();
	public void unsetGenericApplicationPropertyOfReliefComponent();
	public boolean unsetGenericApplicationPropertyOfReliefComponent(ADEComponent ade);
}
