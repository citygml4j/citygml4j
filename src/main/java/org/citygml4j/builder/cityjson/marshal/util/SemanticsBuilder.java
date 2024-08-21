/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.util.child.ChildInfo;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class SemanticsBuilder {
	private final AbstractCityObject parent;
	private final CityGMLMarshaller cityGML;
	private final CityJSON cityJSON;
	private final List<SemanticsType> surfaces = new ArrayList<>();
	private final Map<AbstractCityObject, Integer> cityObjects = new IdentityHashMap<>();
	private final ChildInfo childInfo = new ChildInfo();
	
	public SemanticsBuilder(AbstractCityObject parent, CityGMLMarshaller cityGML, CityJSON cityJSON) {
		this.parent = parent;
		this.cityGML = cityGML;
		this.cityJSON = cityJSON;
	}
	
	public Integer addSemanticSurface(AbstractCityObject cityObject) {
		if (cityObject == null)
			return null;
		
		Integer index = null;
		if (!cityObjects.containsKey(cityObject)) {
			SemanticsType semantics = cityGML.marshalSemanticSurface(cityObject, cityJSON);
			if (semantics != null) {
				index = surfaces.size();
				surfaces.add(semantics);

				// add parent and children relationships
				Child child = cityObject;
				do  {
					child = childInfo.getParentCityObject(child);
					Integer parentIndex = cityObjects.get(child);
					if (parentIndex != null && parentIndex < surfaces.size()) {
						SemanticsType parent = surfaces.get(parentIndex);
						parent.addChild(index);
						semantics.setParent(parentIndex);
						break;
					}
				} while (child != null && child != parent);
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
