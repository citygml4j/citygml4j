package org.citygml4j.util.mapper;

import java.util.HashMap;

import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class CheckedTypeMapper<R> {

	@FunctionalInterface
	public interface CheckedFunction<T, R> {
		R apply(T t) throws MissingADESchemaException;
	}

	private HashMap<Class<?>, CheckedFunction<Object, R>> functionMap = new HashMap<>();

	private CheckedTypeMapper() {
		// just to thwart instantiation
	}

	public static <R> CheckedTypeMapper<R> create() {
		return new CheckedTypeMapper<>();
	}

	@SuppressWarnings("unchecked")
	public <T> CheckedTypeMapper<R> with(final Class<T> target, final CheckedFunction<T, R> function) {
		functionMap.put(target, (CheckedFunction<Object, R>)function);		
		return this;
	}

	public R apply(final Object src) throws MissingADESchemaException {
		if (src != null) {		
			CheckedFunction<Object, R> function = functionMap.get(src.getClass());		
			if (function != null)
				return function.apply(src);
		}

		return null;		
	}

}
