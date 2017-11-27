package org.citygml4j.binding.json.feature;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BridgeType extends AbstractBridgeType {
	private final CityObjectTypeName type = CityObjectTypeName.BRIDGE;
	@SerializedName("Parts")
	private List<String> parts;
	
	BridgeType() {
	}
	
	public BridgeType(String gmlId) {
		super(gmlId);
	}
	
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
