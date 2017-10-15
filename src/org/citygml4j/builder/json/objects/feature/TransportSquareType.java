package org.citygml4j.builder.json.objects.feature;

public class TransportSquareType extends AbstractTransportationComplexType {
	private final CityObjectTypeName type = CityObjectTypeName.TRANSPOR_SQUARE;
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}
