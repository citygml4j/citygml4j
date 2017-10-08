package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class SurfaceMaterialObject extends AbstractMaterialObject {
	private List<Integer> values;
	
	public SurfaceMaterialObject() {
	}
	
	public SurfaceMaterialObject(String theme) {
		super(theme);
	}
	
	public boolean isSetValues() {
		return values != null;
	}
	
	public void addValue(Integer value) {
		if (values == null)
			values = new ArrayList<>();
		
		values.add(value);
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}
	
	public int size() {
		return values != null ? values.size() : 0;
	}
	
}
