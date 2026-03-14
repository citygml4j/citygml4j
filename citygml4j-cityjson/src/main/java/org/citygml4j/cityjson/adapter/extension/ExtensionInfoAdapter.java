/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.extension;

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

public class ExtensionInfoAdapter implements JsonObjectBuilder<ExtensionInfo>, JsonObjectSerializer<ExtensionInfo> {

    @Override
    public ExtensionInfo createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new ExtensionInfo();
    }

    @Override
    public void buildObject(ExtensionInfo object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode url = node.path("url");
        if (url.isTextual()) {
            object.setSchemaLocation(url.asText());
        }

        JsonNode version = node.path("version");
        if (version.isTextual()) {
            object.setVersion(version.asText());
        }
    }

    @Override
    public void writeObject(ExtensionInfo object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        node.put("url", object.getSchemaLocation() != null ? object.getSchemaLocation() : "");
        node.put("version", object.getVersion() != null ? object.getVersion() : "");
    }
}
