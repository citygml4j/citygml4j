/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class SemanticsBuilder {
	private final CityGMLMarshaller citygml;
	private final List<SemanticsType> surfaces = new ArrayList<>();
	private final Map<AbstractCityObject, Integer> cityObjects = new IdentityHashMap<>();
	
	public SemanticsBuilder(CityGMLMarshaller citygml) {
		this.citygml = citygml;
	}
	
	public Integer addSemanticSurface(AbstractCityObject cityObject) {
		if (cityObject == null)
			return null;
		
		Integer index = null;
		if (!cityObjects.containsKey(cityObject)) {
			SemanticsType semantics = citygml.marshalSemantics(cityObject);
			if (semantics != null) {
				index = surfaces.size();
				surfaces.add(semantics);
			}
			
			cityObjects.put(cityObject, index);
		} else
			index = cityObjects.get(cityObject);

		return index;
	}

	public List<SemanticsType> getSurfaces() {
		return surfaces;
	}
	
}
