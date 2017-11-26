package org.citygml4j.builder.json.objects.appearance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SurfaceCollectionTextureObject extends AbstractTextureObject {
	public static final List<List<Integer>> NULL_VALUE = Collections.singletonList(Arrays.asList(new Integer[]{null}));
	private List<List<List<Integer>>> values;
	
	SurfaceCollectionTextureObject() {
	}
	
	public SurfaceCollectionTextureObject(String theme) {
		super(theme);
	}

	@Override
	public boolean isSetValues() {
		return values != null;
	}

	public void addValue(List<List<Integer>> value) {
		if (values == null)
			values = new ArrayList<>();

		values.add(value);
	}
	
	@Override
	public void addNullValue() {
		addValue(NULL_VALUE);
	}

	public List<List<List<Integer>>> getValues() {
		return values;
	}

	public void setValues(List<List<List<Integer>>> values) {
		this.values = values;
	}
	
	@Override
	public int getNumValues() {
		return values != null ? values.size() : 0;
	}

	@Override
	public List<List<List<Integer>>> flatValues() {
		return values;
	}

}
