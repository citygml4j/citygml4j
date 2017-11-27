package org.citygml4j.binding.json.feature;

public class BridgePartType extends AbstractBridgeType {
	private final CityObjectTypeName type = CityObjectTypeName.BRIDGE_PART;
	
	BridgePartType() {
	}
	
	public BridgePartType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}
