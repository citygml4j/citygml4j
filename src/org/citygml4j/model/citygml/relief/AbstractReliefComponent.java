package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;

public interface AbstractReliefComponent extends ReliefModuleComponent, AbstractCityObject {
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
