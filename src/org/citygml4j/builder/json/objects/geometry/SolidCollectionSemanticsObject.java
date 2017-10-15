package org.citygml4j.builder.json.objects.geometry;

import java.util.ArrayList;
import java.util.List;

public class SolidCollectionSemanticsObject extends AbstractSemanticsObject {
	private List<List<List<Integer>>> values;

	public boolean isSetValues() {
		return values != null;
	}

	public void addValues(List<List<Integer>> value) {
		if (values == null)
			values = new ArrayList<>();

		values.add(value);
	}

	@Override
	public void addNullValue() {
		addValues(null);
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

}
