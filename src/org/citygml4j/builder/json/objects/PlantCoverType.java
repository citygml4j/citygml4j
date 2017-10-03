package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

public class PlantCoverType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.PLANT_COVER;
	@JsonAdapter(PlantCoverAttributesAdapter.class)
	private PlantCoverAttributes attributes;
	
	@Override
	public CityObjectTypeName getType() {
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
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.MULTI_SOLID;
	}

}
