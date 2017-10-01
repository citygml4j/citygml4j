package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Building extends AbstractCityObject {
	private final CityObjectType type = CityObjectType.BUILDING;
	@JsonAdapter(BuildingAttributesAdapter.class)
	private BuildingAttributes attributes;
	private Address address;
	@SerializedName("Parts")
	private List<String> parts; 
	@SerializedName("Installations")
	private List<String> installations;
	
	@Override
	public CityObjectType getType() {
		return type;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean isSetParts() {
		return parts != null;
	}
	
	public void addPart(String part) {
		if (parts == null)
			parts = new ArrayList<>();
		
		parts.add(part);
	}

	public List<String> getParts() {
		return parts;
	}

	public void setParts(List<String> parts) {
		this.parts = parts;
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
	public boolean isValidGeometryType(GeometryObjectType type) {
		return type == GeometryObjectType.MULTI_SURFACE
				|| type == GeometryObjectType.SOLID
				|| type == GeometryObjectType.COMPOSITE_SOLID;
	}
	
}
