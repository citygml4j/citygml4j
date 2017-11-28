package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class GenericCityObjectType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.GENERIC_CITY_OBJECT;
	@JsonAdapter(AttributesAdapter.class)
	private Attributes attributes;
	
	GenericCityObjectType() {
	}
	
	public GenericCityObjectType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return true;
	}

}
