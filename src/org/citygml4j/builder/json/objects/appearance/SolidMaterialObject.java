package org.citygml4j.builder.json.objects.appearance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolidMaterialObject extends AbstractMaterialObject {
	private List<List<Integer>> values;
	
	SolidMaterialObject() {
	}
	
	public SolidMaterialObject(String theme) {
		super(theme);
	}
	
	@Override
	public boolean isSetValues() {
		return values != null;
	}
	
	public void addValue(List<Integer> value) {
		if (values == null)
			values = new ArrayList<>();
		
		values.add(value);
	}
	
	@Override
	public void addNullValue() {
		addValue(null);
	}

	public List<List<Integer>> getValues() {
		return values;
	}

	public void setValues(List<List<Integer>> values) {
		this.values = values;
	}
	
	@Override
	public int getNumValues() {
		return values != null ? values.size() : 0;
	}
	
	@Override
	public List<Integer> flatValues() {
		return values != null ? values.stream()
				.flatMap(a -> a != null ? a.stream() : Stream.of((Integer)null)).collect(Collectors.toList()) : null;
	}
	
	@Override
	public void unsetValues() {
		values = null;
	}
	
}
