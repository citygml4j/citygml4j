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

import com.google.gson.annotations.SerializedName;

public class BuildingType extends AbstractBuildingType {
	private final CityObjectTypeName type = CityObjectTypeName.BUILDING;
	@SerializedName("Parts")
	private List<String> parts;
	
	BuildingType() {
	}
	
	public BuildingType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public CityObjectTypeName getType() {
		return type;
	}
	
	public boolean isSetParts() {
		return parts != null;
	}
	
	public void addPart(String part) {
		if (parts == null)
			parts = new ArrayList<>();
		
		parts.add(part);
	}

	public List<String> getParts() {
		return parts;
	}

	public void setParts(List<String> parts) {
		this.parts = parts;
	}
		
}
