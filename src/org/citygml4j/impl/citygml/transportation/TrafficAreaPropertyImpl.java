package org.citygml4j.impl.citygml.transportation;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.module.citygml.TransportationModule;

public class TrafficAreaPropertyImpl extends FeaturePropertyImpl<TrafficArea> implements TrafficAreaProperty {
	private TransportationModule module;
	
	public TrafficAreaPropertyImpl() {

	}

	public TrafficAreaPropertyImpl(TransportationModule module) {
		this.module = module;
	}
	
	public TrafficArea getTrafficArea() {
		return super.getObject();
	}

	public boolean isSetTrafficArea() {
		return super.isSetObject();
	}

	public void setTrafficArea(TrafficArea trafficArea) {
		super.setObject(trafficArea);
	}

	public void unsetTrafficArea() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRAFFIC_AREA_PROPERTY;
	}

	public final TransportationModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrafficAreaPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrafficAreaProperty copy = (target == null) ? new TrafficAreaPropertyImpl() : (TrafficAreaProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
