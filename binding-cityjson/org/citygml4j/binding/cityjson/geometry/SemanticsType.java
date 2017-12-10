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
package org.citygml4j.binding.cityjson.geometry;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(SemanticsTypeAdapter.class)
public class SemanticsType {
	private final SemanticsTypeName type;
	private transient Map<String, Object> properties;
	
	SemanticsType() {
		type = null;
	}
	
	public SemanticsType(SemanticsTypeName type) {
		this.type = type;
	}
	
	public SemanticsTypeName getType() {
		return type;
	}
	
	public boolean isSetProperties() {
		return properties != null;
	}
	
	public void addProperty(String name, Object value) {
		if (properties == null)
			properties = new HashMap<>();
		
		properties.put(name, value);
	}
	
	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, Object> properties) {
		if (type != null)
			this.properties = properties;
	}
	
	public void removeProperty(String name) {
		if (properties != null)
			properties.remove(name);
	}
	
	public void unsetProperties() {
		properties = null;
	}
	
}
