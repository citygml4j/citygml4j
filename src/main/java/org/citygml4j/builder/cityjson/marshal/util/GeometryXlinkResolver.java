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
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.AppearanceModuleComponent;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.util.walker.GMLWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeometryXlinkResolver {
	private enum ResolverState {
		GET_XLINKS,
		GET_GEOMETRY
	};

	public void resolve(AbstractGML object) {
		Walker walker = new Walker();
		object.accept(walker);

		if (!walker.properties.isEmpty()) {
			walker.state = ResolverState.GET_GEOMETRY;
			object.accept(walker);
		}
	}

	private class Walker extends GMLWalker {
		private ResolverState state = ResolverState.GET_XLINKS;
		private Map<String, List<GeometryProperty<?>>> properties = new HashMap<>();

		@Override
		public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
			if (state == ResolverState.GET_XLINKS && !property.isSetGeometry() && property.isSetHref()) {
				String key = clipGMLId(property.getHref());
				List<GeometryProperty<?>> properties = this.properties.get(key);
				if (properties == null) {
					properties = new ArrayList<>();
					this.properties.put(key, properties);
				}
				
				properties.add(property);
			} 

			super.visit(property);			
		}

		@Override
		public void visit(AbstractGeometry geometry) {
			if (state == ResolverState.GET_GEOMETRY && geometry.isSetId()) {
				List<GeometryProperty<?>> properties = this.properties.get(geometry.getId());
				if (properties != null) {
					for (GeometryProperty<?> property : properties) {
						if (property.getAssociableClass().isAssignableFrom(geometry.getClass())) {
							property.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK, geometry);
							geometry.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET, true);							
						}
					}
				}
			}
			
			super.visit(geometry);
		}

		@Override
		public void visit(ADEGenericElement ade) {
			// nothing to do here
		}

		@Override
		public <T extends AbstractFeature> void visit(FeatureProperty<T> property) {
			if (!(property.getFeature() instanceof AppearanceModuleComponent))
				super.visit(property);
		}
		
		private String clipGMLId(String target) {
			return target.replaceAll("^.*?#+?", "");
		}
	}
}
