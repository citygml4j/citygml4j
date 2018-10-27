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
import com.google.gson.annotations.SerializedName;
import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import java.util.ArrayList;
import java.util.List;

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
	public BridgeAttributes newAttributes() {
		attributes = new BridgeAttributes();
		return attributes;
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
		return installations != null && !installations.isEmpty();
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

	public void unsetInstallations() {
		installations = null;
	}
	
	public boolean isSetConstructionElements() {
		return constructionElements != null && !constructionElements.isEmpty();
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

	public void unsetConstructionElements() {
		constructionElements = null;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.SOLID
				|| type == GeometryTypeName.COMPOSITE_SOLID
				|| type == GeometryTypeName.GEOMETRY_INSTANCE;
	}
}
