/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.util.mapper;

import java.util.HashMap;
import java.util.Map;

public class TriFunctionTypeMapper<U, V, R> {
	private final Map<Class<?>, TriFunction<Object, U, V, R>> functionMap = new HashMap<>();

	private TriFunctionTypeMapper() {
		// just to thwart instantiation
	}

	public static <U, V, R> TriFunctionTypeMapper<U, V, R> create() {
		return new TriFunctionTypeMapper<>();
	}

	@SuppressWarnings("unchecked")
	public <T> TriFunctionTypeMapper<U, V, R> with(final Class<T> target, final TriFunction<T, U, V, R> function) {
		functionMap.put(target, (TriFunction<Object, U, V, R>)function);
		return this;
	}

	public R apply(final Object src, U arg1, V arg2) {
		if (src != null) {
			TriFunction<Object, U, V, R> function = functionMap.get(src.getClass());
			if (function != null)
				return function.apply(src, arg1, arg2);
		}

		return null;		
	}

}
