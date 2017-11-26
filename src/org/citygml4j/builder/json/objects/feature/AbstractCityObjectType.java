package org.citygml4j.builder.json.objects.feature;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.json.objects.geometry.AbstractGeometryType;
import org.citygml4j.builder.json.objects.geometry.GeometryTypeName;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;

public abstract class AbstractCityObjectType {
	protected transient String gmlId;
	private List<AbstractGeometryType> geometry = new ArrayList<>();

	public abstract CityObjectTypeName getType();
	public abstract boolean isValidGeometryType(GeometryTypeName type);
	public abstract boolean isSetAttributes();
	public abstract Attributes getAttributes();
	
	AbstractCityObjectType() {
	}
	
	public AbstractCityObjectType(String gmlId) {
		this.gmlId = gmlId != null && !gmlId.isEmpty() ? gmlId : DefaultGMLIdManager.getInstance().generateUUID();
	}
	
	public String getGmlId() {
		return gmlId;
	}
		
	public void addGeometry(AbstractGeometryType geometry) {
		if (isValidGeometryType(geometry.getType()))
			this.geometry.add(geometry);
	}

	public List<AbstractGeometryType> getGeometry() {
		return geometry;
	}

	public void setGeometry(List<AbstractGeometryType> geometry) {
		if (geometry != null) {
			this.geometry = new ArrayList<>(geometry);
			this.geometry.removeIf(g -> !isValidGeometryType(g.getType()));
		}
	}

}
