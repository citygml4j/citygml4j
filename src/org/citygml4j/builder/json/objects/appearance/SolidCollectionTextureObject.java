package org.citygml4j.builder.json.objects.appearance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolidCollectionTextureObject extends AbstractTextureObject {
	public static final List<List<List<List<Integer>>>> NULL_VALUE = Collections.singletonList(SolidTextureObject.NULL_VALUE);
	private List<List<List<List<List<Integer>>>>> values;
	
	SolidCollectionTextureObject() {
	}
	
	public SolidCollectionTextureObject(String theme) {
		super(theme);
	}

	@Override
	public boolean isSetValues() {
		return values != null;
	}

	public void addValue(List<List<List<List<Integer>>>> value) {
		if (values == null)
			values = new ArrayList<>();

		values.add(value);
	}
	
	@Override
	public void addNullValue() {
		addValue(NULL_VALUE);
	}

	public List<List<List<List<List<Integer>>>>> getValues() {
		return values;
	}

	public void setValues(List<List<List<List<List<Integer>>>>> values) {
		this.values = values;
	}
	
	@Override
	public int getNumValues() {
		return values != null ? values.size() : 0;
	}

	@Override
	public List<List<List<Integer>>> flatValues() {
		return values != null ? values.stream()
				.flatMap(a -> a != null ? a.stream() : Stream.of((List<List<List<Integer>>>)null))
				.flatMap(b -> b != null ? b.stream() : Stream.of((List<List<Integer>>)null)).collect(Collectors.toList()) : null;
	}

}
