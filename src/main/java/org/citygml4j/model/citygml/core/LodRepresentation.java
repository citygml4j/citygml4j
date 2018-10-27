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
package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LodRepresentation {
	private Map<Integer, List<AssociationByRepOrRef<? extends AbstractGML>>> lods = new HashMap<>();

	public void addRepresentation(int lod, AssociationByRepOrRef<? extends AbstractGML> property) {
		if (property != null) {
			List<AssociationByRepOrRef<? extends AbstractGML>> tmp = lods.get(lod);
			if (tmp == null) {
				tmp = new ArrayList<>();
				lods.put(lod, tmp);
			}

			tmp.add(property);
		}
	}

	public List<AssociationByRepOrRef<? extends AbstractGML>> getRepresentation(int lod) {
		List<AssociationByRepOrRef<? extends AbstractGML>> tmp = lods.get(lod);
		return tmp != null ? tmp : Collections.emptyList();
	}

	public boolean isSetRepresentation(int lod) {
		return lods.containsKey(lod);
	}

	public boolean hasRepresentations() {
		return !lods.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public List<GeometryProperty<? extends AbstractGeometry>> getGeometry(int lod) {
		List<AssociationByRepOrRef<? extends AbstractGML>> tmp = lods.get(lod);
		return tmp != null ? tmp.stream().filter(GeometryProperty.class::isInstance).map(p -> (GeometryProperty<? extends AbstractGeometry>)p).collect(Collectors.toList()) 
				: Collections.emptyList();
	}

	public boolean isSetGeometry(int lod) {
		List<AssociationByRepOrRef<? extends AbstractGML>> tmp = lods.get(lod);
		return tmp != null ? tmp.stream().filter(GeometryProperty.class::isInstance).findFirst().isPresent() : false;
	}

	public boolean hasGeometries() {
		for (int lod : lods.keySet()) {
			if (isSetGeometry(lod))
				return true;
		}

		return false;
	}

	public List<ImplicitRepresentationProperty> getImplicitGeometry(int lod) {
		List<AssociationByRepOrRef<? extends AbstractGML>> tmp = lods.get(lod);
		return tmp != null ? tmp.stream().filter(ImplicitRepresentationProperty.class::isInstance).map(ImplicitRepresentationProperty.class::cast).collect(Collectors.toList()) 
				: Collections.emptyList();
	}

	public boolean isSetImplicitGeometry(int lod) {
		List<AssociationByRepOrRef<? extends AbstractGML>> tmp = lods.get(lod);
		return tmp != null ? tmp.stream().filter(ImplicitRepresentationProperty.class::isInstance).findFirst().isPresent() : false;
	}

	public boolean hasImplicitGeometries() {
		for (int lod : lods.keySet()) {
			if (isSetImplicitGeometry(lod))
				return true;
		}

		return false;
	}

}
