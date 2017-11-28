package org.citygml4j.builder.json.marshal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleVerticesBuilder implements VerticesBuilder {
	private final ReentrantLock lock = new ReentrantLock();	
	private final Map<Integer, Integer> indexes = new ConcurrentHashMap<>();
	private final List<List<Double>> vertices = new ArrayList<>();	

	private double significantDigits = Math.pow(10, 3);
	
	public SimpleVerticesBuilder withSignificantDigits(int significantDigits) {
		if (significantDigits > 0)
			this.significantDigits = Math.pow(10, significantDigits);
		
		return this;
	}
	
	public int getSignificantDigits() {
		return (int)Math.log10(significantDigits);
	}

	@Override
	public List<Integer> addVertices(List<Double> vertices) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < vertices.size(); i += 3) {
			List<Double> vertex = vertices.subList(i, i + 3);
			int key = Objects.hash(round(vertex.get(0)), round(vertex.get(1)), round(vertex.get(2)));

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

	private double round(double value) {
		return Math.floor(value * significantDigits) / significantDigits;
	}
}
