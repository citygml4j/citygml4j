package org.citygml4j.binding.json.feature;

import org.citygml4j.binding.json.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class BuildingInstallationType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.BUILDING_INSTALLATION;
	@JsonAdapter(AttributesAdapter.class)
	private Attributes attributes;
	
	BuildingInstallationType() {
	}
	
	public BuildingInstallationType(String gmlId) {
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
