/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.visitor;

import org.citygml4j.model.ade.ADEObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ADEWalkerHelper {
    private final ObjectWalker parent;
    private final Deque<Walker> walkers = new ArrayDeque<>();
    private final Map<String, AbstractMap.SimpleEntry<Walker, Method>> methods = new HashMap<>();
    private final Map<String, Field[]> fields = new HashMap<>();

    ADEWalkerHelper(ObjectWalker parent) {
        this.parent = parent;
        walkers.addFirst(parent);
    }

    void addADEWalker(ADEWalker walker) {
        walkers.addFirst(walker);
        methods.clear();
    }

    boolean visitObject(ADEObject adeObject, Class<?> type) {
        Walker walker = null;
        Method method = null;

        String key = type.getName() + '.' + "visit";
        AbstractMap.SimpleEntry<Walker, Method> entry = methods.get(key);
        if (entry == null) {
            for (Walker candidate : walkers) {
                try {
                    method = candidate.getClass().getMethod("visit", type);
                    method.setAccessible(true);
                    walker = candidate;
                    methods.put(key, new AbstractMap.SimpleEntry<>(walker, method));
                    break;
                } catch (NoSuchMethodException e) {
                    //
                }
            }
        } else {
            walker = entry.getKey();
            method = entry.getValue();
        }

        if (method != null) {
            try {
                method.invoke(walker, adeObject);
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException("Failed to visit " + adeObject + ".", e);
            }

            return true;
        } else {
            if (entry == null)
                methods.put(key, new AbstractMap.SimpleEntry<>(null, null));

            return false;
        }
    }

    void visitFields(ADEObject adeObject) {
        Class<?> type = adeObject.getClass();
        Field[] fields = this.fields.computeIfAbsent(type.getName(), v -> type.getDeclaredFields());

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(adeObject);

                if (value instanceof Collection<?>)
                    new ArrayList<>((Collection<?>) value).forEach(parent::visitObject);
                else if (value instanceof Object[])
                    Arrays.stream(((Object[]) value)).forEach(parent::visitObject);
                else if (value != null)
                    parent.visitObject(value);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to visit " + adeObject + ".", e);
            }
        }
    }
}
