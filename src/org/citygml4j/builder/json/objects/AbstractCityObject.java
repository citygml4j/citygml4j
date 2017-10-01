package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(CityObjectAdapter.class)
public abstract class AbstractCityObject {
	private List<AbstractGeometryObject> geometry = new ArrayList<>();

	public abstract CityObjectType getType();
	public abstract boolean isValidGeometryType(GeometryObjectType type);
	public abstract boolean isSetAttributes();
	public abstract AbstractAttributes getAttributes();
	
	public void addGeometry(AbstractGeometryObject geometry) {
		if (isValidGeometryType(geometry.getType()))
			this.geometry.add(geometry);
	}

	public List<AbstractGeometryObject> getGeometry() {
		return geometry;
	}

	public void setGeometry(List<AbstractGeometryObject> geometry) {
		if (geometry != null) {
			this.geometry = new ArrayList<>(geometry);
			this.geometry.removeIf(g -> !isValidGeometryType(g.getType()));
		}
	}

}
