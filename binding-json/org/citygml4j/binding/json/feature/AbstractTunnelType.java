package org.citygml4j.binding.json.feature;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.binding.json.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractTunnelType extends AbstractCityObjectType {
	@JsonAdapter(TunnelAttributesAdapter.class)
	private TunnelAttributes attributes;
	@SerializedName("Installations")
	private List<String> installations;
	
	AbstractTunnelType() {
	}
	
	public AbstractTunnelType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public boolean isSetAttributes() {
		return attributes != null;
	}

	@Override
	public TunnelAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(TunnelAttributes attributes) {
		this.attributes = attributes;
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

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.SOLID
				|| type == GeometryTypeName.COMPOSITE_SOLID;
	}
}
