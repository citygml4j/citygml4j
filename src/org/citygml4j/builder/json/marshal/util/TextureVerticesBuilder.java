package org.citygml4j.builder.json.marshal.util;

import java.util.List;

public interface TextureVerticesBuilder {
	public List<Integer> addTextureVertices(List<Double> vertices);
	public List<List<Double>> getTextureVertices();
	public int getNumTextureVertices();
}
