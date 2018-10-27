/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.xml.io.reader.MissingADESchemaException;

import java.util.HashMap;

public class CheckedTypeMapper<R> {

	@FunctionalInterface
	public interface CheckedFunction<T, R> {
		R apply(T t) throws MissingADESchemaException;
	}

	private HashMap<Class<?>, CheckedFunction<Object, R>> functionMap = new HashMap<>();

	private CheckedTypeMapper() {
		// just to thwart instantiation
	}

	public static <R> CheckedTypeMapper<R> create() {
		return new CheckedTypeMapper<>();
	}

	@SuppressWarnings("unchecked")
	public <T> CheckedTypeMapper<R> with(final Class<T> target, final CheckedFunction<T, R> function) {
		functionMap.put(target, (CheckedFunction<Object, R>)function);		
		return this;
	}

	public R apply(final Object src) throws MissingADESchemaException {
		if (src != null) {		
			CheckedFunction<Object, R> function = functionMap.get(src.getClass());		
			if (function != null)
				return function.apply(src);
		}

		return null;		
	}

}
