/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.geometry.serializer;

import org.citygml4j.cityjson.adapter.geometry.MultiCurveProvider;
import org.citygml4j.cityjson.adapter.geometry.MultiSurfaceProvider;
import org.citygml4j.cityjson.model.core.ExtendedSpaceGeometry;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.construction.AbstractFillingSurface;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.AbstractSpace;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.core.visitor.ObjectWalker;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.gml.model.geometry.primitives.*;
import org.xmlobjects.model.Child;

import java.util.*;
import java.util.function.Consumer;

public class SpaceGeometryBuilder {
    private final BoundaryGeometryFinder finder = new BoundaryGeometryFinder();
    private Map<Integer, MultiSurfaceProvider> multiSurfaceProviders;
    private Map<Integer, MultiCurveProvider> multiCurveProviders;

    private SpaceGeometryBuilder() {
    }

    public static SpaceGeometryBuilder newInstance() {
        return new SpaceGeometryBuilder();
    }

    public SpaceGeometryBuilder withMultiSurfaceProviders(Map<Integer, MultiSurfaceProvider> providers) {
        multiSurfaceProviders = providers;
        return this;
    }

    public SpaceGeometryBuilder withMultiCurveProviders(Map<Integer, MultiCurveProvider> providers) {
        multiCurveProviders = providers;
        return this;
    }

    public void addUnreferencedBoundaryGeometries(AbstractSpace space) {
        collectSpaceGeometries(space);
        findUnreferencedBoundaryGeometries(space);
        addUnreferencedSurfaceGeometries(space);
        addUnreferencedCurveGeometries(space);
    }

    private void collectSpaceGeometries(AbstractSpace space) {
        SpaceGeometryCollector collector = new SpaceGeometryCollector();
        GeometryInfo geometryInfo = space.getGeometryInfo();
        for (int lod : geometryInfo.getLods()) {
            collector.lod = lod;
            for (GeometryProperty<?> property : geometryInfo.getGeometries(lod)) {
                collector.visit(property);
            }
        }
    }

    private void findUnreferencedBoundaryGeometries(AbstractSpace space) {
        if (space.isSetBoundaries()) {
            for (AbstractSpaceBoundaryProperty property : space.getBoundaries()) {
                if (property.getObject() != null) {
                    AbstractSpaceBoundary boundary = property.getObject();
                    processSemanticSurface(boundary);

                    boundary.accept(new ObjectWalker() {
                        @Override
                        public void visit(AbstractFillingSurface fillingSurface) {
                            processSemanticSurface(fillingSurface);
                        }
                    });
                }
            }
        }
    }

    private void processSemanticSurface(AbstractSpaceBoundary semanticSurface) {
        finder.semanticSurface = semanticSurface;
        GeometryInfo geometryInfo = semanticSurface.getGeometryInfo();
        for (int lod : geometryInfo.getLods()) {
            finder.lod = lod;
            for (GeometryProperty<?> geometryProperty : geometryInfo.getGeometries(lod)) {
                finder.visit(geometryProperty);
            }
        }
    }

    private void addUnreferencedSurfaceGeometries(AbstractSpace space) {
        for (Map.Entry<Integer, List<AbstractSurface>> entry : finder.surfaces.entrySet()) {
            MultiSurface multiSurface = null;

            MultiSurfaceProvider provider = multiSurfaceProviders != null ?
                    multiSurfaceProviders.get(entry.getKey()) :
                    null;

            if (provider != null) {
                multiSurface = getOrSetMultiSurface(provider.get(), provider::set);
            } else {
                switch (entry.getKey()) {
                    case 0:
                        multiSurface = getOrSetMultiSurface(space.getLod0MultiSurface(), space::setLod0MultiSurface);
                        break;
                    case 1:
                        ExtendedSpaceGeometry geometry = new ExtendedSpaceGeometry();
                        multiSurface = getOrSetMultiSurface(geometry.getLod1MultiSurface(), geometry::setLod1MultiSurface);
                        space.addADEProperty(geometry);
                        break;
                    case 2:
                        multiSurface = getOrSetMultiSurface(space.getLod2MultiSurface(), space::setLod2MultiSurface);
                        break;
                    case 3:
                        multiSurface = getOrSetMultiSurface(space.getLod3MultiSurface(), space::setLod3MultiSurface);
                        break;
                }
            }

            if (multiSurface != null) {
                for (AbstractSurface surface : entry.getValue()) {
                    SurfaceProperty property = decorate(new SurfaceProperty());
                    property.setReferencedObject(surface, false);
                    multiSurface.getSurfaceMember().add(property);
                }
            }
        }
    }

