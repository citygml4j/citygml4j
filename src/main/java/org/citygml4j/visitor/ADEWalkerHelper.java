package org.citygml4j.visitor;

import org.citygml4j.model.ade.ADEObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
                    // ignore
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
                // ignore
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
                //
            }
        }
    }
}
