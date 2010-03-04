package org.citygml4j.model.citygml.transportation;

import org.citygml4j.model.gml.Association;

public interface TrafficAreaProperty extends TransportationModuleComponent, Association<TrafficArea> {
	public TrafficArea getTrafficArea();
	public boolean isSetTrafficArea();
	
	public void setTrafficArea(TrafficArea trafficArea);
	public void unsetTrafficArea();
}
