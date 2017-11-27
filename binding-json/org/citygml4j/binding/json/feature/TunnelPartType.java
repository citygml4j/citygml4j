package org.citygml4j.binding.json.feature;

public class TunnelPartType extends AbstractTunnelType {
	private final CityObjectTypeName type = CityObjectTypeName.TUNNEL_PART;
	
	TunnelPartType() {
	}
	
	public TunnelPartType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}
