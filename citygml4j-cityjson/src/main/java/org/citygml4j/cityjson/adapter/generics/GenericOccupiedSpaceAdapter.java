/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.core.AbstractGenericAttributeProperty;
import org.citygml4j.core.model.generics.GenericOccupiedSpace;
import org.citygml4j.core.model.generics.StringAttribute;

@CityJSONElements({
        @CityJSONElement(name = "GenericCityObject", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "+GenericCityObject", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "GenericCityObject", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class GenericOccupiedSpaceAdapter extends AbstractOccupiedSpaceAdapter<GenericOccupiedSpace> {

    @Override
    public GenericOccupiedSpace createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new GenericOccupiedSpace();
    }

    @Override
    public void buildObject(GenericOccupiedSpace object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        if (helper.isMapUnsupportedTypesToGenerics()) {
            String type = node.path(Fields.TYPE).asText();
            if ((helper.getVersion() == CityJSONVersion.v1_1 && !type.equals("+GenericCityObject"))
                    || !type.equals("GenericCityObject")) {
                if (type.startsWith("+")) {
                    type = type.substring(1);
                }

                StringAttribute typeAttribute = new StringAttribute(CityJSONConstants.GENERIC_TYPE_ATTRIBUTE, type);
                object.getGenericAttributes().add(new AbstractGenericAttributeProperty(typeAttribute));
            }
        }
    }

    @Override
    public String createType(GenericOccupiedSpace object, CityJSONVersion version) throws CityJSONSerializeException {
        return version == CityJSONVersion.v1_1 ?
                "+GenericCityObject" :
                "GenericCityObject";
    }

    @Override
    public void writeObject(GenericOccupiedSpace object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);

        if (helper.getVersion() == CityJSONVersion.v1_1 && !helper.isSetExternalExtension("Generic")) {
            helper.addExternalExtension("Generic",
                    "https://www.cityjson.org/extensions/download/generic.ext.json",
                    "1.0");
        }
    }
}
