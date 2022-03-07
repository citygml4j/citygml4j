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

package org.citygml4j.cityjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.CityJSONInputFactory;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONOutputFactory;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.ade.ADEException;
import org.citygml4j.core.ade.ADERegistry;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CityJSONContext {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, Map<CityJSONVersion, BuilderInfo>> builders = new ConcurrentHashMap<>();
    private final Map<String, Map<CityJSONVersion, SerializerInfo>> serializers = new ConcurrentHashMap<>();

    private CityJSONContext(ClassLoader classLoader) throws CityJSONContextException {
        loadBuilders(classLoader, true);
        loadSerializers(classLoader, true);

        try {
            ADERegistry registry = ADERegistry.getInstance();
            ExtensionLoader loader = ExtensionLoader.getInstance();
            registry.registerADELoader(loader, Extension.class);

            // load extension objects registered with the extension registry
            for (Extension extension : registry.getADEs(Extension.class)) {
                loadExtension(extension);
            }

            // unload extension objects available from the class loader
            // but not registered with the extension registry
            removeUnregisteredExtensionObjects();

            loader.addListener(this);
        } catch (ADEException e) {
            throw new CityJSONContextException("Failed to load CityJSON extensions.", e);
        }
    }

    public static CityJSONContext newInstance() throws CityJSONContextException {
        return newInstance(Thread.currentThread().getContextClassLoader());
    }

    public static CityJSONContext newInstance(ClassLoader classLoader) throws CityJSONContextException {
        return new CityJSONContext(classLoader);
    }

    public CityJSONInputFactory createCityJSONInputFactory() {
        return new CityJSONInputFactory(objectMapper, this);
    }

    public CityJSONOutputFactory createCityJSONOutputFactory(CityJSONVersion version) {
        return new CityJSONOutputFactory(version, objectMapper, this);
    }

    public CityJSONContext registerBuilder(JsonObjectBuilder<?> builder, String name, CityJSONVersion version) throws CityJSONContextException {
        registerBuilder(builder, name, null, version, false);
        return this;
    }

    public JsonObjectBuilder<?> getBuilder(String name, CityJSONVersion version) {
        BuilderInfo info = builders.getOrDefault(name, Collections.emptyMap()).get(version);
        return info != null ? info.builder : null;
    }

    @SuppressWarnings("unchecked")
    public <T> JsonObjectBuilder<T> getBuilder(String name, CityJSONVersion version, Class<T> objectType) {
        Objects.requireNonNull(objectType, "Object type must not be null.");
        BuilderInfo info = builders.getOrDefault(name, Collections.emptyMap()).get(version);
        return info != null && objectType.isAssignableFrom(info.objectType) ? (JsonObjectBuilder<T>) info.builder : null;
    }

    public Class<?> getObjectType(JsonObjectBuilder<?> builder) {
        for (Map<CityJSONVersion, BuilderInfo> infos : builders.values()) {
            for (BuilderInfo info : infos.values()) {
                if (info.builder == builder) {
                    return info.objectType;
                }
            }
        }

        return Object.class;
    }

    public <T> CityJSONContext registerSerializer(JsonObjectSerializer<T> serializer, Class<T> objectType, CityJSONVersion version) throws CityJSONContextException {
        registerSerializer(serializer, objectType, null, version, false);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> JsonObjectSerializer<T> getSerializer(Class<T> objectType, CityJSONVersion version) {
        SerializerInfo info = serializers.getOrDefault(objectType.getName(), Collections.emptyMap()).get(version);
        return info != null ? (JsonObjectSerializer<T>) info.serializer : null;
    }

    @SuppressWarnings("rawtypes")
    private void loadBuilders(ClassLoader classLoader, boolean failOnDuplicates) throws CityJSONContextException {
        for (Class<? extends JsonObjectBuilder> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .satisfying(c -> c.isAnnotationPresent(CityJSONElement.class) || c.isAnnotationPresent(CityJSONElements.class))
                .from(ClassIndex.getSubclasses(JsonObjectBuilder.class, classLoader))) {

            boolean isSetElement = type.isAnnotationPresent(CityJSONElement.class);
            boolean isSetElements = type.isAnnotationPresent(CityJSONElements.class);

            if (isSetElement && isSetElements) {
                throw new CityJSONContextException("The builder " + type.getName() + " uses both @CityJSONElement and @CityJSONElements.");
            }

            JsonObjectBuilder<?> builder;
            try {
                builder = type.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new CityJSONContextException("The builder " + type.getName() + " lacks a default constructor.", e);
            }

            if (isSetElement) {
                CityJSONElement element = type.getAnnotation(CityJSONElement.class);
                registerBuilder(builder, element.name(), element.schema(), element.version(), failOnDuplicates);
            } else if (isSetElements) {
                CityJSONElements elements = type.getAnnotation(CityJSONElements.class);
                for (CityJSONElement element : elements.value()) {
                    registerBuilder(builder, element.name(), element.schema(), element.version(), failOnDuplicates);
                }
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private void loadSerializers(ClassLoader classLoader, boolean failOnDuplicates) throws CityJSONContextException {
        for (Class<? extends JsonObjectSerializer> type : ClassFilter.only()
                .withoutModifiers(Modifier.ABSTRACT)
                .satisfying(c -> c.isAnnotationPresent(CityJSONElement.class) || c.isAnnotationPresent(CityJSONElements.class))
                .from(ClassIndex.getSubclasses(JsonObjectSerializer.class, classLoader))) {

            boolean isSetElement = type.isAnnotationPresent(CityJSONElement.class);
            boolean isSetElements = type.isAnnotationPresent(CityJSONElements.class);

            if (isSetElement && isSetElements) {
                throw new CityJSONContextException("The serializer " + type.getName() + " uses both @CityJSONElement and @CityJSONElements.");
            }

            JsonObjectSerializer<?> serializer;
            try {
                serializer = type.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new CityJSONContextException("The serializer " + type.getName() + " lacks a default constructor.", e);
            }

            Class<?> objectType = findObjectType(serializer);
            if (isSetElement) {
                CityJSONElement element = type.getAnnotation(CityJSONElement.class);
                registerSerializer(serializer, objectType, element.schema(), element.version(), failOnDuplicates);
            } else if (isSetElements) {
                CityJSONElements elements = type.getAnnotation(CityJSONElements.class);
                for (CityJSONElement element : elements.value()) {
                    registerSerializer(serializer, objectType, element.schema(), element.version(), failOnDuplicates);
                }
            }
        }
    }

    public void unloadBuilders(CityJSONVersion version) {
        if (version != null) {
            builders.values().forEach(v -> v.remove(version));
        }
    }

    public void unloadSerializers(CityJSONVersion version) {
        if (version != null) {
            serializers.values().forEach(v -> v.remove(version));
        }
    }

    private void registerBuilder(JsonObjectBuilder<?> builder, String name, String schema, CityJSONVersion version, boolean failOnDuplicates) throws CityJSONContextException {
        BuilderInfo info = new BuilderInfo(builder, schema, findObjectType(builder));
        BuilderInfo current = builders.computeIfAbsent(name, v -> new HashMap<>()).put(version, info);
        if (current != null && current.builder != builder && failOnDuplicates) {
            throw new CityJSONContextException("Two builders are registered for the CityJSON " +
                    version + " element " + name + ": " +
                    builder.getClass().getName() + " and " + current.builder.getClass().getName() + ".");
        }
    }

    private void registerSerializer(JsonObjectSerializer<?> serializer, Class<?> objectType, String schema, CityJSONVersion version, boolean failOnDuplicates) throws CityJSONContextException {
        SerializerInfo info = new SerializerInfo(serializer, schema);
        SerializerInfo current = serializers.computeIfAbsent(objectType.getName(), v -> new HashMap<>()).put(version, info);
        if (current != null && current.serializer != serializer && failOnDuplicates)
            throw new CityJSONContextException("Two serializers are registered for the object type " +
                    objectType.getName() + ": " +
                    serializer.getClass().getName() + " and " + current.getClass().getName() + ".");
    }

    private Class<?> findObjectType(JsonObjectBuilder<?> builder) throws CityJSONContextException {
        try {
            return builder.getClass().getMethod("createObject", JsonNode.class, Object.class).getReturnType();
        } catch (NoSuchMethodException e) {
            throw new CityJSONContextException("The builder " + builder.getClass().getName() + " lacks the createObject method.", e);
        }
    }

    private Class<?> findObjectType(JsonObjectSerializer<?> serializer) throws CityJSONContextException {
        Class<?> clazz = serializer.getClass();
        Class<?> objectType = null;

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isSynthetic() && Modifier.isPublic(method.getModifiers())) {
                Class<?> candidateType = null;
                Type[] parameters;

                switch (method.getName()) {
                    case "createType":
                        parameters = method.getGenericParameterTypes();
                        if (parameters.length == 2
                                && parameters[0] instanceof Class<?>
                                && parameters[1] == CityJSONVersion.class) {
                            candidateType = (Class<?>) parameters[0];
                        }
                        break;
                    case "writeObject":
                        parameters = method.getGenericParameterTypes();
                        if (parameters.length == 3
                                && parameters[0] instanceof Class<?>
                                && parameters[1] == ObjectNode.class
                                && parameters[2] == CityJSONSerializerHelper.class) {
                            return (Class<?>) parameters[0];
                        }
                        break;
                }

                if (candidateType != null) {
                    if (objectType != null && candidateType != objectType)
                        throw new CityJSONContextException("The serializer " + serializer.getClass().getName() +
                                " uses different object types: " +
                                objectType.getName() + " and " + candidateType.getName() + ".");

                    objectType = candidateType;
                }
            }
        }

        if (objectType == null) {
            throw new CityJSONContextException("The serializer " + serializer.getClass().getName() + " must " +
                    "implement at least one of the methods createType and writeObject.");
        }

        return objectType;
    }

    void loadExtension(Extension extension) throws ADEException {
        try {
            loadExtensionObjects(extension.getClass().getClassLoader());
        } catch (CityJSONContextException e) {
            throw new ADEException("Failed to load extension.", e);
        }
    }

    void unloadExtension(Extension extension) {
        unloadExtensionObjects(extension.getName());
    }

    private void loadExtensionObjects(ClassLoader classLoader) throws CityJSONContextException {
        loadBuilders(classLoader, false);
        loadSerializers(classLoader, false);
        removeUnregisteredExtensionObjects();
    }

    private void unloadExtensionObjects(String name) {
        builders.values().forEach(v -> v.values().removeIf(info -> info.schema.equals(name)));
        serializers.values().forEach(v -> v.values().removeIf(info -> info.schema.equals(name)));
    }

    private void removeUnregisteredExtensionObjects() {
        Set<String> extensionNames = ExtensionLoader.getInstance().getExtensionNames();
        Set<String> schemas = serializers.values().stream()
                .flatMap(map -> map.values().stream())
                .map(info -> info.schema).collect(Collectors.toSet());

        for (String schema : schemas) {
            if (!CityJSONConstants.CORE_SCHEMA.equals(schema)
                    && !extensionNames.contains(schema)) {
                unloadExtensionObjects(schema);
            }
        }
    }

    private static class BuilderInfo {
        final JsonObjectBuilder<?> builder;
        final String schema;
        final Class<?> objectType;

        BuilderInfo(JsonObjectBuilder<?> builder, String schema, Class<?> objectType) {
            this.builder = builder;
            this.schema = schema;
            this.objectType = objectType;
        }
    }

    private static class SerializerInfo {
        final JsonObjectSerializer<?> serializer;
        final String schema;

        SerializerInfo(JsonObjectSerializer<?> serializer, String schema) {
            this.serializer = serializer;
            this.schema = schema;
        }
    }
}
