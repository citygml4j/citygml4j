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

package org.citygml4j.cityjson.writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.adapter.core.AbstractSpaceAdapter;
import org.citygml4j.cityjson.adapter.geometry.serializer.GeometrySerializer;
import org.citygml4j.cityjson.adapter.geometry.serializer.SpaceGeometryBuilder;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.core.ExtendedSpaceGeometry;
import org.citygml4j.cityjson.model.generics.GenericAttributeTypes;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.util.ArrayBuffer;
import org.citygml4j.core.model.ade.ADEProperty;
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.core.*;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.feature.FeatureProperty;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.util.id.DefaultIdCreator;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.util.Properties;

import java.util.*;

public class CityJSONSerializerHelper {
    public static final String SEMANTIC_SURFACE = "org.citygml4j.cityjson.semanticSurface";
    public static final String TEMPORARY_OBJECT = "org.citygml4j.tempObject";

    private final AbstractCityJSONWriter<?> writer;
    private final CityJSONType type;
    private final CityJSONVersion version;
    private final ObjectMapper objectMapper;
    private final CityJSONContext context;
    private final GeometrySerializer geometrySerializer;
    private final AppearanceSerializer appearanceSerializer;
    private final Map<Class<?>, JsonObjectSerializer<?>> serializerCache = new IdentityHashMap<>();

    private IdCreator idCreator = DefaultIdCreator.getInstance();
    private boolean applyTransformation;
    private boolean computeCityModelExtent = true;
    private boolean writeGenericAttributeTypes;
    private Map<String, ObjectNode> extensions;
    private Metadata metadata;
    private ObjectNode extraRootProperties;
    private Properties properties;

    CityJSONSerializerHelper(AbstractCityJSONWriter<?> writer, CityJSONVersion version, ObjectMapper objectMapper, CityJSONContext context) {
        this.writer = writer;
        this.version = version;
        this.objectMapper = objectMapper;
        this.context = context;

        type = writer instanceof CityJSONFeatureWriter ? CityJSONType.CITYJSON_FEATURE : CityJSONType.CITYJSON;
        appearanceSerializer = new AppearanceSerializer(this);
        geometrySerializer = new GeometrySerializer(appearanceSerializer, this);
    }

    public CityJSONType getType() {
        return type;
    }

    public CityJSONVersion getVersion() {
        return version;
    }

    public CityJSONContext getContext() {
        return context;
    }

    GeometrySerializer getGeometrySerializer() {
        return geometrySerializer;
    }

    AppearanceSerializer getAppearanceSerializer() {
        return appearanceSerializer;
    }

    public IdCreator getIdCreator() {
        return idCreator;
    }

    void setIdCreator(IdCreator idCreator) {
        this.idCreator = Objects.requireNonNull(idCreator, "The ID creator must not be null.");
    }

    boolean isApplyTransformation() {
        return applyTransformation;
    }

    void setApplyTransformation(boolean applyTransformation) {
        this.applyTransformation = applyTransformation;
    }

    boolean isComputeCityModelExtent() {
        return computeCityModelExtent;
    }

    void setComputeCityModelExtent(boolean computeCityModelExtent) {
        this.computeCityModelExtent = computeCityModelExtent;
    }

    public boolean isWriteGenericAttributeTypes() {
        return writeGenericAttributeTypes;
    }

    void setWriteGenericAttributeTypes(boolean writeGenericAttributeTypes) {
        this.writeGenericAttributeTypes = writeGenericAttributeTypes;
        if (writeGenericAttributeTypes) {
            properties.set(GenericAttributeTypes.class.getName(), new GenericAttributeTypes());
        } else {
            properties.remove(GenericAttributeTypes.class.getName());
        }
    }

    boolean hasExtensions() {
        return extensions != null && !extensions.isEmpty();
    }

    public boolean isSetExternalExtension(String name) {
        return extensions != null && extensions.containsKey(name);
    }

    Map<String, ObjectNode> getExternalExtensions() {
        return extensions != null ? extensions : Collections.emptyMap();
    }

    public void addExternalExtension(String name, String url, String version) {
        if (extensions == null) {
            extensions = new HashMap<>();
        }

        ObjectNode node = createObject();
        node.put(Fields.URL, url);
        node.put(Fields.VERSION, version);

        extensions.put(name, node);
    }

    boolean hasMetadata() {
        return metadata != null;
    }

    public Metadata getMetadata() {
        if (metadata == null) {
            metadata = new Metadata();
        }

        return metadata;
    }

    void setMetadata(Metadata metadata) {
        this.metadata = Objects.requireNonNull(metadata, "The metadata must not be null.");
    }

