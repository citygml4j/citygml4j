package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

public class LandUseType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.LAND_USE;
	@JsonAdapter(DefaultAttributesAdapter.class)
	private DefaultAttributes attributes;
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public DefaultAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(DefaultAttributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.COMPOSITE_SURFACE;
	}

}
