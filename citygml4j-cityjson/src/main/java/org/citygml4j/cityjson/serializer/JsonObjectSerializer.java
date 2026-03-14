/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.serializer;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.atteo.classindex.IndexSubclasses;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;

@IndexSubclasses
public interface JsonObjectSerializer<T> {
    default String createType(T object, CityJSONVersion version) throws CityJSONSerializeException {
        return null;
    }

    void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException;
}
