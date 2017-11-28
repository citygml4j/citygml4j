package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class BridgeConstructionElementType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.BRIDGE_CONSTRUCTION_ELEMENT;
	@JsonAdapter(AttributesAdapter.class)
	private Attributes attributes;
	
	BridgeConstructionElementType() {
	}
	
	public BridgeConstructionElementType(String gmlId) {
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
