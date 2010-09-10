package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;

public interface MassPointRelief extends AbstractReliefComponent {
	public MultiPointProperty getReliefPoints();
	public List<ADEComponent> getGenericApplicationPropertyOfMassPointRelief();
	public boolean isSetReliefPoints();
	public boolean isSetGenericApplicationPropertyOfMassPointRelief();
	
	public void setReliefPoints(MultiPointProperty reliefPoints);
	public void addGenericApplicationPropertyOfMassPointRelief(ADEComponent ade);
	public void setGenericApplicationPropertyOfMassPointRelief(List<ADEComponent> ade);
	public void unsetReliefPoints();
	public void unsetGenericApplicationPropertyOfMassPointRelief();
	public boolean unsetGenericApplicationPropertyOfMassPointRelief(ADEComponent ade);
}
