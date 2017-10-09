package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SurfaceTextureObject extends AbstractTextureObject {
	public static final List<List<Integer>> NULL_VALUE = Collections.singletonList(Arrays.asList(new Integer[]{null}));	
	private List<List<List<Integer>>> values;
	
	public SurfaceTextureObject() {
	}
	
	public SurfaceTextureObject(String theme) {
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
	
	@Override
	public void addNull() {
		addValue(NULL_VALUE);
	}

	public List<List<List<Integer>>> getValues() {
		return values;
	}

	public void setValues(List<List<List<Integer>>> values) {
		this.values = values;
	}
	
	@Override
	public int size() {
		return values != null ? values.size() : 0;
	}

}
