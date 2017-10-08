package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class SolidTextureObject extends AbstractTextureObject {
	private List<List<List<List<Integer>>>> values;
	
	public SolidTextureObject() {
	}
	
	public SolidTextureObject(String theme) {
		super(theme);
	}

	public boolean isSetValues() {
		return values != null;
	}

	public void addValue(List<List<List<Integer>>> value) {
		if (values == null)
			values = new ArrayList<>();

		values.add(value);
	}

	public List<List<List<List<Integer>>>> getValues() {
		return values;
	}

	public void setValues(List<List<List<List<Integer>>>> values) {
		this.values = values;
	}
	
	public int size() {
		return values != null ? values.size() : 0;
	}

}
