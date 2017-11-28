package org.citygml4j.binding.cityjson.geometry;

import java.util.ArrayList;
import java.util.List;

public class SurfaceCollectionSemanticsObject extends AbstractSemanticsObject {
	private List<Integer> values;
		
	public boolean isSetValues() {
		return values != null;
	}
	
	public void addValue(Integer value) {
		if (values == null)
			values = new ArrayList<>();
		
		values.add(value);
	}
	
	@Override
	public void addNullValue() {
		addValue(null);
	}

	public List<Integer> getValues() {
		return values;
	}
	
	public void setValues(List<Integer> values) {
		this.values = values;
	}
	
	@Override
	public int getNumValues() {
		return values != null ? values.size() : 0;
	}

	@Override
	public List<Integer> flatValues() {
		return values;
	}
	
}
