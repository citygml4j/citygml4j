/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
