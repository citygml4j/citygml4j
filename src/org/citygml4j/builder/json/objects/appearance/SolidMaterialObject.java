package org.citygml4j.builder.json.objects.appearance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolidMaterialObject extends AbstractMaterialObject {
	public static final List<Integer> NULL_VALUE = Collections.singletonList(SurfaceMaterialObject.NULL_VALUE);
	private List<List<Integer>> values;
	
	public SolidMaterialObject() {
	}
	
	public SolidMaterialObject(String theme) {
		super(theme);
	}
	
	public boolean isSetValues() {
		return values != null;
	}
	
	public void addValue(List<Integer> value) {
		if (values == null)
			values = new ArrayList<>();
		
		values.add(value);
	}
	
	@Override
	public void addNull() {
		addValue(NULL_VALUE);
	}

	public List<List<Integer>> getValues() {
		return values;
	}

	public void setValues(List<List<Integer>> values) {
		this.values = values;
	}
	
	@Override
	public int size() {
		return values != null ? values.size() : 0;
	}
	
}
