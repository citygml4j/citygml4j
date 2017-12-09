package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class SolitaryVegetationObjectType extends AbstractVegetationObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.SOLITARY_VEGETATION_OBJECT;
	@JsonAdapter(SolitaryVegetationObjectAttributesAdapter.class)
	private SolitaryVegetationObjectAttributes attributes;
	
	SolitaryVegetationObjectType() {
	}
	
	public SolitaryVegetationObjectType(String gmlId) {
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
	public SolitaryVegetationObjectAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(SolitaryVegetationObjectAttributes attributes) {
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
