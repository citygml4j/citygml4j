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
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.walker.GMLWalker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SemanticSurfaceCollector {
	private final SurfaceWalker walker = new SurfaceWalker();

	public void collectSurfaces(AbstractCityObject cityObject, int minLod, int maxLod) {
		LodRepresentation lodRepresentation = cityObject.getLodRepresentation();
		for (int lod = minLod; lod <= maxLod; lod++) {
			if (lodRepresentation.isSetGeometry(lod)) {
				walker.lod = lod;
				for (GeometryProperty<?> geometryProperty : lodRepresentation.getGeometry(lod))
					walker.visit(geometryProperty);
			}
		}
	}

	public void collectSurfaces(List<? extends FeatureProperty<?>> properties, int minLod, int maxLod) {
		if (properties != null) {
			for (FeatureProperty<?> property : properties) {
				if (property.getFeature() instanceof AbstractCityObject)
					collectSurfaces((AbstractCityObject) property.getFeature(), minLod, maxLod);
			}
		}
	}

	public boolean hasSurfaces(int lod) {
		return walker.surfaces.containsKey(lod);
	}

	public void assignSurfaces(GeometryPropertyGetter getter, MultiSurfacePropertySetter setter, int lod) {
		MultiSurface multiSurface;

		GeometryProperty<?> property = getter.get();
		if (property != null && property.isSetGeometry() && property.getGeometry() instanceof MultiSurface)
			multiSurface = (MultiSurface) property.getGeometry();
		else {
			multiSurface = new MultiSurface();
			multiSurface.setLocalProperty(CityJSONMarshaller.GEOMETRY_DUMMY, true);
			setter.set(new MultiSurfaceProperty(multiSurface));
		}

		multiSurface.getSurfaceMember().addAll(getSurfaceProperties(lod));
	}

	public MultiSurface getSurfaces(int lod) {
		MultiSurface multiSurface = new MultiSurface();
		multiSurface.setLocalProperty(CityJSONMarshaller.GEOMETRY_DUMMY, true);
		multiSurface.getSurfaceMember().addAll(getSurfaceProperties(lod));

		return multiSurface;
	}

	public void clean(GeometryPropertyGetter getter, GeometryPropertyUnsetter unsetter) {
		GeometryProperty<?> property = getter.get();
		if (property != null && property.isSetGeometry() && property.getGeometry() instanceof MultiSurface) {
			MultiSurface multiSurface = (MultiSurface) property.getGeometry();
			if (multiSurface.hasLocalProperty(CityJSONMarshaller.GEOMETRY_DUMMY))
				unsetter.unset();
			else
				multiSurface.getSurfaceMember().removeIf(p -> p.hasLocalProperty(CityJSONMarshaller.GEOMETRY_DUMMY));
		}
	}

	private List<SurfaceProperty> getSurfaceProperties(int lod) {
		List<SurfaceProperty> properties = new ArrayList<>();

		Collection<AbstractSurface> surfaces = walker.surfaces.get(lod);
		if (surfaces != null) {
			for (AbstractSurface surface : surfaces) {
				SurfaceProperty property = new SurfaceProperty();
				property.setLocalProperty(CityJSONMarshaller.GEOMETRY_DUMMY, true);
				property.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK, surface);
				surface.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET, true);
				properties.add(property);
			}
		}

		return properties;
	}

	private final class SurfaceWalker extends GMLWalker {
		private int lod;
		private Map<Integer, List<AbstractSurface>> surfaces = new HashMap<>();

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
			if (!surface.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET))
				surfaces.computeIfAbsent(lod, k -> new ArrayList<>()).add(surface);
		}
	}

	@FunctionalInterface
	public interface GeometryPropertyGetter {
		GeometryProperty<? extends AbstractGeometry> get();
	}

	@FunctionalInterface
	public interface MultiSurfacePropertySetter {
		void set(MultiSurfaceProperty property);
	}

	@FunctionalInterface
	public interface GeometryPropertyUnsetter {
		void unset();
	}
}
