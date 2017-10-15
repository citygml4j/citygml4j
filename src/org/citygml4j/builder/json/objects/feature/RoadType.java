package org.citygml4j.builder.json.objects.feature;

public class RoadType extends AbstractTransportationComplexType {
	private final CityObjectTypeName type = CityObjectTypeName.ROAD;
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}