/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.builder.copy.ShallowCopyBuilder;
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
import org.citygml4j.util.walker.GeometryWalker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SemanticSurfaceCollector {
	private final SurfaceWalker walker;

	public SemanticSurfaceCollector(AbstractCityObject parent) {
		walker = new SurfaceWalker(parent);
	}

	public void collectSurfaces(AbstractCityObject boundarySurface, int minLod, int maxLod) {
		LodRepresentation lods = boundarySurface.getLodRepresentation();
		for (int lod = minLod; lod <= maxLod; lod++) {
			if (lods.isSetGeometry(lod)) {
				walker.lod = lod;
				for (GeometryProperty<?> geometryProperty : lods.getGeometry(lod))
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
				properties.add(property);
			}
		}

		return properties;
	}

	private static final class SurfaceWalker extends GeometryWalker {
		private final Map<Integer, List<AbstractSurface>> surfaces = new HashMap<>();
		private final ShallowCopyBuilder copyBuilder = new ShallowCopyBuilder();
		private final Set<String> parentGeometryIds = new HashSet<>();
		private int lod;

		SurfaceWalker(AbstractCityObject parent) {
			// we initialize the walker by collecting the gml:ids of all geometry objects that are stored inline
			// or are referenced from one of the spatial properties of the parent feature.
			GeometryWalker walker = new GeometryWalker() {
				@Override
				public void visit(AbstractGeometry geometry) {
					if (geometry.isSetId())
						parentGeometryIds.add(geometry.getId());

					super.visit(geometry);
				}

				@Override
				public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
					if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)) {
						AbstractGeometry geometry = (AbstractGeometry) property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK);
						parentGeometryIds.add(geometry.getId());
					} else
						super.visit(property);
				}
			};

			LodRepresentation lods = parent.getLodRepresentation();
			for (int lod = 2; lod < 4; lod++) {
				if (lods.isSetGeometry(lod)) {
					for (GeometryProperty<?> geometryProperty : lods.getGeometry(lod))
						walker.visit(geometryProperty);
				}
			}
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

		@Override
		public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
			if (!property.isSetGeometry() && property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)) {
				// if the boundary surface references a remote geometry object, then the geometry object shall still
				// be classified as semantic surface. It therefore needs to be a child of this boundary surface.
				// In order to change its parent property, we create a shallow copy of the geometry.
				AbstractGeometry geometry = (AbstractGeometry) property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK);
				geometry = ((AbstractGeometry) geometry.copy(copyBuilder));
				geometry.setParent(property);
				geometry.accept(this);
			} else
				super.visit(property);
		}

		private void collect(AbstractSurface surface) {
			// we only collect the boundary surface geometry it is not already stored inline or referenced from
			// one of the spatial properties of the parent feature.
			if (!surface.isSetId() || !parentGeometryIds.contains(surface.getId()))
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
