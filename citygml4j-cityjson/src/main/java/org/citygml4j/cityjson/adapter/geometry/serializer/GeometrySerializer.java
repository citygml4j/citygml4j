/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.core.ImplicitGeometry;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.util.matrix.Matrix;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.*;

public class GeometrySerializer {
    public static final int DEFAULT_VERTEX_PRECISION = 3;
    public static final int DEFAULT_TEMPLATE_PRECISION = 3;
    private static final EnumSet<GeometryType> ALL_GEOMETRY_TYPES = EnumSet.allOf(GeometryType.class);

    private final AppearanceSerializer appearanceSerializer;
    private final CityJSONSerializerHelper helper;
    private final Map<String, Integer> templateIndexes = new HashMap<>();
    private final Map<Integer, ObjectNode> templates = new TreeMap<>();
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
                || geometry.getReferencePoint() == null
                || geometry.getReferencePoint().getObject() == null
                || geometry.getTransformationMatrix() == null) {
            return;
        }

        if (!transformTemplateGeometries) {
            buildGeometryInstance(geometry, lod, object);
        } else {
            convertTemplateGeometry(geometry, lod, object, allowedTypes);
        }
    }

    public void addTemplateGeometry(AbstractGeometry geometry, Number lod) {
        registerTemplateGeometry(geometry, lod);
    }

    public boolean hasTemplates() {
        return !templates.isEmpty();
    }

    public Iterator<ObjectNode> getTemplates() {
        return templates.values().iterator();
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

    private void buildGeometryInstance(ImplicitGeometry geometry, Number lod, ObjectNode object) {
        int index = geometry.getRelativeGeometry().getObject() != null
                ? registerTemplateGeometry(geometry.getRelativeGeometry().getObject(), lod)
                : registerTemplateGeometry(helper.getIdFromReference(geometry.getRelativeGeometry().getHref()));
        if (index < 0) {
            return;
        }

        List<Double> matrix = geometry.getTransformationMatrix().toRowMajor();
        List<Double> coordinates = geometry.getReferencePoint().getObject().toCoordinateList3D();
        ObjectNode boundary = createGeometry(new Point(new DirectPosition(coordinates)), lod, verticesBuilder,
                EnumSet.of(GeometryType.MULTI_POINT));
        if (boundary == null) {
            return;
        }

        ObjectNode node = helper.getOrPutArray(Fields.GEOMETRY, object).addObject();
        node.put(Fields.TYPE, GeometryType.TEMPLATE_GEOMETRY.toTypeName());
        node.put(Fields.TEMPLATE, index);
        node.set(Fields.BOUNDARIES, boundary.path(Fields.BOUNDARIES));
        ArrayNode transformationMatrix = node.putArray(Fields.TRANSFORMATION_MATRIX);
        matrix.forEach(transformationMatrix::add);
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

    private int registerTemplateGeometry(AbstractGeometry geometry, Number lod) {
        if (geometry != null) {
            int index = registerTemplateGeometry(helper.getOrCreateId(geometry));
            templates.computeIfAbsent(index, k ->
                    createGeometry(geometry, lod, templatesVerticesBuilder, ALL_GEOMETRY_TYPES));
            return index;
        }

        return -1;
    }

    private int registerTemplateGeometry(String objectId) {
        return objectId != null ? templateIndexes.computeIfAbsent(objectId, k -> templateIndexes.size()) : -1;
    }

    public void reset() {
        verticesBuilder.reset();
        templatesVerticesBuilder.reset();
        templates.clear();

        if (helper.getType() != CityJSONType.CITYJSON_FEATURE) {
            templateIndexes.clear();
        }
    }
}
