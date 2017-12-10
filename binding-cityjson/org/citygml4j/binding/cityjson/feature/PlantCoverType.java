package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class PlantCoverType extends AbstractVegetationObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.PLANT_COVER;
	@JsonAdapter(PlantCoverAttributesAdapter.class)
	private PlantCoverAttributes attributes;
	
	PlantCoverType() {
	}
	
	public PlantCoverType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}
	
	@Override
	public PlantCoverAttributes newAttributes() {
		attributes = new PlantCoverAttributes();
		return attributes;
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public PlantCoverAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(PlantCoverAttributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public void unsetAttributes() {
		attributes = null;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.MULTI_SOLID;
	}

}
