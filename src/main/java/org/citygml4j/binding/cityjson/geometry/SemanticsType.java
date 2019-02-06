/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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

import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonAdapter(SemanticsTypeAdapter.class)
public class SemanticsType {
	String type;
	private Integer parent;
	private List<Integer> children;
	private transient Map<String, Object> attributes;

	public SemanticsType() {
		type = null;
	}
	
	public SemanticsType(String type) {
		this.type = type;
	}
	
	public final String getType() {
		return type;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}

	public boolean isSetChildren() {
		return children != null && !children.isEmpty();
	}

	public void addChild(int child) {
		if (children == null)
			children = new ArrayList<>();

		children.add(child);
	}

	public List<Integer> getChildren() {
		return children;
	}

	public void setChildren(List<Integer> Children) {
		this.children = Children;
	}

	public void unsetChildren() {
		children = null;
	}
	
	public boolean isSetAttributes() {
		return attributes != null;
	}
	
	public void addAttribute(String name, Object value) {
		if (attributes == null)
			attributes = new HashMap<>();
		
		attributes.put(name, value);
	}
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String, Object> properties) {
		if (type != null)
			this.attributes = properties;
	}
	
	public void removeAttribute(String name) {
		if (attributes != null)
			attributes.remove(name);
	}
	
	public void unsetAttributes() {
		attributes = null;
	}
}
