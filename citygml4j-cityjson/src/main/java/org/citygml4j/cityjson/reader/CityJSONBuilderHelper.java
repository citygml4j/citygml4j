/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractFeatureAdapter;
import org.citygml4j.cityjson.adapter.core.AbstractSemanticObjectAdapter;
import org.citygml4j.cityjson.adapter.core.AbstractSpaceAdapter;
import org.citygml4j.cityjson.adapter.extension.ExtensionInfo;
import org.citygml4j.cityjson.adapter.geometry.builder.GeometryBuilder;
import org.citygml4j.cityjson.adapter.geometry.builder.GeometryObject;
import org.citygml4j.cityjson.adapter.geometry.builder.TemplateInfo;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.builder.TypeMapper;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.generics.GenericAttributeType;
import org.citygml4j.cityjson.model.generics.GenericAttributeTypes;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.cityjson.util.GenericAttributeTypeParser;
import org.citygml4j.cityjson.util.lod.LodMapper;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.core.*;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.util.id.DefaultIdCreator;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.util.Properties;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;

public class CityJSONBuilderHelper {
    private final CityJSONReader reader;
    private final CityJSONType type;
    private final CityJSONVersion version;
    private final ObjectMapper objectMapper;
    private final CityJSONContext context;
    private final Map<Class<?>, JsonObjectBuilder<?>> builderCache = new IdentityHashMap<>();

    private ObjectNode cityObjects;
    private GeometryBuilder geometryBuilder;

    private WeakReference<?> parent = new WeakReference<>(null);
    private CityGMLVersion targetCityGMLVersion = CityGMLVersion.v3_0;
    private boolean mapUnsupportedTypesToGenerics = true;
    private IdCreator idCreator = DefaultIdCreator.getInstance();
    private Metadata metadata;
    private Map<String, ExtensionInfo> extensions;
    private Map<String, ADEOfCityModel> extraRootProperties;
    private GenericAttributeTypes genericAttributeTypes = new GenericAttributeTypes();
    private Properties properties;

    private CityJSONBuilderHelper(CityJSONReader reader, CityJSONType type, CityJSONVersion version, ObjectMapper objectMapper, CityJSONContext context) {
        this.reader = reader;
        this.type = type;
        this.version = version;
        this.objectMapper = objectMapper;
        this.context = context;
    }

