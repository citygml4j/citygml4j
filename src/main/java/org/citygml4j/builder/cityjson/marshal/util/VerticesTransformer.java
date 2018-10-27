package org.citygml4j.builder.cityjson.marshal.util;

import org.citygml4j.binding.cityjson.geometry.TransformType;

import java.util.List;

public interface VerticesTransformer {
	public TransformType applyTransformation(List<List<Double>> vertices);
}
