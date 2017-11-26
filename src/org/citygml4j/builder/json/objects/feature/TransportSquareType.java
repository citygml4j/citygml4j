package org.citygml4j.builder.json.objects.feature;

public class TransportSquareType extends AbstractTransportationComplexType {
	private final CityObjectTypeName type = CityObjectTypeName.TRANSPOR_SQUARE;
	
	TransportSquareType() {
	}
	
	public TransportSquareType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}
