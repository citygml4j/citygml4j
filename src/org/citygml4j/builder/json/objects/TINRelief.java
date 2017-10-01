package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.JsonAdapter;

public class TINRelief extends AbstractCityObject {
	private final CityObjectType type = CityObjectType.TIN_RELIEF;
	@JsonAdapter(TINReliefAttributesAdapter.class)
	private TINReliefAttributes attributes;
	
	@Override
	public CityObjectType getType() {
		return type;
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public TINReliefAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(TINReliefAttributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public boolean isValidGeometryType(GeometryObjectType type) {
		return type == GeometryObjectType.COMPOSITE_SURFACE;
	}

}
