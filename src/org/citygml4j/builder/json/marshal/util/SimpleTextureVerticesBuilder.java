package org.citygml4j.builder.json.marshal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleTextureVerticesBuilder implements TextureVerticesBuilder {
	private final ReentrantLock lock = new ReentrantLock();
	private final List<List<Double>> vertices = new ArrayList<>();
	
	@Override
	public List<Integer> addTextureVertices(List<Double> textureVertices) {
		lock.lock();
		try {
			List<Integer> indexes = new ArrayList<>();
			int index = this.vertices.size();
			
			for (int i = 0; i < textureVertices.size(); i += 2) {
				this.vertices.add(textureVertices.subList(i, i + 2));
				indexes.add(index++);
			}
			
			return indexes;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public List<List<Double>> getTextureVertices() {
		return vertices;
	}

	@Override
	public int getNumTextureVertices() {
		return vertices.size();
	}

}
