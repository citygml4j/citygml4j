/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.visitor;

import org.citygml4j.core.model.ade.ADEObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ADEWalkerHelper {
    private final ObjectWalker parent;
    private final Deque<Walker> walkers = new ArrayDeque<>();
    private final Map<Class<?>, Visitor> methods = new HashMap<>();
    private final Map<FieldsKey, Field[]> fields = new HashMap<>();

    private record Visitor(Walker walker, Method method) {
        static final Visitor NONE = new Visitor(null, null);
    }

    private record FieldsKey(Class<?> type, Class<?> stop) {
    }

    ADEWalkerHelper(ObjectWalker parent) {
        this.parent = parent;
        walkers.addFirst(parent);
    }

    void addADEWalker(ADEWalker walker) {
        walkers.addFirst(walker);
        methods.clear();
    }

    boolean visitObject(ADEObject adeObject, Class<?> type) {
        Visitor visitor = methods.computeIfAbsent(type, this::findVisitor);
        if (visitor.method() != null) {
            try {
                visitor.method().invoke(visitor.walker(), adeObject);
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException("Failed to visit " + adeObject + ".", e);
            }

            return true;
        } else {
            return false;
        }
    }

    private Visitor findVisitor(Class<?> type) {
        for (Walker candidate : walkers) {
            try {
                Method method = candidate.getClass().getMethod("visit", type);
                method.setAccessible(true);
                return new Visitor(candidate, method);
            } catch (NoSuchMethodException e) {
                //
            }
        }

        return Visitor.NONE;
    }

    void visitFields(ADEObject adeObject, Class<?> stop) {
        Class<?> type = adeObject.getClass();
        Field[] fields = this.fields.computeIfAbsent(new FieldsKey(type, stop), v -> {
            List<Field> candidates = new ArrayList<>();
            for (Class<?> current = type; current != null && current != stop; current = current.getSuperclass()) {
                for (Field field : current.getDeclaredFields()) {
                    if (!Modifier.isStatic(field.getModifiers()) && !field.isSynthetic()) {
                        candidates.add(field);
                    }
                }
            }

            return candidates.toArray(new Field[0]);
        });

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(adeObject);

                switch (value) {
                    case null -> {
                    }
                    case Collection<?> collection -> new ArrayList<>(collection).forEach(parent::visitObject);
                    case Object[] array -> Arrays.stream(array).forEach(parent::visitObject);
                    default -> parent.visitObject(value);
                }
            } catch (Throwable e) {
                throw new RuntimeException("Failed to visit " + adeObject + ".", e);
            }
        }
    }
}
