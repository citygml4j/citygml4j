package org.citygml4j.model.citygml.ade.binding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.citygml4j.util.walker.Walker;

public class ADEWalkerHelper<T extends Walker> {
	private Set<ADEWalker<T>> walkers;
	private HashMap<String, SimpleEntry<ADEWalker<T>, Method>> methods;
	private Class<?> returnType;

	public ADEWalkerHelper() {
		walkers = new HashSet<>();
		methods = new HashMap<>();
	}

	public void addADEWalker(ADEWalker<T> walker) {
		walkers.add(walker);
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
