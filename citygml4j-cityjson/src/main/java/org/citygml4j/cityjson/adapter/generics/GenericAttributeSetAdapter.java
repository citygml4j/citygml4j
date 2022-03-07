/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
import com.fasterxml.jackson.databind.node.ArrayNode;
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
import org.citygml4j.core.model.core.AbstractGenericAttribute;
import org.citygml4j.core.model.core.AbstractGenericAttributeProperty;
import org.citygml4j.core.model.generics.GenericAttributeSet;

import java.util.Iterator;
import java.util.Map;

@CityJSONElements({
        @CityJSONElement(name = "GenericAttributeSet", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "GenericAttributeSet", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class GenericAttributeSetAdapter extends AbstractGenericAttributeAdapter<GenericAttributeSet> {

    @Override
    public GenericAttributeSet createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new GenericAttributeSet();
    }

    @Override
    public void buildObject(GenericAttributeSet object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        if (node.isArray()) {
            for (JsonNode value : node) {
                AbstractGenericAttribute<?> attribute = helper.getGenericAttribute("value", value);
                object.getValue().add(new AbstractGenericAttributeProperty(attribute));
            }
        } else if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> iterator = node.fields();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = iterator.next();
                AbstractGenericAttribute<?> attribute = helper.getGenericAttribute(entry.getKey(), entry.getValue());
                object.getValue().add(new AbstractGenericAttributeProperty(attribute));
            }
        }
    }

    @Override
    public void writeObject(GenericAttributeSet object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.getName() != null && object.isSetValue()) {
            String name = null;
            boolean asArray = true;

            for (AbstractGenericAttributeProperty property : object.getValue()) {
                if (property.getObject() != null) {
                    AbstractGenericAttribute<?> genericAttribute = property.getObject();
                    if (name == null) {
                        name = genericAttribute.getName();
                    } else {
                        if (!name.equalsIgnoreCase(genericAttribute.getName())) {
                            asArray = false;
                            break;
                        }
                    }
                }
            }

            JsonNode genericAttributeSet = asArray ?
                    node.putArray(object.getName()) :
                    node.putObject(object.getName());

            for (AbstractGenericAttributeProperty property : object.getValue()) {
                if (property.getObject() != null) {
                    ObjectNode genericAttribute = helper.getObject(property.getObject());
                    if (genericAttribute != null && !genericAttribute.isEmpty()) {
                        if (asArray) {
                            JsonNode value = genericAttribute.get(genericAttribute.fieldNames().next());
                            ((ArrayNode) genericAttributeSet).add(value);
                        } else {
                            ((ObjectNode) genericAttributeSet).setAll(genericAttribute);
                        }
                    }
                }
            }

            registerType(object.getName(), GenericAttributeType.GENERIC_ATTRIBUTE_SET, helper);
        }
    }
}
