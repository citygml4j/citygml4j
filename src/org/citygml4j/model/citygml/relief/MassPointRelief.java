package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.MultiPointProperty;

public interface MassPointRelief extends ReliefComponent {
	public MultiPointProperty getReliefPoints();
	public List<ADEComponent> getGenericApplicationPropertyOfMassPointRelief();
	public boolean isSetReliefPoints();
	public boolean isSetGenericApplicationPropertyOfMassPointRelief();
	
	public void setReliefPoints(MultiPointProperty reliefPoints);
	public void addGenericApplicationPropertyOfMassPointRelief(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfMassPointRelief(List<ADEComponent> adeObject);
	public void unsetReliefPoints();
	public void unsetGenericApplicationPropertyOfMassPointRelief();
	public boolean unsetGenericApplicationPropertyOfMassPointRelief(ADEComponent adeObject);
}
