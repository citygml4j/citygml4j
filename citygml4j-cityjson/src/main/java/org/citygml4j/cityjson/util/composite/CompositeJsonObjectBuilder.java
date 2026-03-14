/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util.composite;

import com.fasterxml.jackson.databind.JsonNode;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;

import java.util.Objects;

public abstract class CompositeJsonObjectBuilder<T> implements JsonObjectBuilder<T> {
    private final Class<? extends JsonObjectBuilder<T>> builder;

    @SuppressWarnings("unchecked")
    public <S extends JsonObjectBuilder<? super T>> CompositeJsonObjectBuilder(Class<S> adapter) {
        this.builder = Objects.requireNonNull((Class<? extends JsonObjectBuilder<T>>) adapter, "Object builder must not be null.");
    }

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        helper.getOrCreateBuilder(builder).buildObject(object, attributes, node, parent, helper);
    }
}
