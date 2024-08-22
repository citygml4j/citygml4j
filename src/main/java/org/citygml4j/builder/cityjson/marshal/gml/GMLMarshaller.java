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
package org.citygml4j.builder.cityjson.marshal.gml;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.SemanticsBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.appearance.*;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.*;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.complexes.*;
import org.citygml4j.model.gml.geometry.primitives.*;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;
import org.citygml4j.util.walker.GeometryWalker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class GMLMarshaller {
    private final ReentrantLock lock = new ReentrantLock();
    private final CityJSONMarshaller json;
    private final Supplier<VerticesBuilder> verticesBuilder;
    private final ChildInfo childInfo;
    private BiFunctionTypeMapper<CityJSON, AbstractGeometryObjectType> typeMapper;

    public GMLMarshaller(CityJSONMarshaller json, Supplier<VerticesBuilder> verticesBuilder) {
        this.json = json;
        this.verticesBuilder = verticesBuilder;
        childInfo = new ChildInfo();
    }

    private BiFunctionTypeMapper<CityJSON, AbstractGeometryObjectType> getTypeMapper() {
        if (typeMapper == null) {
            lock.lock();
            try {
                if (typeMapper == null) {
                    typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractGeometryObjectType>create()
                            .with(Point.class, this::marshalPoint)
                            .with(MultiPoint.class, this::marshalMultiPoint)
                            .with(Curve.class, this::marshalMultiLineString)
                            .with(OrientableCurve.class, this::marshalMultiLineString)
                            .with(CompositeCurve.class, this::marshalMultiLineString)
                            .with(LineString.class, this::marshalMultiLineString)
                            .with(MultiCurve.class, this::marshalMultiLineString)
                            .with(Surface.class, this::marshalSurface)
                            .with(OrientableSurface.class, this::marshalSurface)
                            .with(Polygon.class, this::marshalSurface)
                            .with(TriangulatedSurface.class, this::marshalTriangulatedSurface)
                            .with(Tin.class, this::marshalTin)
                            .with(MultiSurface.class, this::marshalMultiSurface)
                            .with(CompositeSurface.class, this::marshalCompositeSurface)
                            .with(Solid.class, this::marshalSolid)
                            .with(CompositeSolid.class, this::marshalCompositeSolid)
                            .with(MultiSolid.class, this::marshalMultiSolid);
                }
            } finally {
                lock.unlock();
            }
        }

        return typeMapper;
    }

    public AbstractGeometryObjectType marshal(AbstractGeometry src, CityJSON cityJSON) {
        return getTypeMapper().apply(src, cityJSON);
    }

    public AbstractCityObjectType marshalFeatureProperty(FeatureProperty<? extends AbstractFeature> featureProperty, CityJSON cityJSON) {
        return featureProperty.isSetFeature() ? json.getCityGMLMarshaller().marshal(featureProperty.getFeature(), cityJSON) : null;
    }

    public void marshalPoint(Point src, MultiPointType dest, CityJSON cityJSON) {
        List<Double> vertex = src.toList3d();
        if (!vertex.isEmpty())
            dest.addPoints(verticesBuilder.get().addVertices(vertex));
    }

    public MultiPointType marshalPoint(Point src, CityJSON cityJSON) {
        MultiPointType dest = new MultiPointType();
        marshalPoint(src, dest, cityJSON);

        return dest;
    }

    public void marshalMultiPoint(MultiPoint src, MultiPointType dest, CityJSON cityJSON) {
        if (src.isSetPointMember()) {
            for (PointProperty pointProperty : src.getPointMember())
                if (pointProperty.isSetPoint()) {
                    List<Double> vertex = pointProperty.getPoint().toList3d();
                    if (!vertex.isEmpty())
                        dest.addPoints(verticesBuilder.get().addVertices(vertex));
                }

        } else if (src.isSetPointMembers()) {
            PointArrayProperty pointArrayProperty = src.getPointMembers();
            for (Point point : pointArrayProperty.getPoint()) {
                List<Double> vertex = point.toList3d();
                if (!vertex.isEmpty())
                    dest.addPoints(verticesBuilder.get().addVertices(vertex));
            }
        }
    }

    public MultiPointType marshalMultiPoint(MultiPoint src, CityJSON cityJSON) {
        MultiPointType dest = new MultiPointType();
        marshalMultiPoint(src, dest, cityJSON);

        return dest;
    }

    public void marshalMultiLineString(AbstractCurve src, MultiLineStringType dest, CityJSON cityJSON) {
        MultiLineStringBuilder builder = new MultiLineStringBuilder();
        builder.process(src, dest);
    }

    public MultiLineStringType marshalMultiLineString(Curve src, CityJSON cityJSON) {
        MultiLineStringType dest = new MultiLineStringType();
        marshalMultiLineString(src, dest, cityJSON);

        return dest;
    }

    public MultiLineStringType marshalMultiLineString(OrientableCurve src, CityJSON cityJSON) {
        MultiLineStringType dest = new MultiLineStringType();
        marshalMultiLineString(src, dest, cityJSON);

        return dest;
    }

    public MultiLineStringType marshalMultiLineString(CompositeCurve src, CityJSON cityJSON) {
        MultiLineStringType dest = new MultiLineStringType();
        marshalMultiLineString(src, dest, cityJSON);

        return dest;
    }

    public MultiLineStringType marshalMultiLineString(LineString src, CityJSON cityJSON) {
        MultiLineStringType dest = new MultiLineStringType();
        marshalMultiLineString(src, dest, cityJSON);

        return dest;
    }

    public MultiLineStringType marshalMultiLineString(List<GeometricComplexProperty> src, CityJSON cityJSON) {
        MultiLineStringType dest = new MultiLineStringType();
        for (GeometricComplexProperty property : src) {
            if (property.isSetCompositeCurve())
                marshalMultiLineString(property.getCompositeCurve(), dest, cityJSON);
            else if (property.isSetGeometricComplex()) {
                GeometricComplex complex = property.getGeometricComplex();
                if (complex.isSetElement()) {
                    for (GeometricPrimitiveProperty element : complex.getElement()) {
                        if (element.getGeometricPrimitive() instanceof AbstractCurve) {
                            AbstractCurve curve = (AbstractCurve) element.getGeometricPrimitive();
                            marshalMultiLineString(curve, dest, cityJSON);
                        }
                    }
                }
            }
        }

        return !dest.getLineStrings().isEmpty() ? dest : null;
    }

    public void marshalMultiLineString(MultiCurve src, MultiLineStringType dest, CityJSON cityJSON) {
        MultiLineStringBuilder builder = new MultiLineStringBuilder();
        builder.process(src, dest);
    }

    public MultiLineStringType marshalMultiLineString(MultiCurve src, CityJSON cityJSON) {
        MultiLineStringType dest = new MultiLineStringType();
        marshalMultiLineString(src, dest, cityJSON);

        return dest;
    }

    public void marshalSurface(AbstractSurface src, CompositeSurfaceType dest, CityJSON cityJSON) {
        SurfaceCollectionBuilder surfaceBuilder = new SurfaceCollectionBuilder();
        SemanticsBuilder semanticsBuilder = new SemanticsBuilder(childInfo.getParentCityObject(src), json.getCityGMLMarshaller(), cityJSON);
        surfaceBuilder.process(src, dest, semanticsBuilder, true);

        if (dest.isSetSemantics())
            dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());
    }

    public CompositeSurfaceType marshalSurface(Surface src, CityJSON cityJSON) {
        CompositeSurfaceType dest = new CompositeSurfaceType();
        marshalSurface(src, dest, cityJSON);

        return dest;
    }

    public CompositeSurfaceType marshalSurface(OrientableSurface src, CityJSON cityJSON) {
        CompositeSurfaceType dest = new CompositeSurfaceType();
        marshalSurface(src, dest, cityJSON);

        return dest;
    }

    public CompositeSurfaceType marshalSurface(Polygon src, CityJSON cityJSON) {
        CompositeSurfaceType dest = new CompositeSurfaceType();
        marshalSurface(src, dest, cityJSON);

        return dest;
    }

    public CompositeSurfaceType marshalTriangulatedSurface(TriangulatedSurface src, CityJSON cityJSON) {
        return marshalSurface(src, cityJSON);
    }

    public CompositeSurfaceType marshalTin(Tin src, CityJSON cityJSON) {
        return marshalTriangulatedSurface(src, cityJSON);
    }

    public void marshalSurfaceCollection(AbstractGeometry src, AbstractSurfaceCollectionType dest, CityJSON cityJSON) {
        SurfaceCollectionBuilder surfaceBuilder = new SurfaceCollectionBuilder();
        SemanticsBuilder semanticsBuilder = new SemanticsBuilder(childInfo.getParentCityObject(src), json.getCityGMLMarshaller(), cityJSON);
        surfaceBuilder.process(src, dest, semanticsBuilder, true);

        if (dest.isSetSemantics())
            dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());
    }

    public MultiSurfaceType marshalMultiSurface(MultiSurface src, CityJSON cityJSON) {
        MultiSurfaceType dest = new MultiSurfaceType();
        marshalSurfaceCollection(src, dest, cityJSON);

        return dest;
    }

    public CompositeSurfaceType marshalCompositeSurface(CompositeSurface src, CityJSON cityJSON) {
        CompositeSurfaceType dest = new CompositeSurfaceType();
        marshalSurfaceCollection(src, dest, cityJSON);

        return dest;
    }

    public void marshalSolid(Solid src, SolidType dest, SemanticsBuilder semanticsBuilder, boolean collapseMaterialValues) {
        SurfaceCollectionBuilder surfaceBuilder = new SurfaceCollectionBuilder();
        int index = 0;

        if (src.isSetExterior() && src.getExterior().getSurface() instanceof CompositeSurface) {
            List<CompositeSurface> shells = new ArrayList<>();
            shells.add((CompositeSurface) src.getExterior().getSurface());

            if (src.isSetInterior()) {
                for (SurfaceProperty property : src.getInterior()) {
                    if (property.getSurface() instanceof CompositeSurface)
                        shells.add((CompositeSurface) property.getSurface());
                }
            }

            for (CompositeSurface shell : shells) {
                CompositeSurfaceType shellType = new CompositeSurfaceType();
                surfaceBuilder.process(shell, shellType, semanticsBuilder, false);

                if (!shellType.getSurfaces().isEmpty()) {
                    dest.addShell(shellType.getSurfaces());

                    if (shellType.isSetSemantics()) {
                        SolidSemanticsObject semantics = dest.getSemantics();
                        if (semantics == null) {
                            semantics = new SolidSemanticsObject();
                            dest.setSemantics(semantics);
                        }

                        // add null values for non-semantic surfaces
                        appendNulls(semantics, index);
                        semantics.addValues(shellType.getSemantics().getValues());
                    }

                    if (shellType.isSetMaterial()) {
                        for (SurfaceCollectionMaterialObject object : shellType.getMaterial()) {
                            SolidMaterialObject material = dest.getMaterial(object.getTheme());
                            if (material == null) {
                                material = new SolidMaterialObject(object.getTheme());
                                dest.addMaterial(material);
                            }

                            // add null values for non-colored surfaces
                            appendNulls(material, index);
                            material.addValue(object.getValues());
                        }
                    }

                    if (shellType.isSetTexture()) {
                        for (SurfaceCollectionTextureObject object : shellType.getTexture()) {
                            SolidTextureObject texture = dest.getTexture(object.getTheme());
                            if (texture == null) {
                                texture = new SolidTextureObject(object.getTheme());
                                dest.addTexture(texture);
                            }

                            // add null values for non-textured surfaces
                            appendNulls(texture, index);
                            texture.addValue(object.getValues());
                        }
                    }

                    index++;
                } else if (index == 0)
                    break;
            }

            postprocess(dest, index, collapseMaterialValues);
        }
    }

    public SolidType marshalSolid(Solid src, CityJSON cityJSON) {
        SolidType dest = new SolidType();
        SemanticsBuilder semanticsBuilder = new SemanticsBuilder(childInfo.getParentCityObject(src), json.getCityGMLMarshaller(), cityJSON);
        marshalSolid(src, dest, semanticsBuilder, true);

        if (dest.isSetSemantics())
            dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());

        return dest;
    }

    public void marshalSolidCollection(AbstractGeometry src, AbstractSolidCollectionType dest, CityJSON cityJSON) {
        SolidCollectionBuilder builder = new SolidCollectionBuilder();
        SemanticsBuilder semanticsBuilder = new SemanticsBuilder(childInfo.getParentCityObject(src), json.getCityGMLMarshaller(), cityJSON);
        builder.process(src, dest, semanticsBuilder);

        if (dest.isSetSemantics())
            dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());
    }

    public CompositeSolidType marshalCompositeSolid(CompositeSolid src, CityJSON cityJSON) {
        CompositeSolidType dest = new CompositeSolidType();
        marshalSolidCollection(src, dest, cityJSON);

        return dest;
    }

    public MultiSolidType marshalMultiSolid(MultiSolid src, CityJSON cityJSON) {
        MultiSolidType dest = new MultiSolidType();
        marshalSolidCollection(src, dest, cityJSON);

        return dest;
    }

    public AbstractGeometryObjectType marshalGeometryProperty(GeometryProperty<?> src, CityJSON cityJSON) {
        AbstractGeometryObjectType dest = null;
        if (src.isSetGeometry())
            dest = marshal(src.getGeometry(), cityJSON);
        else if (src.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
            dest = marshal((AbstractGeometry) src.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK), cityJSON);

        return dest;
    }

    private List<List<Integer>> marshalPolygon(Polygon polygon, boolean reverse) {
        List<List<Integer>> vertices = null;

        if (polygon.isSetExterior()) {
            AbstractRing exterior = polygon.getExterior().getRing();
            if (exterior instanceof LinearRing) {
                List<Integer> indexes = marshalLinearRing((LinearRing) exterior, reverse);
                if (indexes != null) {
                    vertices = new ArrayList<>();
                    vertices.add(indexes);

                    if (polygon.isSetInterior()) {
                        for (AbstractRingProperty property : polygon.getInterior()) {
                            AbstractRing interior = property.getRing();
                            if (interior instanceof LinearRing) {
                                indexes = marshalLinearRing((LinearRing) interior, reverse);
                                if (indexes != null)
                                    vertices.add(indexes);
                            }
                        }
                    }
                }
            }
        }

        return vertices;
    }

    private List<Integer> marshalLinearRing(LinearRing linearRing, boolean reverse) {
        List<Integer> vertices = null;

        List<Double> values = linearRing.toList3d(reverse);
        if (values.size() > 11)
            vertices = verticesBuilder.get().addVertices(values.subList(0, values.size() - 3));

        return vertices;
    }

    private final class MultiLineStringBuilder extends GeometryWalker {
        private MultiLineStringType dest;
        private boolean reverse = false;

        @Override
        public void visit(LineString lineString) {
            List<Double> vertices = lineString.toList3d(reverse);
            if (!vertices.isEmpty())
                dest.addLineString(verticesBuilder.get().addVertices(vertices));
        }

        @Override
        public void visit(Curve curve) {
            if (curve.isSetSegments()) {
                CurveSegmentArrayProperty arrayProperty = curve.getSegments();
                if (arrayProperty.isSetCurveSegment()) {
                    List<Double> vertices = new ArrayList<>();
                    for (AbstractCurveSegment abstractCurveSegment : arrayProperty.getCurveSegment()) {
                        if (abstractCurveSegment.getGMLClass() == GMLClass.LINE_STRING_SEGMENT) {
                            List<Double> values = ((LineStringSegment) abstractCurveSegment).toList3d();
                            if (!values.isEmpty())
                                vertices.addAll(values);
                        }
                    }

                    if (!vertices.isEmpty()) {
                        if (!reverse)
                            dest.addLineString(verticesBuilder.get().addVertices(vertices));
                        else {
                            for (int i = vertices.size() - 3; i >= 0; i -= 3)
                                dest.addLineString(verticesBuilder.get().addVertices(vertices.subList(i, i + 3)));
                        }
                    }
                }
            }
        }

        @Override
        public void visit(OrientableCurve orientableCurve) {
            if (orientableCurve.getOrientation() == Sign.MINUS) {
                reverse = !reverse;
                super.visit(orientableCurve);
                reverse = !reverse;
            } else
                super.visit(orientableCurve);
        }

        @Override
        public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
            if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
                ((AbstractGeometry) property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)).accept(this);
            else
                super.visit(property);
        }

        public void process(AbstractCurve src, MultiLineStringType dest) {
            this.dest = dest;
            src.accept(this);
        }

        public void process(MultiCurve src, MultiLineStringType dest) {
            this.dest = dest;
            src.accept(this);
        }
    }

    private final class SurfaceCollectionBuilder extends GeometryWalker {
        private AbstractSurfaceCollectionType dest;
        private SemanticsBuilder semanticsBuilder;
        private boolean reverse = false;
        private int index = 0;

        @Override
        public void visit(Polygon polygon) {
            List<List<Integer>> surface = marshalPolygon(polygon, reverse);
            if (surface != null) {
                Integer semanticsIndex = semanticsBuilder.addSemanticSurface(childInfo.getParentCityObject(polygon));
                Map<String, Integer> materials = json.getCityGMLMarshaller().getAppearanceMarshaller().getMaterials(polygon, reverse);
                Map<String, List<List<Integer>>> textures = json.getCityGMLMarshaller().getAppearanceMarshaller().getTextures(polygon, reverse);

                addSurface(surface, semanticsIndex, materials, textures);
            }
        }

        @Override
        public void visit(PolygonPatch polygonPatch) {
            Polygon polygon = new Polygon();
            polygon.setExterior(polygonPatch.getExterior());
            polygon.setInterior(polygonPatch.getInterior());
            visit(polygon);
        }

        @Override
        public void visit(LinearRing linearRing) {
            // required for gml:Rectangle and gml:Triangle
            List<Integer> vertices = marshalLinearRing(linearRing, reverse);
            if (vertices != null) {
                Integer semanticsIndex = semanticsBuilder.addSemanticSurface(childInfo.getParentCityObject(linearRing));
                Map<String, Integer> materials = json.getCityGMLMarshaller().getAppearanceMarshaller().getMaterials(linearRing, reverse);
                Map<String, List<List<Integer>>> textures = json.getCityGMLMarshaller().getAppearanceMarshaller().getTextures(linearRing, reverse);

                addSurface(Collections.singletonList(vertices), semanticsIndex, materials, textures);
            }
        }

        @Override
        public void visit(OrientableSurface orientableSurface) {
            if (orientableSurface.getOrientation() == Sign.MINUS) {
                reverse = !reverse;
                super.visit(orientableSurface);
                reverse = !reverse;
            } else
                super.visit(orientableSurface);
        }

        @Override
        public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
            if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
                ((AbstractGeometry) property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)).accept(this);
            else
                super.visit(property);
        }

        private void addSurface(List<List<Integer>> surface, Integer semanticsIndex, Map<String, Integer> materials, Map<String, List<List<Integer>>> textures) {
            dest.addSurface(surface);

            if (semanticsIndex != null) {
                SurfaceCollectionSemanticsObject semantics = dest.getSemantics();
                if (semantics == null) {
                    semantics = new SurfaceCollectionSemanticsObject();
                    dest.setSemantics(semantics);
                }

                appendNulls(semantics, index);
                semantics.addValue(semanticsIndex);
            }

            if (materials != null) {
                for (Entry<String, Integer> entry : materials.entrySet()) {
                    SurfaceCollectionMaterialObject material = dest.getMaterial(entry.getKey());
                    if (material == null) {
                        material = new SurfaceCollectionMaterialObject(entry.getKey());
                        dest.addMaterial(material);
                    }

                    // add null values for non-colored surfaces
                    appendNulls(material, index);
                    material.addValue(entry.getValue());
                }
            }

            if (textures != null) {
                for (Entry<String, List<List<Integer>>> entry : textures.entrySet()) {
                    SurfaceCollectionTextureObject texture = dest.getTexture(entry.getKey());
                    if (texture == null) {
                        texture = new SurfaceCollectionTextureObject(entry.getKey());
                        dest.addTexture(texture);
                    }

                    // add null values for non-textured surfaces
                    appendNulls(texture, index);
                    texture.addValue(entry.getValue());
                }
            }

            index++;
        }

        public void process(AbstractGeometry src, AbstractSurfaceCollectionType dest, SemanticsBuilder semanticsBuilder, boolean collapseMaterialValues) {
            this.dest = dest;
            this.semanticsBuilder = semanticsBuilder;

            src.accept(this);
            postprocess(dest, index, collapseMaterialValues);
        }
    }

    private final class SolidCollectionBuilder extends GeometryWalker {
        private AbstractSolidCollectionType dest;
        private SemanticsBuilder semanticsBuilder;
        private int index = 0;

        @Override
        public void visit(Solid solid) {
            SolidType solidType = new SolidType();
            marshalSolid(solid, solidType, semanticsBuilder, false);

            if (!solidType.getShells().isEmpty()) {
                dest.addSolid(solidType.getShells());

                if (solidType.isSetSemantics()) {
                    SolidCollectionSemanticsObject semantics = dest.getSemantics();
                    if (semantics == null) {
                        semantics = new SolidCollectionSemanticsObject();
                        dest.setSemantics(semantics);
                    }

                    // add null values for non-semantic surfaces
                    appendNulls(semantics, index);
                    semantics.addValues(solidType.getSemantics().getValues());
                }

                if (solidType.isSetMaterial()) {
                    for (SolidMaterialObject object : solidType.getMaterial()) {
                        SolidCollectionMaterialObject material = dest.getMaterial(object.getTheme());
                        if (material == null) {
                            material = new SolidCollectionMaterialObject(object.getTheme());
                            dest.addMaterial(material);
                        }

                        // add null values for non-colored surfaces
                        appendNulls(material, index);
                        material.addValue(object.getValues());
                    }
                }

                if (solidType.isSetTexture()) {
                    for (SolidTextureObject object : solidType.getTexture()) {
                        SolidCollectionTextureObject texture = dest.getTexture(object.getTheme());
                        if (texture == null) {
                            texture = new SolidCollectionTextureObject(object.getTheme());
                            dest.addTexture(texture);
                        }

                        // add null values for non-textured surfaces
                        appendNulls(texture, index);
                        texture.addValue(object.getValues());
                    }
                }

                index++;
            }
        }

        @Override
        public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
            if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
                ((AbstractGeometry) property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)).accept(this);
            else
                super.visit(property);
        }

        public void process(AbstractGeometry src, AbstractSolidCollectionType dest, SemanticsBuilder semanticsBuilder) {
            this.dest = dest;
            this.semanticsBuilder = semanticsBuilder;

            src.accept(this);
            postprocess(dest, index, true);
        }
    }

    private void appendNulls(AbstractSemanticsObject semantics, int index) {
        while (semantics.getNumValues() < index)
            semantics.addNullValue();
    }

    private void appendNulls(AbstractMaterialObject material, int index) {
        while (material.getNumValues() < index)
            material.addNullValue();
    }

    private void appendNulls(AbstractTextureObject texture, int index) {
        while (texture.getNumValues() < index)
            texture.addNullValue();
    }

    private void postprocess(AbstractGeometryObjectType dest, int index, boolean collapseMaterialValues) {
        if (dest instanceof GeometryWithSemantics) {
            GeometryWithSemantics geometry = (GeometryWithSemantics) dest;
            if (geometry.isSetSemantics())
                appendNulls(geometry.getSemantics(), index);
        }

        if (dest instanceof GeometryWithAppearance<?, ?>) {
            GeometryWithAppearance<?, ?> geometry = (GeometryWithAppearance<?, ?>) dest;
            if (geometry.isSetMaterial()) {
                for (AbstractMaterialObject material : geometry.getMaterial()) {
                    if (!collapseMaterialValues || !material.collapseValues())
                        appendNulls(material, index);
                }
            }

            if (geometry.isSetTexture()) {
                for (AbstractTextureObject texture : geometry.getTexture())
                    appendNulls(texture, index);
            }
        }
    }

}
