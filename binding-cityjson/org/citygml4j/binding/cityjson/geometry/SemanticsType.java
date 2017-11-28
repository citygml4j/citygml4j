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
	
}
