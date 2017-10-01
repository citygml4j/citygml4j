package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

public class SolitaryVegetationObject extends AbstractCityObject {
	private final CityObjectType type = CityObjectType.SOLITARY_VEGETATION_OBJECT;
	@JsonAdapter(SolitaryVegetationObjectAttributesAdapter.class)
	private SolitaryVegetationObjectAttributes attributes;
	
	@Override
	public CityObjectType getType() {
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
	public boolean isValidGeometryType(GeometryObjectType type) {
		return true;
	}

}
