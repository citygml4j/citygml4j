package org.citygml4j.binding.json.feature;

import org.citygml4j.binding.json.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

public abstract class AbstractTransportationComplexType extends AbstractCityObjectType {
	@JsonAdapter(TransportationComplexAttributesAdapter.class)
	private TransportationComplexAttributes attributes;
	
	AbstractTransportationComplexType() {
	}

	public AbstractTransportationComplexType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public TransportationComplexAttributes getAttributes() {
		return attributes;
	}
	
	public void setAttributes(TransportationComplexAttributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.COMPOSITE_SURFACE;
	}
}
