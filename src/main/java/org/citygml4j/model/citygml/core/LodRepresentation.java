/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.gml.feature.SpatialRepresentation;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

import java.util.Collections;
import java.util.List;

public class LodRepresentation extends SpatialRepresentation {
	private final static LodRepresentation EMPTY_REPRESENTATION = new LodRepresentation();

	public static LodRepresentation emptyRepresentation() {
		return EMPTY_REPRESENTATION;
	}

	public void addRepresentation(int lod, AssociationByRepOrRef<? extends AbstractGML> property) {
		if (lod >= 0)
			add(lod, property);
	}

	public void addRepresentation(int lod, GeometryProperty<? extends AbstractGeometry> property) {
		if (lod >= 0)
			add(lod, property);
	}

	public void addRepresentation(int lod, ImplicitRepresentationProperty property) {
		if (lod >= 0)
			add(lod, property);
	}

	public boolean isSetRepresentation(int lod) {
		return lod >= 0 && super.isSetRepresentation(lod);
	}

	public boolean hasLodRepresentations() {
		return !getLods().isEmpty();
	}

	public boolean hasNonLodRepresentation() {
		return super.isSetRepresentation(-1);
	}

	public List<AssociationByRepOrRef<? extends AbstractGML>> getRepresentation(int lod) {
		return lod >= 0 ? super.getRepresentation(lod) : Collections.emptyList();
	}

	public List<AssociationByRepOrRef<? extends AbstractGML>> getNonLodRepresentation() {
		return super.getRepresentation(-1);
	}

	public boolean isSetGeometry(int lod) {
		return lod >= 0 && super.isSetGeometry(lod);
	}

	public boolean hasLodGeometries() {
		return getLods().stream().anyMatch(this::isSetGeometry);
	}

	public boolean hasNonLodGeometry() {
		return super.isSetGeometry(-1);
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getGeometry(int lod) {
		return lod >= 0 ? super.getGeometry(lod) : Collections.emptyList();
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getNonLodGeometry() {
		return super.getGeometry(-1);
	}

	public boolean isSetImplicitGeometry(int lod) {
		return lod >= 0 && super.isSetImplicitGeometry(lod);
	}

	public boolean hasLodImplicitGeometries() {
		return getLods().stream().anyMatch(this::isSetImplicitGeometry);
	}

	public boolean hasNonLodImplicitGeometry() {
		return super.isSetImplicitGeometry(-1);
	}

	public List<ImplicitRepresentationProperty> getImplicitGeometry(int lod) {
		return lod >= 0 ? super.getImplicitGeometry(lod) : Collections.emptyList();
	}

	public List<ImplicitRepresentationProperty> getNonLodImplicitGeometry() {
		return super.getImplicitGeometry(-1);
	}
}
