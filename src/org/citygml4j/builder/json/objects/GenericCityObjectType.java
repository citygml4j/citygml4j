package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

public class GenericCityObjectType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.GENERIC_CITY_OBJECT;
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
		return true;
	}

}