    private void addUnreferencedCurveGeometries(AbstractSpace space) {
        for (Map.Entry<Integer, List<AbstractCurve>> entry : finder.curves.entrySet()) {
            MultiCurve multiCurve = null;

            MultiCurveProvider provider = multiCurveProviders != null ?
                    multiCurveProviders.get(entry.getKey()) :
                    null;

            if (provider != null) {
                multiCurve = getOrSetMultiCurve(provider.get(), provider::set);
            } else {
                switch (entry.getKey()) {
                    case 0:
                        multiCurve = getOrSetMultiCurve(space.getLod0MultiCurve(), space::setLod0MultiCurve);
                        break;
                    case 2:
                        multiCurve = getOrSetMultiCurve(space.getLod2MultiCurve(), space::setLod2MultiCurve);
                        break;
                    case 3:
                        multiCurve = getOrSetMultiCurve(space.getLod3MultiCurve(), space::setLod3MultiCurve);
                        break;
                }
            }

            if (multiCurve != null) {
                for (AbstractCurve curve : entry.getValue()) {
                    CurveProperty property = decorate(new CurveProperty());
                    property.setReferencedObject(curve, false);
                    multiCurve.getCurveMember().add(property);
                }
            }
        }
    }

    private MultiSurface getOrSetMultiSurface(MultiSurfaceProperty property, Consumer<MultiSurfaceProperty> consumer) {
        if (property == null || property.getObject() == null) {
            property = decorate(new MultiSurfaceProperty(new MultiSurface()));
            consumer.accept(property);
        }

        return property.getObject();
    }

    private MultiCurve getOrSetMultiCurve(MultiCurveProperty property, Consumer<MultiCurveProperty> consumer) {
        if (property == null || property.getObject() == null) {
            property = decorate(new MultiCurveProperty(new MultiCurve()));
            consumer.accept(property);
        }

        return property.getObject();
    }

    private <T extends GeometryProperty<?>> T decorate(T property) {
        property.getLocalProperties().set(CityJSONSerializerHelper.TEMPORARY_OBJECT, true);
        return property;
    }

    private <T extends AbstractGeometry> T decorate(T geometry, AbstractSpaceBoundary semanticSurface) {
        geometry.getLocalProperties().set(CityJSONSerializerHelper.SEMANTIC_SURFACE, semanticSurface);
        return geometry;
    }

    public void removeTemporaryInformation(AbstractSpace space) {
        for (int lod = 0; lod < 4; lod++) {
            switch (lod) {
                case 0:
                    removeTemporaryGeometries(space.getLod0MultiSurface(), space::setLod0MultiSurface);
                    removeTemporaryGeometries(space.getLod0MultiCurve(), space::setLod0MultiCurve);
                    break;
                case 1:
                    if (space.hasADEProperties()) {
                        space.getADEProperties().removeIf(ExtendedSpaceGeometry.class::isInstance);
                        if (!space.hasADEProperties()) {
                            space.setADEProperties(null);
                        }
                    }
                    break;
                case 2:
                    removeTemporaryGeometries(space.getLod2MultiSurface(), space::setLod2MultiSurface);
                    removeTemporaryGeometries(space.getLod2MultiCurve(), space::setLod2MultiCurve);
                    break;
                case 3:
                    removeTemporaryGeometries(space.getLod3MultiSurface(), space::setLod3MultiSurface);
                    removeTemporaryGeometries(space.getLod3MultiCurve(), space::setLod3MultiCurve);
                    break;
            }
        }

        if (multiSurfaceProviders != null) {
            for (MultiSurfaceProvider provider : multiSurfaceProviders.values()) {
                removeTemporaryGeometries(provider.get(), provider::set);
            }
        }

        if (multiCurveProviders != null) {
            for (MultiCurveProvider provider : multiCurveProviders.values()) {
                removeTemporaryGeometries(provider.get(), provider::set);
            }
        }

        for (Map<Integer, AbstractGeometry> geometries : finder.spaceGeometries.values()) {
            removeTemporarySemanticSurfaces(geometries.values());
        }

        for (Collection<AbstractSurface> surfaces : finder.surfaces.values()) {
            removeTemporarySemanticSurfaces(surfaces);
        }

        for (Collection<AbstractCurve> curves : finder.curves.values()) {
            removeTemporarySemanticSurfaces(curves);
        }
    }

