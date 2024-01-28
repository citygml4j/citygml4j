/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.generics;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.generics.GenericAttributeType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.generics.CodeAttribute;
import org.xmlobjects.gml.model.basictypes.Code;

@CityJSONElements({
        @CityJSONElement(name = "CodeAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "CodeAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "CodeAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class CodeAttributeAdapter extends AbstractGenericAttributeAdapter<CodeAttribute> {

    @Override
    public CodeAttribute createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new CodeAttribute();
    }

    @Override
    public void buildObject(CodeAttribute object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        Code code;
        if (node.isObject()) {
            code = new Code(node.path("value").asText());
            JsonNode uom = node.path("codeSpace");
            if (uom.isTextual()) {
                code.setCodeSpace(uom.asText());
            }
        } else {
            code = new Code(node.asText());
        }

        object.setValue(code);
    }

    @Override
    public void writeObject(CodeAttribute object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.getName() != null && object.isSetValue()) {
            if (object.getValue().getCodeSpace() != null) {
                ObjectNode value = node.putObject(object.getName());
                value.put("value", object.getValue().getValue());
                value.put("codeSpace", object.getValue().getCodeSpace());
            } else {
                node.put(object.getName(), object.getValue().getValue());
            }

            registerType(object.getName(), GenericAttributeType.CODE_ATTRIBUTE, helper);
        }
    }
}
