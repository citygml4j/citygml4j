package org.citygml4j.builder.cityjson.marshal.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleTextureVerticesBuilder implements TextureVerticesBuilder {
	private final ReentrantLock lock = new ReentrantLock();	
	private final Map<String, Integer> indexes = new ConcurrentHashMap<>();
	private final List<List<Double>> vertices = new ArrayList<>();	

	private int significantDigits = 5;

	public SimpleTextureVerticesBuilder withSignificantDigits(int significantDigits) {
		if (significantDigits > 0)
			this.significantDigits = significantDigits;

		return this;
	}

	public int getSignificantDigits() {
		return significantDigits;
	}

	@Override
	public List<Integer> addTextureVertices(List<Double> vertices) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < vertices.size(); i += 2) {
			List<Double> vertex = vertices.subList(i, i + 2);
			String key = new StringBuilder()
					.append(round(vertex.get(0)))
					.append(round(vertex.get(1))).toString();
			
			Integer index = indexes.get(key);
			if (index == null) {
				Integer tmp = null;

				lock.lock();
				try {
					tmp = this.vertices.size();
					this.vertices.add(vertex);
				} finally {
					lock.unlock();
				}

				index = indexes.putIfAbsent(key, tmp);
				if (index == null)
					index = tmp;
			}

			result.add(index);
		}

		return result;
	}

	@Override
	public List<List<Double>> build() {
		indexes.clear();
		return vertices;
	}

	private String round(double value) {
		return BigDecimal.valueOf(value).setScale(significantDigits, RoundingMode.FLOOR).toString();
	}
}