    static CityJSONBuilderHelper buildFor(CityJSONReader reader, ObjectNode content, ObjectNode globalScope, ObjectMapper objectMapper, CityJSONContext context) throws CityJSONBuildException {
        CityJSONType type = CityJSONType.fromValue(content.path(Fields.TYPE).asText());
        if (type == null) {
            throw new CityJSONBuildException("Expected \"" + Fields.TYPE + "\" property with one of the values: " +
                    Arrays.stream(CityJSONType.values())
                            .map(CityJSONType::toTypeName)
                            .collect(Collectors.joining(", ")));
        }

        if (content.path(Fields.VERSION).isValueNode()) {
            globalScope.set(Fields.VERSION, content.path(Fields.VERSION));
        }

        if (content.path(Fields.TRANSFORM).isObject()) {
            globalScope.set(Fields.TRANSFORM, content.path(Fields.TRANSFORM));
        }

        if (content.path(Fields.GEOMETRY_TEMPLATES).isObject()) {
            globalScope.set(Fields.GEOMETRY_TEMPLATES, content.path(Fields.GEOMETRY_TEMPLATES));
            globalScope.set(Fields.APPEARANCE, content.path(Fields.APPEARANCE));
        }

        CityJSONVersion version = CityJSONVersion.fromValue(globalScope.path(Fields.VERSION).asText());
        if (version == null) {
            throw new CityJSONBuildException(globalScope.get(Fields.VERSION) == null ?
                    "No CityJSON version found in document." :
                    "Unsupported CityJSON version " + globalScope.get(Fields.VERSION) + ".");
        }

        CityJSONBuilderHelper helper = new CityJSONBuilderHelper(reader, type, version, objectMapper, context);
        helper.cityObjects = helper.getOrPutObject(Fields.CITY_OBJECTS, content);

        ArrayNode vertices = helper.getOrPutArray(Fields.VERTICES, content);
        ObjectNode appearance = helper.getOrPutObject(Fields.APPEARANCE, content);
        ObjectNode templates = helper.getOrPutObject(Fields.GEOMETRY_TEMPLATES, globalScope);
        ObjectNode templatesAppearance = helper.getOrPutObject(Fields.APPEARANCE, globalScope);
        ObjectNode transform = helper.getOrPutObject(Fields.TRANSFORM, globalScope);

        helper.geometryBuilder = new GeometryBuilder(vertices, templates, appearance, templatesAppearance, helper);
        helper.geometryBuilder.getVerticesBuilder().applyTransformation(transform);

        return helper;
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

    ObjectNode getCityObjects() {
        return cityObjects;
    }

    boolean hasGlobalAppearances() {
        return geometryBuilder.hasGlobalAppearances();
    }

    List<Appearance> getGlobalAppearances() {
        return geometryBuilder.getGlobalAppearances();
    }

    public CityGMLVersion getTargetCityGMLVersion() {
        return targetCityGMLVersion;
    }

    void setTargetCityGMLVersion(CityGMLVersion targetCityGMLVersion) {
        this.targetCityGMLVersion = Objects.requireNonNull(targetCityGMLVersion, "The target CityGML version must not be null.");
    }

    public boolean isMapUnsupportedTypesToGenerics() {
        return mapUnsupportedTypesToGenerics;
    }

    void setMapUnsupportedTypesToGenerics(boolean mapUnsupportedTypesToGenerics) {
        this.mapUnsupportedTypesToGenerics = mapUnsupportedTypesToGenerics;
    }

    public boolean isTransformTemplateGeometries() {
        return geometryBuilder.isTransformTemplateGeometries();
    }

    void setTransformTemplateGeometries(boolean transformTemplateGeometries) {
        geometryBuilder.setTransformTemplateGeometries(transformTemplateGeometries);
    }

    public boolean isAssignAppearancesToImplicitGeometries() {
        return geometryBuilder.isAssignAppearancesToImplicitGeometries();
    }

    void setAssignAppearancesToImplicitGeometries(boolean assignAppearancesToImplicitGeometries) {
        geometryBuilder.setAssignAppearancesToImplicitGeometries(assignAppearancesToImplicitGeometries);
    }

    public IdCreator getIdCreator() {
        return idCreator;
    }

    void setIdCreator(IdCreator idCreator) {
        this.idCreator = Objects.requireNonNull(idCreator, "The ID creator must not be null.");
    }

    public LodMapper getLodMapper() {
        return geometryBuilder.getLodMapper();
    }

    void setLodMapper(LodMapper lodMapper) {
        geometryBuilder.setLodMapper(lodMapper);
    }

    TemplateInfo getTemplateInfo() {
        return geometryBuilder.getTemplateInfo();
    }

    void setTemplateInfo(TemplateInfo templateInfo) {
        geometryBuilder.setTemplateInfo(templateInfo);
    }

    public Metadata getMetadata() {
        return metadata;
    }

    void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public boolean hasExtensions() {
        return extensions != null && !extensions.isEmpty();
    }

    public Collection<ExtensionInfo> getExtensions() {
        return hasExtensions() ? extensions.values() : Collections.emptyList();
    }

    public ExtensionInfo getExtension(String name) {
        return hasExtensions() ? extensions.get(name) : null;
    }

    void setExtensions(Map<String, ExtensionInfo> extensions) {
        this.extensions = extensions;
    }

    public boolean hasExtraRootProperties() {
        return extraRootProperties != null && !extraRootProperties.isEmpty();
    }

    public <T extends ADEOfCityModel> T getExtraRootProperty(String propertyName, Class<T> type) {
        if (hasExtraRootProperties()) {
            ADEOfCityModel property = extraRootProperties.get(propertyName);
            if (type.isInstance(property)) {
                return type.cast(property);
            }
        }

        return null;
    }

    void setExtraRootProperties(Map<String, ADEOfCityModel> extraRootProperties) {
        this.extraRootProperties = extraRootProperties;
        GenericAttributeTypes genericAttributeTypes = getExtraRootProperty(GenericAttributeTypes.PROPERTY_NAME, GenericAttributeTypes.class);
        if (genericAttributeTypes != null) {
            this.genericAttributeTypes = genericAttributeTypes;
        }
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

    public JsonNode consumeProperty(String propertyName, JsonNode node) {
        JsonNode property = node.path(propertyName);
        if (node.isObject()) {
            ((ObjectNode) node).remove(propertyName);
        }

        return property;
    }

    public AbstractGenericAttribute<?> getGenericAttribute(String name, JsonNode node) throws CityJSONBuildException, CityJSONReadException {
        GenericAttributeType type = genericAttributeTypes.getType(name);
        if (type == null) {
            if (node.isNumber()) {
                if (node.isIntegralNumber()) {
                    type = GenericAttributeType.INT_ATTRIBUTE;
                } else {
                    type = GenericAttributeType.DOUBLE_ATTRIBUTE;
                }
            } else if (node.isTextual()) {
                if (GenericAttributeTypeParser.isLocalDate(node.asText())) {
                    type = GenericAttributeType.DATE_ATTRIBUTE;
                } else if (GenericAttributeTypeParser.isUri(node.asText())) {
                    type = GenericAttributeType.URI_ATTRIBUTE;
                } else {
                    type = GenericAttributeType.STRING_ATTRIBUTE;
                }
            } else if (node.isArray()) {
                type = GenericAttributeType.GENERIC_ATTRIBUTE_SET;
            } else if (node.isObject()) {
                JsonNode value = node.get("value");
                if (value != null) {
                    if (value.isNumber() && node.path("uom").isTextual()) {
                        type = GenericAttributeType.MEASURE_ATTRIBUTE;
                    } else if (value.isTextual() && node.path("codeSpace").isTextual()) {
                        type = GenericAttributeType.CODE_ATTRIBUTE;
                    } else {
                        return getGenericAttribute(name, value);
                    }
                } else {
                    type = GenericAttributeType.GENERIC_ATTRIBUTE_SET;
                }
            } else {
                type = GenericAttributeType.STRING_ATTRIBUTE;
            }
        }

        AbstractGenericAttribute<?> attribute = getObject(type.toTypeName(), node, AbstractGenericAttribute.class);
        attribute.setName(name);
        return attribute;
    }

    public Map<Double, List<JsonNode>> groupGeometriesByLod(JsonNode geometries) {
        return geometryBuilder.groupGeometriesByLod(geometries);
    }

    public GeometryObject getGeometry(AbstractFeature object, JsonNode geometry, int lod) {
        return getGeometry(object, geometry, lod, null);
    }

    public GeometryObject getGeometry(AbstractFeature object, JsonNode geometry, int lod, BoundaryFilter filter) {
        return geometryBuilder.getGeometry(object, geometry, lod, filter);
    }

    public GeometryObject getGeometry(AbstractFeature object, JsonNode geometry) {
        return getGeometry(object, geometry, geometry.path(Fields.LOD).asInt(-1));
    }

    public Map<Integer, List<GeometryObject>> getGeometries(AbstractFeature object, JsonNode geometries) {
        return getGeometries(object, geometries, null);
    }

    public Map<Integer, List<GeometryObject>> getGeometries(AbstractFeature object, JsonNode geometries, BoundaryFilter filter) {
        return geometryBuilder.getGeometries(object, geometries, filter);
    }

    public void addGeometries(AbstractSpace object, JsonNode geometries) {
        addGeometries(object, geometries, null);
    }

    public void addGeometries(AbstractSpace object, JsonNode geometries, BoundaryFilter filter) {
        geometryBuilder.addGeometries(object, geometries, filter);
    }

    public void addGeometries(AbstractThematicSurface boundary, JsonNode geometries) {
        geometryBuilder.addGeometries(boundary, geometries);
    }

    public void buildStandardObjectClassifier(StandardObjectClassifier object, Attributes attributes) {
        JsonNode classifier = attributes.consume("class");
        if (classifier.isTextual()) {
            object.setClassifier(new Code(classifier.asText()));
        }

        JsonNode function = attributes.consume("function");
        if (function.isTextual()) {
            object.getFunctions().add(new Code(function.asText()));
        }

        JsonNode usage = attributes.consume("usage");
        if (usage.isTextual()) {
            object.getUsages().add(new Code(usage.asText()));
        }
    }

    public void buildAsTopLevelObject(String identifier) {
        reader.buildAsTopLevelObject(identifier);
    }

    public ObjectNode getCityObjectNode(String identifier) {
        JsonNode node = cityObjects.path(identifier);
        return node.isObject() ? (ObjectNode) node : null;
    }

    public String getCityObjectType(String identifier) {
        return cityObjects.path(identifier).path(Fields.TYPE).asText();
    }

    public AbstractFeature getCityObject(String identifier) throws CityJSONBuildException, CityJSONReadException {
        return getCityObject(identifier, AbstractFeature.class);
    }

    public <T extends AbstractFeature> T getCityObject(String identifier, Class<T> type) throws CityJSONBuildException, CityJSONReadException {
        T cityObject = getObject(cityObjects.get(identifier), type);
        if (cityObject != null) {
            cityObject.setId(identifier);
        }

        return cityObject;
    }

    public <T> T getObject(JsonNode node, Class<T> type) throws CityJSONBuildException, CityJSONReadException {
        return node != null ? getObject(node.path(Fields.TYPE).asText(), node, type) : null;
    }

    public <T> T getObject(String name, JsonNode node, Class<T> type) throws CityJSONBuildException, CityJSONReadException {
        if (node != null) {
            JsonObjectBuilder<T> builder = context.getBuilder(name, version, type);

            if (builder == null && mapUnsupportedTypesToGenerics) {
                name = version == CityJSONVersion.v1_1 ?
                        "+GenericCityObject" :
                        "GenericCityObject";
                builder = context.getBuilder(name, version, type);
            }

            if (builder != null) {
                if (builder instanceof TypeMapper typeMapper) {
                    String mapping = typeMapper.mapType(node, type);
                    if (mapping != null && !name.equals(mapping)) {
                        return getObject(mapping, node, type);
                    }
                }

                return processObject(node, builder);
            }
        }

        return null;
    }

    public <T> T getObjectUsingBuilder(JsonNode node, Class<? extends JsonObjectBuilder<T>> type) throws CityJSONBuildException, CityJSONReadException {
        return getObjectUsingBuilder(node, getOrCreateBuilder(type));
    }

    public <T> T getObjectUsingBuilder(JsonNode node, JsonObjectBuilder<T> builder) throws CityJSONBuildException, CityJSONReadException {
        return node != null ? processObject(node, builder) : null;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private <T> T processObject(JsonNode node, JsonObjectBuilder<T> builder) throws CityJSONBuildException, CityJSONReadException {
        WeakReference<?> previous = parent;
        try {
            T object = builder.createObject(node, previous.get());
            if (object == null) {
                throw new CityJSONBuildException("The builder " + builder.getClass().getName() + " created a null value.");
            }

            parent = new WeakReference<>(object);
            boolean isObject = node.isObject() && node.path(Fields.TYPE).isTextual();
            boolean isCityObject = isObject && builder instanceof AbstractFeatureAdapter;
            boolean isSemanticObject = isObject && builder instanceof AbstractSemanticObjectAdapter;

            if (targetCityGMLVersion != CityGMLVersion.v3_0 && builder instanceof AbstractSpaceAdapter adapter) {
                AbstractSpace space = (AbstractSpace) object;
                space.getDeprecatedProperties();
                geometryBuilder.setMultiSurfaceProviders(space, adapter.getMultiSurfaceProviders(space));
            }

            Attributes attributes = isCityObject || isSemanticObject ?
                    createAttributes((ObjectNode) node) :
                    new Attributes();

            builder.buildObject(object, attributes, node, previous.get(), this);

            // process remaining attributes
            if (!attributes.isEmpty()) {
                processAttributes(attributes, object, node);
            }

            // process remaining children
            if (isCityObject && !(object instanceof ADEObject)) {
                processChildren(node);
            }

            return object;
        } finally {
            parent = previous;
        }
    }

    private void processAttributes(Attributes attributes, Object parent, JsonNode node) throws CityJSONBuildException, CityJSONReadException {
        boolean supportsGenericAttributes = parent instanceof AbstractCityObject;

        while (!attributes.isEmpty()) {
            Map.Entry<String, JsonNode> entry = attributes.consumeNext();
            String name = entry.getKey();

            JsonObjectBuilder<?> attributeBuilder = context.getBuilder(name, version);
            if (attributeBuilder != null) {
                getAttribute(attributes, node, parent, attributeBuilder);
            } else if (supportsGenericAttributes) {
                AbstractGenericAttribute<?> attribute = getGenericAttribute(name, entry.getValue());
                ((AbstractCityObject) parent).getGenericAttributes().add(new AbstractGenericAttributeProperty(attribute));
            }
        }
    }

    private <T> void getAttribute(Attributes attributes, JsonNode node, Object parent, JsonObjectBuilder<T> builder) throws CityJSONBuildException, CityJSONReadException {
        T object = builder.createObject(node, parent);
        if (object == null) {
            throw new CityJSONBuildException("The builder " + builder.getClass().getName() + " created a null value.");
        }

        builder.buildObject(object, attributes, node, parent, this);
    }

    private void processChildren(JsonNode node) throws CityJSONBuildException, CityJSONReadException {
        for (JsonNode child : node.path(Fields.CHILDREN)) {
            String type = getCityObjectType(child.asText());
            JsonObjectBuilder<?> childBuilder = context.getBuilder(type, version);
            if (childBuilder != null) {
                processObject(getCityObjectNode(child.asText()), childBuilder);
            }
        }
    }

    public <T> JsonObjectBuilder<T> getOrCreateBuilder(Class<? extends JsonObjectBuilder<T>> type) throws CityJSONBuildException {
        JsonObjectBuilder<?> cachedBuilder = builderCache.get(type);
        if (cachedBuilder != null && type.isAssignableFrom(cachedBuilder.getClass())) {
            return type.cast(cachedBuilder);
        } else {
            try {
                JsonObjectBuilder<T> builder = type.getDeclaredConstructor().newInstance();
                builderCache.put(type, builder);
                return builder;
            } catch (Exception e) {
                throw new CityJSONBuildException("The builder " + type.getName() + " lacks a default constructor.");
            }
        }
    }

    void removeChildren(JsonNode parent, String parentId, Set<String> retain) {
        JsonNode children = parent.path(Fields.CHILDREN);
        if (children.isArray()) {
            for (JsonNode element : children) {
                String childId = element.asText();
                if (!retain.contains(childId)) {
                    JsonNode child = cityObjects.path(childId);
                    JsonNode parents = child.path(Fields.PARENTS);
                    if (parents.size() > 1) {
                        Iterator<JsonNode> iter = parents.elements();
                        while (iter.hasNext()) {
                            if (parentId.equals(iter.next().asText())) {
                                iter.remove();
                                break;
                            }
                        }
                    } else {
                        cityObjects.remove(childId);
                        removeChildren(child, childId, retain);
                    }
                }
            }
        }
    }

    private Attributes createAttributes(ObjectNode node) {
        Attributes attributes = new Attributes();

        Iterator<Map.Entry<String, JsonNode>> iterator = node.fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = iterator.next();
            String name = entry.getKey();
            JsonNode value = entry.getValue();

            switch (name) {
                case Fields.TYPE:
                case Fields.GEOMETRY:
                case Fields.CHILDREN:
                case Fields.PARENTS:
                case Fields.PARENT:
                    continue;
                case Fields.ATTRIBUTES:
                    Iterator<Map.Entry<String, JsonNode>> attrIterator = value.fields();
                    while (attrIterator.hasNext()) {
                        Map.Entry<String, JsonNode> attr = attrIterator.next();
                        attributes.add(attr.getKey(), attr.getValue());
                    }
                    break;
                default:
                    attributes.add(name, value);
            }

            iterator.remove();
        }

        return attributes;
    }
}
