package org.citygml4j.builder.json.objects.appearance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolidCollectionMaterialObject extends AbstractMaterialObject {
	private List<List<List<Integer>>> values;

	public SolidCollectionMaterialObject() {
	}

	public SolidCollectionMaterialObject(String theme) {
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
		addValue(null);
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
	public boolean collapseValues() {
		if (values == null)
			return true;

		List<Integer> values = this.values.stream()
				.flatMap(a -> a != null ? a.stream() : Stream.of((List<Integer>)null))
				.flatMap(b -> b != null ? b.stream() : Stream.of((Integer)null)).collect(Collectors.toList());

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
