package org.citygml4j.util.binding;

import java.util.HashMap;
import java.util.function.Function;

public class JAXBMapper<R> {
	private HashMap<Class<?>, Function<Object, R>> functionMap = new HashMap<>();

	private JAXBMapper() {
		// just to thwart instantiation
	}

	public static <R> JAXBMapper<R> create() {
		return new JAXBMapper<>();
	}

	@SuppressWarnings("unchecked")
	public <T> JAXBMapper<R> with(final Class<T> target, final Function<T, R> function) {
		functionMap.put(target, (Function<Object, R>)function);		
		return this;
	}

	public R apply(final Object src) {
		if (src != null) {		
			Function<Object, R> function = functionMap.get(src.getClass());		
			if (function != null)
				return function.apply(src);
		}

		return null;		
	}

}
