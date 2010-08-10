package org.citygml4j.model.citygml.transportation;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface TrafficAreaProperty extends TransportationModuleComponent, FeatureProperty<TrafficArea> {
	public TrafficArea getTrafficArea();
	public boolean isSetTrafficArea();
	
	public void setTrafficArea(TrafficArea trafficArea);
	public void unsetTrafficArea();
}
