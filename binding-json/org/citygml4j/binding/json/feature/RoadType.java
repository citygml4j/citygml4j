package org.citygml4j.binding.json.feature;

public class RoadType extends AbstractTransportationComplexType {
	private final CityObjectTypeName type = CityObjectTypeName.ROAD;
	
	RoadType() {
	}
	
	public RoadType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}
