package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

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
	public TransportationComplexAttributes newAttributes() {
		attributes = new TransportationComplexAttributes();
		return attributes;
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
	public void unsetAttributes() {
		attributes = null;
	}
	
	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.COMPOSITE_SURFACE;
	}
}
