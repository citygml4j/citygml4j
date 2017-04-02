package org.citygml4j.model.citygml.ade.binding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

import org.citygml4j.util.walker.Walker;

public class ADEWalkerHelper<T extends Walker> {
	private HashMap<String, ADEWalker<T>> walkers;
	private HashMap<String, Method> methods;
	private Class<?> returnType;
	
	public ADEWalkerHelper() {
		walkers = new HashMap<>();
		methods = new HashMap<>();
	}
	
	public void addADEWalker(ADEWalker<T> walker) {
		walkers.put(walker.getNamespaceURI(), walker);
	}
	
	public ADEWalker<T> getADEWalker(ADEModelObject adeModelClass) {
		return walkers.get(adeModelClass.getNamespaceURI());
	}
	
	public Method getMethod(ADEModelObject adeModelObject, String prefix) {
		String methodName = new StringBuilder(prefix).append(adeModelObject.getClass().getSimpleName()).toString();		
		String key = getKey(adeModelObject.getNamespaceURI(), methodName);
		
		if (methods.containsKey(key))
			return methods.get(key);
		
		Method method = null;
		ADEWalker<T> walker = walkers.get(adeModelObject.getNamespaceURI());
		if (walker != null) {
			try {
				method = walker.getClass().getMethod(methodName, new Class<?>[]{adeModelObject.getClass()});
				method.setAccessible(true);
			} catch (NoSuchMethodException | SecurityException e) {
				method = null;
			}
		}
		
		methods.put(key, method);
		return method;
	}
	
	public void inferFunctionType(T parent, Class<?> genericSuperClass) {		
		Class<?> cls = parent.getClass();
		while (!(cls.getSuperclass() == null || cls.getSuperclass().equals(genericSuperClass)))
			cls = cls.getSuperclass();
		
		if (cls.getSuperclass() != null)
			returnType = (Class<?>)((ParameterizedType)cls.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public boolean isInstanceOfFunctionType(Object value) {
		return returnType != null && returnType.isInstance(value);
	}
	
	private String getKey(String namespaceURI, String methodName) {
		return new StringBuilder(namespaceURI).append('.').append(methodName).toString();
	}
}
