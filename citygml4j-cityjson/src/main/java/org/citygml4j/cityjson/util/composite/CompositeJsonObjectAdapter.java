/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util.composite;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;

import java.util.Objects;

public abstract class CompositeJsonObjectAdapter<T> implements JsonObjectBuilder<T>, JsonObjectSerializer<T> {
    private final Class<? extends JsonObjectBuilder<T>> builder;
    private final Class<? extends JsonObjectSerializer<T>> serializer;

    @SuppressWarnings("unchecked")
    public <S extends JsonObjectBuilder<? super T> & JsonObjectSerializer<? super T>> CompositeJsonObjectAdapter(Class<S> adapter) {
        this.builder = Objects.requireNonNull((Class<? extends JsonObjectBuilder<T>>) adapter, "Object adapter must not be null.");
        this.serializer = (Class<? extends JsonObjectSerializer<T>>) adapter;
    }

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        helper.getOrCreateBuilder(builder).buildObject(object, attributes, node, parent, helper);
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        helper.getOrCreateSerializer(serializer).writeObject(object, node, helper);
    }
}