    boolean hasExtraRootProperties() {
        return extraRootProperties != null && !extraRootProperties.isEmpty();
    }

    ObjectNode getExtraRootProperties() {
        if (extraRootProperties == null) {
            extraRootProperties = createObject();
        }

        return extraRootProperties;
    }

    public Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
        }

        return properties;
    }

    void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getOrCreateId(AbstractGML object) {
        if (object.getId() == null) {
            object.setId(idCreator.createId());
        }

        return object.getId();
    }

    public ObjectNode createObject() {
        return objectMapper.createObjectNode();
    }

    public ObjectNode getOrPutObject(String propertyName, ObjectNode node) {
        JsonNode candidate = node.path(propertyName);
        return candidate.isObject() ?
                (ObjectNode) candidate :
                node.putObject(propertyName);
    }

    public ArrayNode createArray() {
        return objectMapper.createArrayNode();
    }

    public ArrayNode getOrPutArray(String propertyName, ObjectNode node) {
        JsonNode candidate = node.path(propertyName);
        return candidate.isArray() ?
                (ArrayNode) candidate :
                node.putArray(propertyName);
    }

    public void removeIfEmpty(String propertyName, ObjectNode node) {
        if (node.path(propertyName).isEmpty()) {
            node.remove(propertyName);
        }
    }

    public void addGeometry(GeometryProperty<?> property, Number lod, ObjectNode object) {
        addGeometry(property, lod, object, EnumSet.allOf(GeometryType.class));
    }

    public void addGeometry(AbstractGeometry geometry, Number lod, ObjectNode object) {
        addGeometry(geometry, lod, object, EnumSet.allOf(GeometryType.class));
    }

    public void addGeometry(GeometryProperty<?> property, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        if (property != null) {
            addGeometry(property.getObject(), lod, object, allowedTypes);
        }
    }

    public void addGeometry(AbstractGeometry geometry, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        geometrySerializer.addGeometry(geometry, lod, object, allowedTypes);
    }

    public ObjectNode getGeometry(GeometryProperty<?> property, Number lod) {
        return getGeometry(property, lod, EnumSet.allOf(GeometryType.class));
    }

    public ObjectNode getGeometry(AbstractGeometry geometry, Number lod) {
        return getGeometry(geometry, lod, EnumSet.allOf(GeometryType.class));
    }

    public ObjectNode getGeometry(GeometryProperty<?> property, Number lod, EnumSet<GeometryType> allowedTypes) {
        return property != null ?
                getGeometry(property.getObject(), lod, allowedTypes) :
                null;
    }

    public ObjectNode getGeometry(AbstractGeometry geometry, Number lod, EnumSet<GeometryType> allowedTypes) {
        return geometrySerializer.getGeometry(geometry, lod, allowedTypes);
    }

    public void addTemplateGeometry(ImplicitGeometryProperty property, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        if (property != null) {
            addTemplateGeometry(property.getObject(), lod, object, allowedTypes);
        }
    }

    public void addTemplateGeometry(ImplicitGeometry geometry, Number lod, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        geometrySerializer.addTemplateGeometry(geometry, lod, object, allowedTypes);
    }

    public void addGeometries(AbstractSpace space, ObjectNode object, EnumSet<GeometryType> allowedTypes) {
        GeometryInfo geometryInfo = space.getGeometryInfo();
        for (int lod = 0; lod < 4; lod++) {
            for (GeometryProperty<?> property : geometryInfo.getGeometries(lod)) {
                addGeometry(property, lod, object, allowedTypes);
            }
        }

        for (ADEOfAbstractSpace adeContainer : space.getADEProperties(ADEOfAbstractSpace.class)) {
            if (adeContainer instanceof ExtendedSpaceGeometry) {
                addGeometry(((ExtendedSpaceGeometry) adeContainer).getLod1MultiSurface(), 1, object, allowedTypes);
                break;
            }
        }

        if (!geometryInfo.hasGeometries(3)) {
            for (GeometryProperty<?> property : geometryInfo.getGeometries(4)) {
                addGeometry(property, 3, object, allowedTypes);
            }
        }

        if (allowedTypes.contains(GeometryType.TEMPLATE_GEOMETRY)) {
            for (int lod = 0; lod < 4; lod++) {
                for (ImplicitGeometryProperty property : geometryInfo.getImplicitGeometries(lod)) {
                    addTemplateGeometry(property, lod, object, allowedTypes);
                }
            }

            if (!geometryInfo.hasImplicitGeometries(3)) {
                for (ImplicitGeometryProperty property : geometryInfo.getImplicitGeometries(4)) {
                    addTemplateGeometry(property, 3, object, allowedTypes);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends ADEProperty> void addADEProperty(T property, ObjectNode node) throws CityJSONSerializeException, CityJSONWriteException {
        if (property != null) {
            JsonObjectSerializer<T> serializer = (JsonObjectSerializer<T>) context.getSerializer(property.getClass(), version);
            if (serializer != null) {
                getObjectUsingSerializer(property, node, serializer);
            }
        }
    }

    public void addExtraRootProperty(ADEOfCityModel property) throws CityJSONSerializeException, CityJSONWriteException {
        addADEProperty(property, getExtraRootProperties());
    }

    public void addExtraRootProperty(String propertyName, JsonNode value) {
        getExtraRootProperties().set(propertyName, value);
    }

    public void writeStandardObjectClassifier(StandardObjectClassifier object, ObjectNode node) {
        if (object.getClassifier() != null) {
            node.put("class", object.getClassifier().getValue());
        }

        if (object.isSetFunctions()) {
            for (Code function : object.getFunctions()) {
                if (function.getValue() != null) {
                    node.put("function", function.getValue());
                    break;
                }
            }
        }

        if (object.isSetUsages()) {
            for (Code usage : object.getUsages()) {
                if (usage.getValue() != null) {
                    node.put("usage", usage.getValue());
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> ObjectNode getObject(T object) throws CityJSONSerializeException, CityJSONWriteException {
        if (object != null) {
            JsonObjectSerializer<T> serializer = (JsonObjectSerializer<T>) context.getSerializer(object.getClass(), version);
            if (serializer != null) {
                return getObjectUsingSerializer(object, serializer);
            }
        }

        return null;
    }

    public <T> ObjectNode getObjectUsingSerializer(T object, Class<? extends JsonObjectSerializer<T>> type) throws CityJSONSerializeException, CityJSONWriteException {
        return getObjectUsingSerializer(object, getOrCreateSerializer(type));
    }

    public <T> ObjectNode getObjectUsingSerializer(T object, JsonObjectSerializer<T> serializer) throws CityJSONSerializeException, CityJSONWriteException {
        return getObjectUsingSerializer(object, objectMapper.createObjectNode(), serializer);
    }

    private <T> ObjectNode getObjectUsingSerializer(T object, ObjectNode node, JsonObjectSerializer<T> serializer) throws CityJSONSerializeException, CityJSONWriteException {
        if (object != null) {
            String type = serializer.createType(object, version);
            if (type != null) {
                node.put(Fields.TYPE, serializer.createType(object, version));
            }

            serializer.writeObject(object, node, this);
            return node;
        } else {
            return null;
        }
    }

    public <T> JsonObjectSerializer<T> getOrCreateSerializer(Class<? extends JsonObjectSerializer<T>> type) throws CityJSONSerializeException {
        JsonObjectSerializer<?> cachedSerializer = serializerCache.get(type);
        if (cachedSerializer != null && type.isAssignableFrom(cachedSerializer.getClass())) {
            return type.cast(cachedSerializer);
        } else {
            try {
                JsonObjectSerializer<T> serializer = type.getDeclaredConstructor().newInstance();
                serializerCache.put(type, serializer);
                return serializer;
            } catch (Exception e) {
                throw new CityJSONSerializeException("The serializer " + type.getName() + " lacks a default constructor.");
            }
        }
    }

    public <T extends AbstractFeature> void writeCityObject(FeatureProperty<T> property) throws CityJSONSerializeException, CityJSONWriteException {
        if (property != null) {
            writeCityObject(property.getObject());
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractFeature> void writeCityObject(T object) throws CityJSONSerializeException, CityJSONWriteException {
        if (object != null) {
            JsonObjectSerializer<T> serializer = (JsonObjectSerializer<T>) context.getSerializer(object.getClass(), version);
            if (serializer != null) {
                writeCityObjectUsingSerializer(object, serializer);
            }
        }
    }

    public <T extends AbstractFeature> void writeCityObjectUsingSerializer(FeatureProperty<T> property, JsonObjectSerializer<T> serializer) throws CityJSONSerializeException, CityJSONWriteException {
        if (property != null) {
            writeCityObjectUsingSerializer(property.getObject(), serializer);
        }
    }

    public <T extends AbstractFeature> void writeCityObjectUsingSerializer(T object, JsonObjectSerializer<T> serializer) throws CityJSONSerializeException, CityJSONWriteException {
        if (object != null) {
            writer.beginTopLevelObject();

            String id = getOrCreateId(object);
            ObjectNode node = getCityObjectUsingSerializer(object, serializer);

            if (!node.path(Fields.TYPE).isNull()) {
                writer.writeCityObject(id, removeEmptyProperties(node));
            }
        }
    }

    public <T extends AbstractFeature> void writeChildObject(FeatureProperty<T> property, AbstractFeature parent, ObjectNode parentNode) throws CityJSONSerializeException, CityJSONWriteException {
        if (property != null) {
            writeChildObject(property.getObject(), parent, parentNode);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractFeature> void writeChildObject(T child, AbstractFeature parent, ObjectNode parentNode) throws CityJSONSerializeException, CityJSONWriteException {
        if (child != null) {
            JsonObjectSerializer<T> serializer = (JsonObjectSerializer<T>) context.getSerializer(child.getClass(), version);
            if (serializer != null) {
                writeChildObjectUsingSerializer(child, parent, parentNode, serializer);
            }
        }
    }

    public <T extends AbstractFeature> void writeChildObjectUsingSerializer(FeatureProperty<T> property, AbstractFeature parent, ObjectNode parentNode, JsonObjectSerializer<T> serializer) throws CityJSONSerializeException, CityJSONWriteException {
        if (property != null) {
            writeChildObjectUsingSerializer(property.getObject(), parent, parentNode, serializer);
        }
    }

    public <T extends AbstractFeature> void writeChildObjectUsingSerializer(T child, AbstractFeature parent, ObjectNode parentNode, JsonObjectSerializer<T> serializer) throws CityJSONSerializeException, CityJSONWriteException {
        if (child != null && parent != null && parentNode != null) {
            String childId = getOrCreateId(child);
            String parentId = getOrCreateId(parent);

            ObjectNode childNode = getCityObjectUsingSerializer(child, serializer);
            if (!childNode.path(Fields.TYPE).isNull()) {
                getOrPutArray(Fields.PARENTS, childNode).add(parentId);
                getOrPutArray(Fields.CHILDREN, parentNode).add(childId);
                writer.writeChildObject(childId, removeEmptyProperties(childNode));
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private <T extends AbstractFeature> ObjectNode getCityObjectUsingSerializer(T object, JsonObjectSerializer<T> serializer) throws CityJSONSerializeException, CityJSONWriteException {
        ObjectNode node = objectMapper.createObjectNode();
        node.set(Fields.TYPE, NullNode.getInstance());
        node.set(Fields.GEOGRAPHICAL_EXTENT, createArray());
        node.set(Fields.ATTRIBUTES, createObject());
        node.set(Fields.PARENTS, createArray());
        node.set(Fields.CHILDREN, createArray());
        node.set(Fields.GEOMETRY, createArray());

        SpaceGeometryBuilder builder = null;
        if (object instanceof AbstractSpace) {
            AbstractSpace space = (AbstractSpace) object;
            builder = SpaceGeometryBuilder.newInstance();

            if (serializer instanceof AbstractSpaceAdapter) {
                AbstractSpaceAdapter spaceAdapter = (AbstractSpaceAdapter) serializer;
                builder.withMultiSurfaceProviders(spaceAdapter.getMultiSurfaceProviders(space))
                        .withMultiCurveProviders(spaceAdapter.getMultiCurveProviders(space));
            }

            builder.addUnreferencedBoundaryGeometries(space);
        }

        // populate city object
        getObjectUsingSerializer(object, node, serializer);

        if (builder != null) {
            builder.removeTemporaryInformation((AbstractSpace) object);
        }

        return node;
    }

    private ObjectNode removeEmptyProperties(ObjectNode node) {
        removeIfEmpty(Fields.GEOGRAPHICAL_EXTENT, node);
        removeIfEmpty(Fields.ATTRIBUTES, node);
        removeIfEmpty(Fields.PARENTS, node);
        removeIfEmpty(Fields.CHILDREN, node);

        if (version != CityJSONVersion.v1_0) {
            removeIfEmpty(Fields.GEOMETRY, node);
        }

        return node;
    }

    List<Double> computeExtent(ArrayBuffer<Vertex> vertices) {
        Double[] extent = new Double[]{
                Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,
                -Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE};

        for (Vertex vertex : vertices) {
            double x = vertex.getX();
            double y = vertex.getY();
            double z = vertex.getZ();

            if (x < extent[0]) extent[0] = x;
            if (y < extent[1]) extent[1] = y;
            if (z < extent[2]) extent[2] = z;
            if (x > extent[3]) extent[3] = x;
            if (y > extent[4]) extent[4] = y;
            if (z > extent[5]) extent[5] = z;
        }

        return Arrays.asList(extent);
    }

    void reset() {
        serializerCache.clear();
        geometrySerializer.reset();
        appearanceSerializer.reset();
    }
}
