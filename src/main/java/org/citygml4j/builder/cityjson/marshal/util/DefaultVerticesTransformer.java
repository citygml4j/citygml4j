package org.citygml4j.builder.cityjson.marshal.util;

import org.citygml4j.binding.cityjson.geometry.TransformType;

import java.util.Arrays;
import java.util.List;

public class DefaultVerticesTransformer implements VerticesTransformer {
	private int significantDigits = 3;
	
	public DefaultVerticesTransformer withSignificantDigits(int significantDigits) {
		if (significantDigits > 0)
			this.significantDigits = significantDigits;
		
		return this;
	}
	
	public int getSignificantDigits() {
		return significantDigits;
	}
	
	@Override
	public TransformType applyTransformation(List<List<Double>> vertices) {
		Double[] translate = new Double[] {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};

		// calculate translation as minimum x, y, z
		for (List<Double> vertex : vertices) {
			for (int i = 0; i < vertex.size(); i++) {
				double value = vertex.get(i);
				if (value < translate[i])
					translate[i] = value;
			}
		}
		
		// apply translation and scale factor
		double scale = Math.pow(10, significantDigits);		
		for (List<Double> vertex : vertices) {
			for (int i = 0; i < vertex.size(); i++)
				vertex.set(i, (double)(int)((vertex.get(i) - translate[i]) * scale));
		}
		
		scale = 1 / scale;
		TransformType transform = new TransformType();
		transform.setTranslate(Arrays.asList(translate));		
		transform.setScale(Arrays.asList(scale, scale, scale));
		
		return transform;
	}

}
