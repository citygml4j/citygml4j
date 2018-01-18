package org.citygml4j.util.mapper;

import java.util.HashMap;
import java.util.function.BiFunction;

public class BiFunctionTypeMapper<U, R> {
	private HashMap<Class<?>, BiFunction<Object, U, R>> functionMap = new HashMap<>();

	private BiFunctionTypeMapper() {
		// just to thwart instantiation
	}

	public static <U, R> BiFunctionTypeMapper<U, R> create() {
		return new BiFunctionTypeMapper<>();
	}

	@SuppressWarnings("unchecked")
	public <T> BiFunctionTypeMapper<U, R> with(final Class<T> target, final BiFunction<T, U, R> function) {
		functionMap.put(target, (BiFunction<Object, U, R>)function);		
		return this;
	}

	public R apply(final Object src, U arg) {
		if (src != null) {		
			BiFunction<Object, U, R> function = functionMap.get(src.getClass());		
			if (function != null)
				return function.apply(src, arg);
		}

		return null;		
	}

}
