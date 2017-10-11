package org.citygml4j.builder.json.objects.feature;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.json.objects.geometry.AbstractGeometryType;
import org.citygml4j.builder.json.objects.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(CityObjectTypeAdapter.class)
public abstract class AbstractCityObjectType {
	private transient String gmlId;
	private List<AbstractGeometryType> geometry = new ArrayList<>();

	public abstract CityObjectTypeName getType();
	public abstract boolean isValidGeometryType(GeometryTypeName type);
	public abstract boolean isSetAttributes();
	public abstract AbstractAttributes getAttributes();
	
	public String getGmlId() {
		return gmlId;
	}
	
	public void setGmlId(String gmlId) {
		this.gmlId = gmlId;
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
