package org.citygml4j.builder.json.objects.feature;

import org.citygml4j.builder.json.objects.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class TINReliefType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.TIN_RELIEF;
	@JsonAdapter(TINReliefAttributesAdapter.class)
	private TINReliefAttributes attributes;
	
	@Override
	public CityObjectTypeName getType() {
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
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.COMPOSITE_SURFACE;
	}

}
