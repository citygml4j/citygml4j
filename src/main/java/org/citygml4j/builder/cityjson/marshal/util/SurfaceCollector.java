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

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.util.walker.GeometryWalker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurfaceCollector extends GeometryWalker {
	private int lod;
	private Map<Integer, List<AbstractSurface>> surfaces = new HashMap<>();

	public boolean hasSurfaces() {
		return !surfaces.isEmpty();
	}
	
	public Collection<AbstractSurface> getSurfaces(int lod) {
		return surfaces.get(lod);
	}
	
	public void setLod(int lod) {
		this.lod = lod;
	}
	
	@Override
	public void visit(CompositeSurface surface) {
		collect(surface);
	}

	@Override
	public void visit(OrientableSurface surface) {
		collect(surface);
	}

	@Override
	public void visit(Surface surface) {
		collect(surface);
	}

	@Override
	public void visit(Polygon surface) {
		collect(surface);
	}

	private void collect(AbstractSurface surface) {
		if (!surface.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET)) {
			List<AbstractSurface> tmp = surfaces.get(lod);
			if (tmp == null) {
				tmp = new ArrayList<>();
				surfaces.put(lod, tmp);
			}

			tmp.add(surface);
		}
	}
}
