package org.citygml4j.builder.json.objects.feature;

public class BuildingPartType extends AbstractBuildingType {
	private final CityObjectTypeName type = CityObjectTypeName.BUILDING_PART;
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}

}
