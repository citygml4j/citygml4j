package org.citygml4j.binding.cityjson.feature;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractBridgeType extends AbstractCityObjectType {
	@JsonAdapter(BridgeAttributesAdapter.class)
	private BridgeAttributes attributes;
	private AddressType address;
	@SerializedName("Installations")
	private List<String> installations;
	@SerializedName("ConstructionElements")
	private List<String> constructionElements;
	
	AbstractBridgeType() {
	}
	
	public AbstractBridgeType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public BridgeAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(BridgeAttributes attributes) {
		this.attributes = attributes;
	}
	
	@Override
	public void unsetAttributes() {
		attributes = null;
	}
	
	public boolean isSetAddress() {
		return address != null;
	}
	
	public AddressType getAddress() {
		return address;
	}

	public void setAddress(AddressType address) {
		this.address = address;
	}
	
	public boolean isSetInstallations() {
		return installations != null;
	}
	
	public void addInstallation(String installation) {
		if (installations == null)
			installations = new ArrayList<>();
		
		installations.add(installation);
	}

	public List<String> getInstallations() {
		return installations;
	}

	public void setInstallations(List<String> installations) {
		this.installations = installations;
	}
	
	public boolean isSetConstructionElements() {
		return constructionElements != null;
	}
	
	public void addConstructionElement(String constructionElement) {
		if (constructionElements == null)
			constructionElements = new ArrayList<>();
		
		constructionElements.add(constructionElement);
	}

	public List<String> getConstructionElements() {
		return constructionElements;
	}

	public void setConstructionElements(List<String> constructionElements) {
		this.constructionElements = constructionElements;
	}	

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.SOLID
				|| type == GeometryTypeName.COMPOSITE_SOLID;
	}
}
