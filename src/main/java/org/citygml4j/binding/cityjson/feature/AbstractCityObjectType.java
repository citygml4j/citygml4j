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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(CityObjectTypeAdapter.class)
public abstract class AbstractCityObjectType {
	protected transient String gmlId;
	private List<Double> bbox;
	private List<AbstractGeometryType> geometry = new ArrayList<>();

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

	public boolean isSetBBox() {
		return bbox != null && bbox.size() >= 6;
	}

	public List<Double> getBBox() {
		return isSetBBox() ? bbox.subList(0, 6) : null;
	}

	public void setBBox(List<Double> bbox) {
		if (bbox == null)
			this.bbox = null;
		else if (bbox.size() >= 6)
			this.bbox = bbox.subList(0, 6);
	}

	public void unsetBBox() {
		bbox = null;
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
	
	public void removeGeometry(AbstractGeometryType geometry) {
		this.geometry.remove(geometry);
	}
	
	public void unsetGeometry() {
		geometry.clear();
	}

}
