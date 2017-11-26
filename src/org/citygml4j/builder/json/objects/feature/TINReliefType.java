package org.citygml4j.builder.json.objects.feature;

import org.citygml4j.builder.json.objects.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public class TINReliefType extends AbstractCityObjectType {
	private final CityObjectTypeName type = CityObjectTypeName.TIN_RELIEF;
	@JsonAdapter(AttributesAdapter.class)
	private Attributes attributes;
	
	TINReliefType() {
	}
	
	public TINReliefType(String gmlId) {
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
		return type == GeometryTypeName.COMPOSITE_SURFACE;
	}

}
