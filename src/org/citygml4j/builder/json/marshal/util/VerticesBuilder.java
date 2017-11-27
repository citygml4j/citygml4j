package org.citygml4j.builder.json.marshal.util;

import java.util.List;

public interface VerticesBuilder {
	public List<Integer> addVertices(List<Double> vertices);
	public List<List<Double>> build();
}
