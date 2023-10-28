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
import org.citygml4j.core.model.generics.MeasureAttribute;
import org.xmlobjects.gml.model.basictypes.Measure;

@CityJSONElements({
        @CityJSONElement(name = "MeasureAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "MeasureAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "MeasureAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class MeasureAttributeAdapter extends AbstractGenericAttributeAdapter<MeasureAttribute> {

    @Override
    public MeasureAttribute createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new MeasureAttribute();
    }

    @Override
    public void buildObject(MeasureAttribute object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        Measure measure;
        if (node.isObject()) {
            measure = new Measure(node.path("value").asDouble());
            JsonNode uom = node.path("uom");
            if (uom.isTextual()) {
                measure.setUom(uom.asText());
            }
        } else {
            measure = new Measure(node.asDouble());
        }

        object.setValue(measure);
    }

    @Override
    public void writeObject(MeasureAttribute object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.getName() != null && object.isSetValue()) {
            if (object.getValue().getUom() != null) {
                ObjectNode value = node.putObject(object.getName());
                value.put("value", object.getValue().getValue());
                value.put("uom", object.getValue().getUom());
            } else {
                node.put(object.getName(), object.getValue().getValue());
            }

            registerType(object.getName(), GenericAttributeType.MEASURE_ATTRIBUTE, helper);
        }
    }
}
