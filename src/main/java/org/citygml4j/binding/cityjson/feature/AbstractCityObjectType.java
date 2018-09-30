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
package org.citygml4j.binding.cityjson.feature;

import com.google.gson.annotations.JsonAdapter;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@JsonAdapter(CityObjectTypeAdapter.class)
public abstract class AbstractCityObjectType {
	protected transient String gmlId;
	private List<Double> geographicalExtent;
	private List<AbstractGeometryType> geometry = new ArrayList<>();

	private transient HashMap<String, Object> localProperties;

	public abstract CityObjectTypeName getType();
	public abstract boolean isValidGeometryType(GeometryTypeName type);
	public abstract Attributes newAttributes();
	public abstract boolean isSetAttributes();
	public abstract Attributes getAttributes();
	public abstract void unsetAttributes();
	
	AbstractCityObjectType() {
	}
	
	public AbstractCityObjectType(String gmlId) {
		this.gmlId = gmlId != null && !gmlId.isEmpty() ? gmlId : "UUID_" + UUID.randomUUID().toString();
	}
	
	public String getGmlId() {
		return gmlId;
	}

	public boolean isSetGeographicalExtent() {
		return geographicalExtent != null && geographicalExtent.size() >= 6;
	}

	public List<Double> getGeographicalExtent() {
		return isSetGeographicalExtent() ? geographicalExtent.subList(0, 6) : null;
	}

	public void setGeographicalExtent(List<Double> geographicalExtent) {
		if (geographicalExtent == null)
			this.geographicalExtent = null;
		else if (geographicalExtent.size() >= 6)
			this.geographicalExtent = geographicalExtent.subList(0, 6);
	}

	public void unsetGeographicalExtent() {
		geographicalExtent = null;
	}
		
	public void addGeometry(AbstractGeometryType geometry) {
		if (geometry != null && isValidGeometryType(geometry.getType()))
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
	
	public void removeGeometry(AbstractGeometryType geometry) {
		this.geometry.remove(geometry);
	}
	
	public void unsetGeometry() {
		geometry.clear();
	}

	public Object getLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.get(name);

		return null;
	}

	public void setLocalProperty(String name, Object value) {
		if (localProperties == null)
			localProperties = new HashMap<String, Object>();

		localProperties.put(name, value);
	}

	public boolean hasLocalProperty(String name) {
		return localProperties != null && localProperties.containsKey(name);
	}

	public Object unsetLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.remove(name);

		return null;
	}

}
