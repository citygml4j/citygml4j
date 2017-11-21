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
	public boolean collapseValues() {
		if (values == null)
			return true;	

		Integer compareTo = null;
		if (!values.isEmpty()) {
			compareTo = values.get(0);
			for (int i = 1 ; i < values.size(); i++) {
				if (values.get(i) != compareTo)
					return false;
			}
		}

		unsetValues();
		if (compareTo != null)
			setValue(compareTo);

		return true;
	}

	@Override
	public void unsetValues() {
		values = null;
	}

}
