package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class SolidCollectionMaterialObject extends AbstractMaterialObject {
private List<List<List<Integer>>> values;
	
	public SolidCollectionMaterialObject() {
	}
	
	public SolidCollectionMaterialObject(String theme) {
		super(theme);
	}
	
	public boolean isSetValues() {
		return values != null;
	}
	
	public void addValue(List<List<Integer>> value) {
		if (values == null)
			values = new ArrayList<>();
		
		values.add(value);
	}

	public List<List<List<Integer>>> getValues() {
		return values;
	}

	public void setValues(List<List<List<Integer>>> values) {
		this.values = values;
	}
	
	public int size() {
		return values != null ? values.size() : 0;
	}
	
}
