package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

public class PlantCover extends AbstractCityObject {
	private final CityObjectType type = CityObjectType.PLANT_COVER;
	@JsonAdapter(PlantCoverAttributesAdapter.class)
	private PlantCoverAttributes attributes;
	
	@Override
	public CityObjectType getType() {
		return type;
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public PlantCoverAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(PlantCoverAttributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public boolean isValidGeometryType(GeometryObjectType type) {
		return type == GeometryObjectType.MULTI_SURFACE
				|| type == GeometryObjectType.MULTI_SOLID;
	}

}
