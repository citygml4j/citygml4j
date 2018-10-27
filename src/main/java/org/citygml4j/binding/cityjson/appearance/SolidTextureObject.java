/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.binding.cityjson.appearance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolidTextureObject extends AbstractTextureObject {
	public static final List<List<List<Integer>>> NULL_VALUE = Collections.singletonList(SurfaceCollectionTextureObject.NULL_VALUE);
	private List<List<List<List<Integer>>>> values;
	
	SolidTextureObject() {
	}
	
	public SolidTextureObject(String theme) {
		super(theme);
	}

	@Override
	public boolean isSetValues() {
		return values != null;
	}

	public void addValue(List<List<List<Integer>>> value) {
		if (values == null)
			values = new ArrayList<>();

		values.add(value);
	}
	
	@Override
	public void addNullValue() {
		addValue(NULL_VALUE);
	}

	public List<List<List<List<Integer>>>> getValues() {
		return values;
	}

	public void setValues(List<List<List<List<Integer>>>> values) {
		this.values = values;
	}
	
	@Override
	public int getNumValues() {
		return values != null ? values.size() : 0;
	}

	@Override
	public List<List<List<Integer>>> flatValues() {
		return values != null ? values.stream()
				.flatMap(a -> a != null ? a.stream() : Stream.of((List<List<Integer>>)null)).collect(Collectors.toList()) : null;
	}
	
	@Override
	public void unsetValues() {
		values = null;
	}

}
