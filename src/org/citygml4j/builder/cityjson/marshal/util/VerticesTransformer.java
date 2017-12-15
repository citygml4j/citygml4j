package org.citygml4j.builder.cityjson.marshal.util;

import java.util.List;

import org.citygml4j.binding.cityjson.geometry.TransformType;

public interface VerticesTransformer {
	public TransformType applyTransformation(List<List<Double>> vertices);
}
