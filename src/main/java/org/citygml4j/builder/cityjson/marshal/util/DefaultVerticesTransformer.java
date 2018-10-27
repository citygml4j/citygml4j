/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
