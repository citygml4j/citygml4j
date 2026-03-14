/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.builder;

import com.fasterxml.jackson.databind.JsonNode;
import org.atteo.classindex.IndexSubclasses;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;

@IndexSubclasses
public interface JsonObjectBuilder<T> {
    T createObject(JsonNode node, Object parent) throws CityJSONBuildException;

    void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException;
}
