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
package org.citygml4j.model.citygml.ade.binding;

import org.citygml4j.util.walker.Walker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ADEWalkerHelper<T extends Walker> {
	private Deque<ADEWalker<T>> walkers;
	private Map<String, SimpleEntry<ADEWalker<T>, Method>> methods;
	private Class<?> returnType;

	public ADEWalkerHelper() {
		walkers = new ArrayDeque<>();
		methods = new HashMap<>();
	}

	public void addADEWalker(ADEWalker<T> walker) {
		walkers.addFirst(walker);
		if (!methods.isEmpty())
			methods.clear();
	}

	public Object invokeWalkerMethod(ADEModelObject adeModelObject, String methodName) {
		String key = getKey(adeModelObject, methodName);

		ADEWalker<T> walker = null;
		Method method = null;

		SimpleEntry<ADEWalker<T>, Method> entry = methods.get(key);
		if (entry != null) {
			walker = entry.getKey();
			method = entry.getValue();
		}

		else {
			for (Iterator<ADEWalker<T>> iter = walkers.iterator(); iter.hasNext();) {
				walker = iter.next();
				if (walker != null) {
					try {
						method = walker.getClass().getMethod(methodName, new Class<?>[]{adeModelObject.getClass()});
						method.setAccessible(true);
						methods.put(key, new SimpleEntry<>(walker, method));
						break;
					} catch (NoSuchMethodException | SecurityException e) {
						//
					}
				}
			}
			
			if (method == null)
				methods.put(key, new SimpleEntry<>(null, null));
		}

		if (method != null) {
			try {
				Object returnValue = method.invoke(walker, new Object[]{adeModelObject});
				if (returnValue != null && returnType.isInstance(returnValue))
					return returnValue;
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				//
			}
		}

		return null;
	}

	public void inferFunctionType(T parent, Class<?> genericSuperClass) {		
		Class<?> cls = parent.getClass();
		while (!(cls.getSuperclass() == null || cls.getSuperclass().equals(genericSuperClass)))
			cls = cls.getSuperclass();

		if (cls.getSuperclass() != null)
			returnType = (Class<?>)((ParameterizedType)cls.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private String getKey(ADEModelObject adeModelObject, String methodName) {
		return new StringBuilder(adeModelObject.getClass().getName()).append('.').append(methodName).toString();
	}

}
