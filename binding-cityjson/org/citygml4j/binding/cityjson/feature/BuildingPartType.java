package org.citygml4j.binding.cityjson.feature;

public class BuildingPartType extends AbstractBuildingType {
	private final CityObjectTypeName type = CityObjectTypeName.BUILDING_PART;
	
	BuildingPartType() {
	}
	
	public BuildingPartType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}
