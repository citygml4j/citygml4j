package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class CityFurnitureType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.CITY_FURNITURE;
	@JsonAdapter(AttributesAdapter.class)
	private Attributes attributes;
	
	CityFurnitureType() {
	}
	
	public CityFurnitureType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}
	
	@Override
	public Attributes newAttributes() {
		attributes = new Attributes();
		return attributes;
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
	public void unsetAttributes() {
		attributes = null;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return true;
	}

}
