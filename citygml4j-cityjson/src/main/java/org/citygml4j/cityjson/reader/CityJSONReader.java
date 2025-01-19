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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.extension.ExtensionInfo;
import org.citygml4j.cityjson.adapter.extension.ExtensionInfoAdapter;
import org.citygml4j.cityjson.adapter.metadata.MetadataAdapter;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.util.lod.LodMapper;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.ADEOfCityModel;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.util.Properties;

import java.io.IOException;
import java.util.*;

public abstract class CityJSONReader implements AutoCloseable {
    final JsonParser reader;
    final ObjectMapper objectMapper;
    final CityJSONContext context;
    final ObjectNode globalScope;
    final Deque<String> topLevelObjects = new ArrayDeque<>();

    CityJSONInputFilter filter;
    Metadata metadata;
    Map<String, ExtensionInfo> extensions;
    Map<String, ADEOfCityModel> extraRootProperties;

    CityGMLVersion targetCityGMLVersion;
    boolean mapUnsupportedTypesToGenerics = true;
    boolean transformTemplateGeometries;
    boolean assignAppearancesToImplicitGeometries;
    ReferenceResolver resolver;
    LodMapper lodMapper;
    IdCreator idCreator;
    Properties properties;

    CityJSONReader(JsonParser reader, ObjectMapper mapper, CityJSONContext context) {
        this.reader = reader;
        this.objectMapper = mapper;
        this.context = context;
        globalScope = mapper.createObjectNode();
    }

    public abstract boolean hasNext() throws CityJSONReadException;

    public abstract AbstractFeature next() throws CityJSONReadException;

    public Metadata getMetadata() throws CityJSONReadException {
        return hasNext() ? metadata : null;
    }

    public boolean hasExtensions() throws CityJSONReadException {
        return hasNext() && extensions != null && !extensions.isEmpty();
    }

    public Collection<ExtensionInfo> getExtensions() throws CityJSONReadException {
        return hasExtensions() ? extensions.values() : Collections.emptyList();
    }

    public ExtensionInfo getExtension(String name) throws CityJSONReadException {
        return hasExtensions() ? extensions.get(name) : null;
    }

    public boolean hasExtraRootProperties() throws CityJSONReadException {
        return hasNext() && extraRootProperties != null && !extraRootProperties.isEmpty();
    }

    public Collection<ADEOfCityModel> getExtraRootProperties() throws CityJSONReadException {
        return hasExtraRootProperties() ? extraRootProperties.values() : Collections.emptyList();
    }

    public <T extends ADEOfCityModel> T getExtraRootProperty(String propertyName, Class<T> type) throws CityJSONReadException {
        if (hasExtraRootProperties()) {
            ADEOfCityModel property = extraRootProperties.get(propertyName);
            if (type.isInstance(property)) {
                return type.cast(property);
            }
        }

        return null;
    }

    @Override
    public void close() throws CityJSONReadException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        } finally {
            globalScope.removeAll();
            metadata = null;

            if (extensions != null) {
                extensions.clear();
            }

            if (extraRootProperties != null) {
                extraRootProperties.clear();
            }
        }
    }

    void buildAsTopLevelObject(String identifier) {
        if (identifier != null && !identifier.isEmpty()) {
            topLevelObjects.push(identifier);
        }
    }

    CityJSONBuilderHelper createHelper(ObjectNode content, CityJSONBuilderHelper previous) throws CityJSONBuildException, CityJSONReadException {
        CityJSONBuilderHelper helper = CityJSONBuilderHelper.buildFor(this, content, globalScope, objectMapper, context);
        helper.setTargetCityGMLVersion(targetCityGMLVersion);
        helper.setMapUnsupportedTypesToGenerics(mapUnsupportedTypesToGenerics);
        helper.setTransformTemplateGeometries(transformTemplateGeometries);
        helper.setAssignAppearancesToImplicitGeometries(assignAppearancesToImplicitGeometries);
        helper.setProperties(properties);

        if (previous != null) {
            helper.setTemplateInfo(previous.getTemplateInfo());
        }

        if (idCreator != null) {
            helper.setIdCreator(idCreator);
        }

        if (lodMapper != null) {
            helper.setLodMapper(lodMapper);
        }

        if (helper.getType() == CityJSONType.CITYJSON) {
            createMetadata(content, helper);
            createExtensions(content, helper);
            createExtraRootProperties(content, helper);
        }

        helper.setMetadata(metadata);
        helper.setExtensions(extensions);
        helper.setExtraRootProperties(extraRootProperties);

        return helper;
    }

    private void createMetadata(ObjectNode content, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        metadata = helper.getObjectUsingBuilder(content.get(Fields.METADATA), MetadataAdapter.class);
        content.remove(Fields.METADATA);
    }

    private void createExtensions(ObjectNode content, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode node = content.path(Fields.EXTENSIONS);
        if (node.isObject()) {
            extensions = new HashMap<>();
            Iterator<Map.Entry<String, JsonNode>> iterator = node.fields();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = iterator.next();
                String name = entry.getKey();

                ExtensionInfo extensionInfo = helper.getObjectUsingBuilder(entry.getValue(), ExtensionInfoAdapter.class);
                if (extensionInfo != null) {
                    extensionInfo.setName(name);
                    this.extensions.put(name, extensionInfo);
                }
            }
        }
    }

    private void createExtraRootProperties(ObjectNode content, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        Iterator<Map.Entry<String, JsonNode>> iterator = content.fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = iterator.next();
            String name = entry.getKey();

            switch (name) {
                case Fields.TYPE:
                case Fields.VERSION:
                case Fields.TRANSFORM:
                case Fields.CITY_OBJECTS:
                case Fields.VERTICES:
                case Fields.METADATA:
                case Fields.EXTENSIONS:
                case Fields.APPEARANCE:
                case Fields.GEOMETRY_TEMPLATES:
                    continue;
            }

            ADEOfCityModel property = helper.getObject(name, entry.getValue(), ADEOfCityModel.class);
            if (property != null) {
                if (extraRootProperties == null) {
                    extraRootProperties = new HashMap<>();
                }

                extraRootProperties.put(name, property);
            }

            iterator.remove();
        }
    }

    static class TopLevelIterator implements Iterator<Map.Entry<String, JsonNode>> {
        private final CityJSONBuilderHelper helper;
        private final CityJSONInputFilter filter;
        private Map.Entry<String, JsonNode> next;

        private TopLevelIterator(CityJSONBuilderHelper helper, CityJSONInputFilter filter) {
            this.helper = helper;
            this.filter = filter;
        }

        static TopLevelIterator of(CityJSONBuilderHelper helper, CityJSONInputFilter filter) {
            return new TopLevelIterator(helper, filter);
        }

        @Override
        public boolean hasNext() {
            if (next == null) {
                Iterator<Map.Entry<String, JsonNode>> iterator = helper.getCityObjects().fields();
                while (iterator.hasNext()) {
                    Map.Entry<String, JsonNode> entry = iterator.next();
                    JsonNode object = entry.getValue();

                    if (object.isObject()) {
                        JsonNode parents = object.path(Fields.PARENTS);
                        if (parents.isEmpty()) {
                            iterator.remove();
                            String type = object.path(Fields.TYPE).asText();
                            if (filter == null || filter.accept(type)) {
                                next = entry;
                                break;
                            }
                        }
                    }
                }
            }

            return next != null;
        }

        @Override
        public Map.Entry<String, JsonNode> next() {
            if (hasNext()) {
                try {
                    return next;
                } finally {
                    next = null;
                }
            }

            throw new NoSuchElementException();
        }
    }
}
