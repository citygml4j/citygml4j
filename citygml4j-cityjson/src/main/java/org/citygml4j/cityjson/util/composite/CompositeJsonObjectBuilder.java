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