    private void removeTemporaryGeometries(MultiSurfaceProperty property, Consumer<MultiSurfaceProperty> consumer) {
        if (property != null) {
            if (isTemporaryGeometry(property)) {
                consumer.accept(null);
            } else if (property.getObject() != null && property.getObject().isSetSurfaceMember()) {
                property.getObject().getSurfaceMember().removeIf(this::isTemporaryGeometry);
            }
        }
    }

    private void removeTemporaryGeometries(MultiCurveProperty property, Consumer<MultiCurveProperty> consumer) {
        if (property != null) {
            if (isTemporaryGeometry(property)) {
                consumer.accept(null);
            } else if (property.getObject() != null && property.getObject().isSetCurveMember()) {
                property.getObject().getCurveMember().removeIf(this::isTemporaryGeometry);
            }
        }
    }

    private boolean isTemporaryGeometry(GeometryProperty<?> property) {
        return property != null
                && property.hasLocalProperties()
                && property.getLocalProperties().contains(CityJSONSerializerHelper.TEMPORARY_OBJECT);
    }

    private void removeTemporarySemanticSurfaces(Collection<? extends AbstractGeometry> geometries) {
        for (AbstractGeometry geometry : geometries) {
            if (geometry.hasLocalProperties()) {
                geometry.getLocalProperties().remove(CityJSONSerializerHelper.SEMANTIC_SURFACE);
                if (geometry.getLocalProperties().isEmpty()) {
                    geometry.setLocalProperties(null);
                }
            }
        }
    }

    private final class SpaceGeometryCollector extends ObjectWalker {
        int lod;

        @Override
        public void visit(AbstractGeometry geometry) {
            if (geometry.getId() != null) {
                finder.spaceGeometries.computeIfAbsent(geometry.getId(), v -> new HashMap<>()).put(lod, geometry);

                AbstractFeature parent = geometry.getParent(AbstractFeature.class);
                if (parent instanceof AbstractSpaceBoundary) {
                    decorate(geometry, (AbstractSpaceBoundary) parent);
                }
            }
        }
    }

    private final class BoundaryGeometryFinder extends ObjectWalker {
        final Map<String, Map<Integer, AbstractGeometry>> spaceGeometries = new HashMap<>();
        final Map<Integer, List<AbstractSurface>> surfaces = new HashMap<>();
        final Map<Integer, List<AbstractCurve>> curves = new HashMap<>();

        AbstractSpaceBoundary semanticSurface;
        int lod;

        @Override
        public void visit(Polygon polygon) {
            addSurface(polygon);
        }

        @Override
        public void visit(AbstractSimplePolygon simplePolygon) {
            addSurface(simplePolygon);
        }

        @Override
        public void visit(OrientableSurface orientableSurface) {
            addSurface(orientableSurface);
        }

        @Override
        public void visit(Surface surface) {
            addSurface(surface);
        }

        @Override
        public void visit(LineString lineString) {
            addCurve(lineString);
        }

        @Override
        public void visit(OrientableCurve orientableCurve) {
            addCurve(orientableCurve);
        }

        @Override
        public void visit(Curve curve) {
            addCurve(curve);
        }

        private void addSurface(AbstractSurface surface) {
            if (isNotReferenced(surface)) {
                surfaces.computeIfAbsent(lod, v -> new ArrayList<>()).add(decorate(surface, semanticSurface));
            }
        }

        private void addCurve(AbstractCurve curve) {
            if (isNotReferenced(curve)) {
                curves.computeIfAbsent(lod, v -> new ArrayList<>()).add(decorate(curve, semanticSurface));
            }
        }

        private boolean isNotReferenced(Child child) {
            do {
                if (child instanceof AbstractGeometry) {
                    AbstractGeometry geometry = (AbstractGeometry) child;
                    if (geometry.getId() != null) {
                        AbstractGeometry spaceGeometry = spaceGeometries.getOrDefault(geometry.getId(), Collections.emptyMap()).get(lod);
                        if (spaceGeometry != null) {
                            decorate(spaceGeometry, semanticSurface);
                            return false;
                        }
                    }
                }
            } while ((child = child.getParent()) != null && !(child instanceof AbstractFeature));

            return true;
        }
    }
}
