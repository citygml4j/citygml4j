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

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class LodRepresentation {
	private List<GeometryProperty<? extends AbstractGeometry>> lod0Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod1Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod2Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod3Geometry;
	private List<GeometryProperty<? extends AbstractGeometry>> lod4Geometry;

	public List<GeometryProperty<? extends AbstractGeometry>> getLod0Geometry() {
		if (lod0Geometry == null)
			lod0Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod0Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod1Geometry() {
		if (lod1Geometry == null)
			lod1Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod1Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod2Geometry() {
		if (lod2Geometry == null)
			lod2Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod2Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod3Geometry() {
		if (lod3Geometry == null)
			lod3Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod3Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod4Geometry() {
		if (lod4Geometry == null)
			lod4Geometry = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod4Geometry;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLodGeometry(int lod) {
		switch (lod) {
		case 0:
			return getLod0Geometry();
		case 1:
			return getLod1Geometry();
		case 2:
			return getLod2Geometry();
		case 3:
			return getLod3Geometry();
		case 4:
			return getLod4Geometry();
		default:
			return null;
		}
	}

	public boolean isSetLod0Geometry() {
		return lod0Geometry != null && !lod0Geometry.isEmpty();
	}

	public boolean isSetLod1Geometry() {
		return lod1Geometry != null && !lod1Geometry.isEmpty();
	}

	public boolean isSetLod2Geometry() {
		return lod2Geometry != null && !lod2Geometry.isEmpty();
	}

	public boolean isSetLod3Geometry() {
		return lod3Geometry != null && !lod3Geometry.isEmpty();
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null && !lod4Geometry.isEmpty();
	}

	public boolean isSetLodGeometry(int lod) {
		switch (lod) {
		case 0:
			return isSetLod0Geometry();
		case 1:
			return isSetLod1Geometry();
		case 2:
			return isSetLod2Geometry();
		case 3:
			return isSetLod3Geometry();
		case 4:
			return isSetLod4Geometry();
		default:
			return false;
		}
	}

	public boolean hasGeometry() {
		return isSetLod0Geometry()
				|| isSetLod1Geometry()
				|| isSetLod2Geometry()
				|| isSetLod3Geometry()
				|| isSetLod4Geometry();
	}

}
