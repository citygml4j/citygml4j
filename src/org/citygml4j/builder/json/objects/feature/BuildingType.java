package org.citygml4j.builder.json.objects.feature;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BuildingType extends AbstractBuildingType {
	private final CityObjectTypeName type = CityObjectTypeName.BUILDING;
	@SerializedName("Parts")
	private List<String> parts; 
	
	@Override
	public CityObjectTypeName getType() {
		return type;
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
		
}
