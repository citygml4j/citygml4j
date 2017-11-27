package org.citygml4j.builder.json.marshal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleTextureVerticesBuilder implements TextureVerticesBuilder {
	private final Map<Integer, Integer> indexes = new ConcurrentHashMap<>();
	private final TreeMap<Integer, List<Double>> vertices = new TreeMap<>();
	private final AtomicInteger counter = new AtomicInteger(0);

	private double significantDigits = Math.pow(10, 5);
	
	public SimpleTextureVerticesBuilder withSignificantDigits(int significantDigits) {
		if (significantDigits > 0)
			this.significantDigits = Math.pow(10, significantDigits);
		
		return this;
	}

	public int getSignificantDigits() {
		return (int)Math.log10(significantDigits);
	}
	
	@Override
	public List<Integer> addTextureVertices(List<Double> vertices) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < vertices.size(); i += 2) {
			List<Double> vertex = vertices.subList(i, i + 2);
			int key = Objects.hash(round(vertex.get(0)), round(vertex.get(1)));

			Integer index = indexes.get(key);
			if (index == null) {				
				Integer tmp = counter.getAndIncrement();				
				index = indexes.putIfAbsent(key, tmp);
				if (index == null)
					index = tmp;
				
				this.vertices.put(index, vertex);
			}

			result.add(index);
		}
		
		return result;
	}

	@Override
	public List<List<Double>> build() {
		List<List<Double>> result = new ArrayList<>(vertices.values());
		indexes.clear();
		vertices.clear();
		
		return result;
	}

	private double round(double value) {
		return Math.floor(value * significantDigits) / significantDigits;
	}
}
