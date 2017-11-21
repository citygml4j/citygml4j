package org.citygml4j.builder.json.objects.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolidSemanticsObject extends AbstractSemanticsObject {
	private List<List<Integer>> values;

	public boolean isSetValues() {
		return values != null;
	}

	public void addValues(List<Integer> value) {
		if (values == null)
			values = new ArrayList<>();

		values.add(value);
	}

	@Override
	public void addNullValue() {
		addValues(null);
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

}
