package org.citygml4j.builder.json.marshal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleVerticesBuilder implements VerticesBuilder {
	private final ReentrantLock lock = new ReentrantLock();
	private List<List<Double>> vertices = new ArrayList<>();


	@Override
	public List<Integer> addVertices(List<Double> vertices) {
		lock.lock();
		try {
			List<Integer> indexes = new ArrayList<>();
			int index = this.vertices.size();

			for (int i = 0; i < vertices.size(); i += 3) {
				this.vertices.add(vertices.subList(i, i + 3));
				indexes.add(index++);
			}

			return indexes;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public List<List<Double>> getVertices() {
		return vertices;
	}

	@Override
	public int getNumVertices() {
		return vertices.size();
	}

}
