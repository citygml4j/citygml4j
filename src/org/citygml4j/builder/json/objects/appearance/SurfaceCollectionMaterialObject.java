package org.citygml4j.builder.json.objects.appearance;

import java.util.ArrayList;
import java.util.List;

public class SurfaceCollectionMaterialObject extends AbstractMaterialObject {
	private List<Integer> values;

	public SurfaceCollectionMaterialObject() {
	}

	public SurfaceCollectionMaterialObject(String theme) {
		super(theme);
	}

	@Override
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

	@Override
	public void unsetValues() {
		values = null;
	}

}
