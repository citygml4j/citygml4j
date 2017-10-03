package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class CityJSON {
	private final String type = "CityModel";
	private String version = "http://www.cityjson.org/version/0.2";
	private Metadata metadata;
	@SerializedName("CityObjects")
	private Map<String, AbstractCityObject> cityObjects = new HashMap<>();
	private List<List<Double>> vertices = new ArrayList<>();
	private Transform transform;
	private Appearance appearance;
	
	public String getType() {
		return type;
	}

	public boolean isSetVersion() {
		return version != null;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isSetMetadata() {
		return metadata != null;
	}
	
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	public void addCityObject(String id, AbstractCityObject cityObject) {
		cityObjects.put(id, cityObject);
	}

	public Map<String, AbstractCityObject> getCityObjects() {
		return cityObjects;
	}

	public void setCityObjects(Map<String, AbstractCityObject> cityObjects) {
		if (cityObjects != null)
			this.cityObjects = cityObjects;
	}
	
	public void addVertex(List<Double> vertex) {
		if (vertex != null && vertex.size() == 3)
			vertices.add(vertex);
	}

	public List<List<Double>> getVertices() {
		return vertices;
	}

	public void setVertices(List<List<Double>> vertices) {
		if (vertices != null)
			this.vertices = vertices;
	}

	public boolean isSetTransform() {
		return transform != null;
	}
	
	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public boolean isSetAppearance() {
		return appearance != null;
	}
	
	public Appearance getAppearance() {
		return appearance;
	}

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}
	
}
