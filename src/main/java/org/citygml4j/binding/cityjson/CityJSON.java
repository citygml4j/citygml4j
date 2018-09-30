/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.binding.cityjson;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import org.citygml4j.binding.cityjson.appearance.AppearanceType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.CityObjectsAdapter;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.GeometryTemplatesType;
import org.citygml4j.binding.cityjson.geometry.TransformType;
import org.citygml4j.binding.cityjson.geometry.VerticesList;
import org.citygml4j.binding.cityjson.metadata.LoDType;
import org.citygml4j.binding.cityjson.metadata.MetadataType;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityJSON {
	private final String type = "CityJSON";
	private final String version = "0.8";
	private MetadataType metadata;
	@SerializedName("CityObjects")
	@JsonAdapter(CityObjectsAdapter.class)
	private Map<String, AbstractCityObjectType> cityObjects = new HashMap<>();
	private VerticesList vertices = new VerticesList();
	private TransformType transform;
	private AppearanceType appearance;
	@SerializedName("geometry-templates")
	private GeometryTemplatesType geometryTemplates;

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
	
	public void unsetMetadata() {
		metadata = null;
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

	public boolean hasCityObject(String gmlId) {
		return cityObjects.containsKey(gmlId);
	}

	public <T extends AbstractCityObjectType> List<T> getCityObjects(Class<T> type) {
		return cityObjects.values().stream().filter(type::isInstance).map(type::cast).collect(Collectors.toList());
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
	
	public void removeCityObject(AbstractCityObjectType cityObject) {
		cityObjects.remove(cityObject.getGmlId());
	}
	
	public void removeCityObject(String gmlId) {
		cityObjects.remove(gmlId);
	}
	
	public void unsetCityObjects() {
		cityObjects.clear();
	}

	public void addVertex(List<Double> vertex) {
		if (vertex != null && vertex.size() == 3)
			vertices.addVertex(vertex);
	}

	public List<List<Double>> getVertices() {
		return vertices.getVertices();
	}

	public void setVertices(List<List<Double>> vertices) {
		if (vertices != null)
			this.vertices.setVertices(vertices);
	}
	
	public void unsetVertices() {
		vertices.clear();
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
	
	public void unsetTransform() {
		transform = null;
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
	
	public void unsetAppearance() {
		appearance = null;
	}

	public boolean isSetGeometryTemplates() {
		return geometryTemplates != null;
	}

	public GeometryTemplatesType getGeometryTemplates() {
		return geometryTemplates;
	}

	public void setGeometryTemplates(GeometryTemplatesType geometryTemplates) {
		this.geometryTemplates = geometryTemplates;
	}

	public void unsetGeometryTemplates() {
		geometryTemplates = null;
	}

	public List<Double> calcBoundingBox() {
		List<Double> bbox = Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,
				-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
		
		for (List<Double> vertex : vertices.getVertices()) {
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
	
	public Map<LoDType, Integer> calcPresentLoDs() {
		Map<LoDType, Integer> lods = new HashMap<>();
		for (AbstractCityObjectType cityObject : cityObjects.values()) {
			for (AbstractGeometryType geometry : cityObject.getGeometry()) {
				if (geometry instanceof AbstractGeometryObjectType) {
					LoDType lod = LoDType.fromLoD(((AbstractGeometryObjectType) geometry).getLod());
					if (lod != null)
						lods.merge(lod, 1, Integer::sum);
				}
			}
		}

		if (geometryTemplates != null) {
			for (AbstractGeometryObjectType geometry : geometryTemplates.getTemplates()) {
				LoDType lod = LoDType.fromLoD(geometry.getLod());
				if (lod != null)
					lods.merge(lod, 1, Integer::sum);
			}
		}
		
		return lods;
	}

	public void removeDuplicateVertices() {
		Map<String, Integer> indexes = new HashMap<>();
		Map<Integer, Integer> indexMap = new HashMap<>();
		int oldIndex = 0, newIndex = 0;

		for (Iterator<List<Double>> iter = getVertices().iterator(); iter.hasNext(); ) {
			List<Double> vertex = iter.next();
			String key = vertex.get(0).intValue() + " " + vertex.get(1).intValue() + " " + vertex.get(2).intValue();

			Integer index = indexes.get(key);
			if (index == null) {
				indexes.put(key, newIndex);
				indexMap.put(oldIndex, newIndex);
				newIndex++;
			} else {
				iter.remove();
				indexMap.put(oldIndex, index);
			}

			oldIndex++;
		}

		indexes = null;
		if (getVertices().size() != indexMap.size()) {
			for (AbstractCityObjectType cityObject : getCityObjects()) {
				for (AbstractGeometryType geometry : cityObject.getGeometry())
					geometry.updateIndexes(indexMap);
			}
		}

		indexMap = null;
	}

}
