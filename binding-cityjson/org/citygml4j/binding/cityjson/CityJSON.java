package org.citygml4j.binding.cityjson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.citygml4j.binding.cityjson.appearance.AppearanceType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.CityObjectsAdapter;
import org.citygml4j.binding.cityjson.feature.MetadataType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.TransformType;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class CityJSON {
	private final String type = "CityJSON";
	private final String version = "0.5";
	private MetadataType metadata;
	@SerializedName("CityObjects")
	@JsonAdapter(CityObjectsAdapter.class)
	private Map<String, AbstractCityObjectType> cityObjects = new HashMap<>();
	private List<List<Double>> vertices = new ArrayList<>();
	private TransformType transform;
	private AppearanceType appearance;

	public String getType() {
		return type;
	}

	public boolean isSetVersion() {
		return version != null;
	}

	public String getVersion() {
		return version;
	}

	public boolean isSetMetadata() {
		return metadata != null;
	}

	public MetadataType getMetadata() {
		return metadata;
	}

	public void setMetadata(MetadataType metadata) {
		this.metadata = metadata;
	}
	
	public boolean hasCityObjects() {
		return !cityObjects.isEmpty();
	}
	
	public void addCityObject(AbstractCityObjectType cityObject) {
		cityObjects.put(cityObject.getGmlId(), cityObject);
	}
	
	public AbstractCityObjectType getCityObject(String gmlId) {
		return cityObjects.get(gmlId);
	}
	
	public <T extends AbstractCityObjectType> T getCityObject(String gmlId, Class<T> type) {
		AbstractCityObjectType cityObject = cityObjects.get(gmlId);
		return type.isInstance(cityObject) ? type.cast(cityObject) : null;
	}

	public Collection<AbstractCityObjectType> getCityObjects() {
		return cityObjects.values();
	}

	public void setCityObjects(List<AbstractCityObjectType> cityObjects) {
		if (cityObjects != null) {
			for (AbstractCityObjectType cityObject : cityObjects)
				this.cityObjects.put(cityObject.getGmlId(), cityObject);
		}
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

	public TransformType getTransform() {
		return transform;
	}

	public void setTransform(TransformType transform) {
		this.transform = transform;
	}

	public boolean isSetAppearance() {
		return appearance != null;
	}

	public AppearanceType getAppearance() {
		return appearance;
	}

	public void setAppearance(AppearanceType appearance) {
		this.appearance = appearance;
	}

	public List<Double> calcBoundingBox() {
		List<Double> bbox = Arrays.asList(new Double[] {
				Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 
				-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE});
		
		for (List<Double> vertex : vertices) {
			if (vertex.size() > 2) {
				double x = vertex.get(0);
				double y = vertex.get(1);
				double z = vertex.get(2);
				
				if (x < bbox.get(0)) bbox.set(0, x);
				if (y < bbox.get(1)) bbox.set(1, y);
				if (z < bbox.get(2)) bbox.set(2, z);
				if (x > bbox.get(3)) bbox.set(3, x);
				if (y > bbox.get(4)) bbox.set(4, y);
				if (z > bbox.get(5)) bbox.set(5, z);
			}
		}

		return bbox;
	}
	
	public List<Number> calcPresentLoDs() {
		Set<Number> lods = new HashSet<>();		
		for (AbstractCityObjectType cityObject : cityObjects.values()) {
			for (AbstractGeometryType geometry : cityObject.getGeometry())
				lods.add(geometry.getLod());
		}
		
		return lods.stream().sorted().collect(Collectors.toList());
	}

}
