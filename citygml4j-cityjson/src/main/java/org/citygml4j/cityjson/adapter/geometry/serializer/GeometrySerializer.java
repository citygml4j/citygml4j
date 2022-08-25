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

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.core.ImplicitGeometry;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.util.jama.Matrix;

import java.util.*;

public class GeometrySerializer {
    public static final int DEFAULT_VERTEX_PRECISION = 3;
    public static final int DEFAULT_TEMPLATE_PRECISION = 3;

    private final AppearanceSerializer appearanceSerializer;
    private final CityJSONSerializerHelper helper;
    private final Map<String, TemplateInfo> templates = new HashMap<>();
    private final VerticesBuilder verticesBuilder = new VerticesBuilder(DEFAULT_VERTEX_PRECISION);
    private final VerticesBuilder templatesVerticesBuilder = new VerticesBuilder(DEFAULT_TEMPLATE_PRECISION);

    private boolean transformTemplateGeometries;

    public GeometrySerializer(AppearanceSerializer appearanceSerializer, CityJSONSerializerHelper helper) {
        this.appearanceSerializer = appearanceSerializer;
        this.helper = helper;
    }

    public VerticesBuilder getVerticesBuilder() {
        return verticesBuilder;
    }

    public VerticesBuilder getTemplatesVerticesBuilder() {
        return templatesVerticesBuilder;
    }

    public boolean isTransformTemplateGeometries() {
        return transformTemplateGeometries;
    }

    public void setTransformTemplateGeometries(boolean transformTemplateGeometries) {
        this.transformTemplateGeometries = transformTemplateGeometries;
    }

    public void addGeometry(AbstractGeometry geometry, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        buildGeometry(geometry, lod, helper.getOrPutArray(Fields.GEOMETRY, object), allowedTypes, verticesBuilder);
    }

    public ObjectNode getGeometry(AbstractGeometry geometry, Number lod, EnumSet<GeometryType> allowedTypes) {
        return createGeometry(geometry, lod, verticesBuilder, allowedTypes);
    }

    public void addTemplateGeometry(ImplicitGeometry geometry, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        if (geometry == null
                || geometry.getRelativeGeometry() == null
                || geometry.getRelativeGeometry().getObject() == null
                || geometry.getReferencePoint() == null
                || geometry.getReferencePoint().getObject() == null
                || geometry.getTransformationMatrix() == null) {
            return;
        }

        if (!transformTemplateGeometries) {
            buildTemplateGeometry(geometry, lod, object, allowedTypes);
        } else {
            convertTemplateGeometry(geometry, lod, object, allowedTypes);
        }
    }

    public boolean hasTemplates() {
        return !templates.isEmpty();
    }

    public Iterator<ObjectNode> getTemplates() {
        return templates.values().stream()
                .sorted(Comparator.comparingInt(TemplateInfo::getIndex))
                .map(TemplateInfo::getNode)
                .iterator();
    }

    private ObjectNode createGeometry(AbstractGeometry geometry, Number lod, VerticesBuilder verticesBuilder, EnumSet<GeometryType> allowedTypes) {
        ArrayNode node = helper.createArray();
        buildGeometry(geometry, lod, node, allowedTypes, verticesBuilder);
        return node.size() == 1 ? (ObjectNode) node.get(0) : null;
    }

    private void buildGeometry(AbstractGeometry geometry, Number lod, ArrayNode node, EnumSet<GeometryType> allowedTypes, VerticesBuilder verticesBuilder) {
        if (geometry != null && allowedTypes != null) {
            MultiGeometryBuilder builder = new MultiGeometryBuilder(allowedTypes, appearanceSerializer, verticesBuilder, helper);
            geometry.accept(builder);
            builder.build(geometry, lod, node);
        }
    }

    private void buildTemplateGeometry(ImplicitGeometry geometry, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        AbstractGeometry relativeGeometry = geometry.getRelativeGeometry().getObject();
        TemplateInfo templateInfo = templates.get(helper.getOrCreateId(relativeGeometry));
        if (templateInfo == null) {
            ObjectNode template = createGeometry(relativeGeometry, lod, templatesVerticesBuilder, EnumSet.allOf(GeometryType.class));
            templateInfo = template != null ?
                    new TemplateInfo(template, templates.size()) :
                    TemplateInfo.NULL_TEMPLATE;

            templates.put(relativeGeometry.getId(), templateInfo);
        }

        if (templateInfo == TemplateInfo.NULL_TEMPLATE) {
            return;
        }

        GeometryType type = GeometryType.fromValue(templateInfo.getNode().path(Fields.TYPE).asText());
        if (!allowedTypes.contains(type)) {
            return;
        }

        double[] matrix = geometry.getTransformationMatrix().getValue().getRowPackedCopy();
        Point referencePoint = geometry.getReferencePoint().getObject();

        List<Double> coordinates = referencePoint.toCoordinateList3D();
        coordinates.set(0, coordinates.get(0) + matrix[3]);
        coordinates.set(1, coordinates.get(1) + matrix[7]);
        coordinates.set(2, coordinates.get(2) + matrix[11]);

        matrix[3] = 0;
        matrix[7] = 0;
        matrix[11] = 0;

        ObjectNode boundary = createGeometry(new Point(new DirectPosition(coordinates)), lod, verticesBuilder, EnumSet.of(GeometryType.MULTI_POINT));
        if (boundary == null) {
            return;
        }

        ObjectNode node = helper.getOrPutArray(Fields.GEOMETRY, object).addObject();
        node.put(Fields.TYPE, GeometryType.TEMPLATE_GEOMETRY.toTypeName());
        node.put(Fields.TEMPLATE, templateInfo.getIndex());
        node.set(Fields.BOUNDARIES, boundary.path(Fields.BOUNDARIES));
        ArrayNode transformationMatrix = node.putArray(Fields.TRANSFORMATION_MATRIX);
        Arrays.stream(matrix).forEach(transformationMatrix::add);
    }

    private void convertTemplateGeometry(ImplicitGeometry geometry, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        Matrix matrix = geometry.getTransformationMatrix().getValue();
        List<Double> translate = geometry.getReferencePoint().getObject().toCoordinateList3D();

        VerticesBuilder builder = new VerticesBuilder(0) {
            @Override
            public List<Integer> addVertices(List<Double> vertices) {
                int size = vertices.size();
                for (int i = 0; i < size; i += 3) {
                    if (i + 3 > size) {
                        break;
                    }

                    Matrix v = new Matrix(new double[]{vertices.get(i), vertices.get(i + 1), vertices.get(i + 2), 1}, 4);
                    v = matrix.times(v);

                    vertices.set(i, v.get(0, 0) + translate.get(0));
                    vertices.set(i + 1, v.get(1, 0) + translate.get(1));
                    vertices.set(i + 2, v.get(2, 0) + translate.get(2));
                }

                return verticesBuilder.addVertices(vertices);
            }
        };

        AbstractGeometry relativeGeometry = geometry.getRelativeGeometry().getObject();
        buildGeometry(relativeGeometry, lod, helper.getOrPutArray(Fields.GEOMETRY, object), allowedTypes, builder);
    }

    public void reset() {
        verticesBuilder.reset();
        templatesVerticesBuilder.reset();
        templates.clear();
    }
}
