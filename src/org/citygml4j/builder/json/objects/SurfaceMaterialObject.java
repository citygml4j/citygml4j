package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.List;

public class SurfaceMaterialObject extends AbstractMaterialObject {
	public static final Integer NULL_VALUE = null;
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
	
	@Override
	public void addNull() {
		addValue(NULL_VALUE);
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}
	
	@Override
	public int size() {
		return values != null ? values.size() : 0;
	}
	
}
