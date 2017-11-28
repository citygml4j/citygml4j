package org.citygml4j.builder.cityjson.marshal.util;

import java.util.List;

public interface TextureVerticesBuilder {
	public List<Integer> addTextureVertices(List<Double> vertices);
	public List<List<Double>> build();
}
