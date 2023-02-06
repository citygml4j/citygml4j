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

public class ExtensionInfoAdapter implements JsonObjectBuilder<ExtensionInfo>, JsonObjectSerializer<ExtensionInfo>  {

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
