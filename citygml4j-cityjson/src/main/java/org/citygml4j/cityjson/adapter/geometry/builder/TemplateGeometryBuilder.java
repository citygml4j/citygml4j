/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
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

package org.citygml4j.cityjson.adapter.geometry.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.core.AbstractAppearanceProperty;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.ImplicitGeometry;
import org.citygml4j.core.model.core.TransformationMatrix4x4;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.util.Matrices;
import org.xmlobjects.gml.util.jama.Matrix;

import java.util.ArrayList;
import java.util.List;

public class TemplateGeometryBuilder extends GeometryObjectBuilder {
    private final TemplateInfo templateInfo;
    private final GeometryBuilder geometryBuilder;
    private final CityJSONBuilderHelper helper;
    private final VerticesBuilder templatesVerticesBuilder;
    private final PointGeometryBuilder pointGeometryBuilder;

    TemplateGeometryBuilder(AbstractFeature object, BoundaryFilter filter, TemplateInfo templateInfo, GeometryBuilder geometryBuilder, CityJSONBuilderHelper helper) {
        super(object, filter);
        this.templateInfo = templateInfo;
        this.geometryBuilder = geometryBuilder;
        this.helper = helper;

        templatesVerticesBuilder = geometryBuilder.getTemplatesVerticesBuilder();
        pointGeometryBuilder = new PointGeometryBuilder(object, filter, geometryBuilder.getVerticesBuilder());
    }

    @Override
    void build(JsonNode node, GeometryType type, int lod, GeometryObject geometryObject) {
        int template = node.path(Fields.TEMPLATE).asInt(-1);
        PointProperty referencePoint = getReferencePoint(node, lod, geometryObject);
        TransformationMatrix4x4 matrix = getTransformationMatrix(node.path(Fields.TRANSFORMATION_MATRIX));
        if (template == -1 || referencePoint == null || matrix == null) {
            return;
        }

        if (!geometryBuilder.isTransformTemplateGeometries()) {
            ImplicitGeometry implicitGeometry = createImplicitGeometry(template, lod);
            if (implicitGeometry != null) {
                implicitGeometry.setReferencePoint(referencePoint);
                implicitGeometry.setTransformationMatrix(matrix);
                geometryObject.setImplicitGeometry(implicitGeometry);
            }
        } else {
            transformTemplateGeometry(template, referencePoint, matrix, lod, geometryObject);
        }
    }

    private ImplicitGeometry createImplicitGeometry(int index, int lod) {
        String reference = templateInfo.getReference(index);
        if (reference != null) {
            return new ImplicitGeometry(new GeometryProperty<>(reference));
        } else {
            GeometryObject geometryObject = GeometryObject.newInstance();
            if (!geometryBuilder.isAssignAppearanceToImplicitGeometry()) {
                geometryObject.setAppearanceInfo(templateInfo.getAppearanceInfo());
            }

            geometryBuilder.getGeometry(object, geometryObject, templateInfo.getTemplate(index), lod, filter, templatesVerticesBuilder);
            if (geometryObject.isSetGeometry()) {
                AbstractGeometry geometry = geometryObject.getGeometry();
                templateInfo.addReference(index, "#" + helper.getOrCreateId(geometry));
                ImplicitGeometry implicitGeometry = new ImplicitGeometry(new GeometryProperty<>(geometry));

                if (geometryObject.hasAppearances() && geometryBuilder.isAssignAppearanceToImplicitGeometry()) {
                    for (Appearance appearance : geometryObject.getAppearances()) {
                        implicitGeometry.getAppearances().add(new AbstractAppearanceProperty(appearance));
                    }
                }

                return implicitGeometry;
            }
        }

        return null;
    }

    private void transformTemplateGeometry(int index, PointProperty referencePoint, TransformationMatrix4x4 matrix, int lod, GeometryObject geometryObject) {
        List<Double> point = referencePoint.getObject().toCoordinateList3D();
        Matrix transform = matrix.getValue();
        transform.set(0, 3, transform.get(0, 3) + point.get(0));
        transform.set(1, 3, transform.get(1, 3) + point.get(1));
        transform.set(2, 3, transform.get(2, 3) + point.get(2));

        VerticesBuilder verticesBuilder = new VerticesBuilder(helper.createArray()) {
            @Override
            public List<Double> getVertices(ArrayNode indexes, boolean appendLastVertex) {
                return Matrices.transform3D(
                        templatesVerticesBuilder.getVertices(indexes, appendLastVertex),
                        transform);
            }
        };

        geometryBuilder.getGeometry(object, geometryObject, templateInfo.getTemplate(index), lod, filter, verticesBuilder);
    }

    private PointProperty getReferencePoint(JsonNode geometry, int lod, GeometryObject geometryObject) {
        pointGeometryBuilder.build(geometry, GeometryType.MULTI_POINT, lod, geometryObject);
        MultiPoint multiPoint = geometryObject.getGeometry(MultiPoint.class);
        return multiPoint != null ?
                multiPoint.getPointMember().get(0) :
                null;
    }

    private TransformationMatrix4x4 getTransformationMatrix(JsonNode matrix) {
        if (matrix.isArray() && matrix.size() > 15) {
            List<Double> values = new ArrayList<>(16);
            for (int i = 0; i < matrix.size(); i++) {
                values.add(matrix.path(i).asDouble(0));
            }

            return TransformationMatrix4x4.ofRowMajorList(values);
        } else {
            return null;
        }
    }
}
