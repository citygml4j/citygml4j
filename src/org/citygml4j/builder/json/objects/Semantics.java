package org.citygml4j.builder.json.objects;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(SemanticsAdapter.class)
public class Semantics {
	public static final Semantics EMPTY = new Semantics();
	private final SemanticsType type;
	private transient Map<String, Object> properties;
	
	Semantics() {
		type = null;
	}
	
	public Semantics(SemanticsType type) {
		this.type = type;
	}
	
	public SemanticsType getType() {
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
