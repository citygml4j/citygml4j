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

package org.citygml4j.util.mapper;

import java.util.HashMap;
import java.util.function.BiFunction;

public class BiFunctionTypeMapper<U, R> {
	private HashMap<Class<?>, BiFunction<Object, U, R>> functionMap = new HashMap<>();

	private BiFunctionTypeMapper() {
		// just to thwart instantiation
	}

	public static <U, R> BiFunctionTypeMapper<U, R> create() {
		return new BiFunctionTypeMapper<>();
	}

	@SuppressWarnings("unchecked")
	public <T> BiFunctionTypeMapper<U, R> with(final Class<T> target, final BiFunction<T, U, R> function) {
		functionMap.put(target, (BiFunction<Object, U, R>)function);		
		return this;
	}

	public R apply(final Object src, U arg) {
		if (src != null) {		
			BiFunction<Object, U, R> function = functionMap.get(src.getClass());		
			if (function != null)
				return function.apply(src, arg);
		}

		return null;		
	}

}
