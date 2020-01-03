package org.citygml4j.visitor;

import org.citygml4j.model.ade.ADEObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ADEWalkerHelper {
    private final Deque<ADEWalker> walkers;
    private final Map<String, AbstractMap.SimpleEntry<ADEWalker, Method>> methods;

    ADEWalkerHelper() {
        walkers = new ArrayDeque<>();
        methods = new HashMap<>();
    }

    void addADEWalker(ADEWalker walker) {
        walkers.addFirst(walker);
        methods.clear();
    }

    boolean visit(ADEObject adeObject) {
        ADEWalker walker = null;
        Method method = null;

        String key = adeObject.getClass().getName() + '.' + "visit";
        AbstractMap.SimpleEntry<ADEWalker, Method> entry = methods.get(key);
        if (entry != null) {
            walker = entry.getKey();
            method = entry.getValue();
        } else {
            for (ADEWalker registeredWalker : walkers) {
                if (registeredWalker != null) {
                    try {
                        method = registeredWalker.getClass().getMethod("visit", adeObject.getClass());
                        method.setAccessible(true);
                        walker = registeredWalker;

                        methods.put(key, new AbstractMap.SimpleEntry<>(walker, method));
                        break;
                    } catch (NoSuchMethodException e) {
                        // ignore
                    }
                }
            }
        }

        if (method != null) {
            try {
                method.invoke(walker, adeObject);
            } catch (InvocationTargetException | IllegalAccessException e) {
                // ignore
            }

            return true;
        } else
            return false;
    }
}
