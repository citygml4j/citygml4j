package org.citygml4j.binding.cityjson.feature;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractBuildingType extends AbstractCityObjectType {
	@JsonAdapter(BuildingAttributesAdapter.class)
	private BuildingAttributes attributes;
	private AddressType address;
	@SerializedName("Installations")
	private List<String> installations;
	
	AbstractBuildingType() {
	}
	
	public AbstractBuildingType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public BuildingAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(BuildingAttributes attributes) {
		this.attributes = attributes;
	}
	
	public boolean isSetAddress() {
		return address != null;
	}
	
	public AddressType getAddress() {
		return address;
	}

	public void setAddress(AddressType address) {
		this.address = address;
	}
	
	public boolean isSetInstallations() {
		return installations != null;
	}
	
	public void addInstallation(String installation) {
		if (installations == null)
			installations = new ArrayList<>();
		
		installations.add(installation);
	}

	public List<String> getInstallations() {
		return installations;
	}

	public void setInstallations(List<String> installations) {
		this.installations = installations;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.SOLID
				|| type == GeometryTypeName.COMPOSITE_SOLID;
	}
}
