package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Track extends TransportationComplex {
	public List<ADEComponent> getGenericApplicationPropertyOfTrack();
	public boolean isSetGenericApplicationPropertyOfTrack();
	
	public void addGenericApplicationPropertyOfTrack(ADEComponent ade);
	public void setGenericApplicationPropertyOfTrack(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfTrack();
	public boolean unsetGenericApplicationPropertyOfTrack(ADEComponent ade);
}
