package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Square extends TransportationComplex {
	public List<ADEComponent> getGenericApplicationPropertyOfSquare();
	public boolean isSetGenericApplicationPropertyOfSquare();
	
	public void addGenericApplicationPropertyOfSquare(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfSquare(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfSquare();
	public boolean unsetGenericApplicationPropertyOfSquare(ADEComponent adeObject);
}
