/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util.composite;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;

import java.util.Objects;


public abstract class CompositeJsonObjectSerializer<T> implements JsonObjectSerializer<T> {
    private final Class<? extends JsonObjectSerializer<T>> serializer;

    @SuppressWarnings("unchecked")
    public <S extends JsonObjectSerializer<? super T>> CompositeJsonObjectSerializer(Class<S> adapter) {
        this.serializer = Objects.requireNonNull((Class<? extends JsonObjectSerializer<T>>) adapter, "Object serializer must not be null.");
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        helper.getOrCreateSerializer(serializer).writeObject(object, node, helper);
    }
}
