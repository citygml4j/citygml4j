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

package org.citygml4j.model.common.base;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ModelObjects {

    public static <T extends Child> T setParent(T child, ModelObject parent) {
        if (child != null)
            child.setParent(parent);

        return child;
    }

    public static <T extends Child> List<T> setParent(List<T> child, ModelObject parent) {
        return child != null ? new ChildList<>(parent, child) : null;
    }

    public static <T extends ModelObject> T setNull(T object) {
        if (object instanceof Child)
            ((Child) object).unsetParent();

        return null;
    }

    public static <T extends List<?>> T setNull(T list) {
        if (list instanceof ChildList)
            ((ChildList<?>) list).unsetParent();

        return null;
    }

    public static boolean unsetProperty(ModelObject object, Object value) {
        if (object == null || value == null)
            return false;

        try {
            Class<?> clazz = object.getClass();
            boolean removed = false;

            do {
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object candidate = field.get(object);
                    if (candidate == null)
                        continue;

                    if (candidate == value) {
                        field.set(object, null);
                        removed = true;
                    } else if (candidate instanceof Collection) {
                        removed = ((Collection<?>) candidate).removeIf(o -> o == value);
                        if (removed && ((Collection<?>) candidate).isEmpty())
                            field.set(object, null);
                    } else if (candidate instanceof Map) {
                        removed = ((Map<?, ?>) candidate).entrySet().removeIf(e -> e.getValue() == value);
                        if (removed && ((Map<?, ?>) candidate).isEmpty())
                            field.set(object, null);
                    } else if (candidate.getClass().isArray()) {
                        for (int i = 0; i < Array.getLength(candidate); i++) {
                            if (Array.get(candidate, i) == value) {
                                Array.set(candidate, i, null);
                                removed = true;
                            }
                        }
                    }
                }
            } while (!removed && (clazz = clazz.getSuperclass()) != null);

            return removed;
        } catch (Throwable e) {
            return false;
        }
    }
}