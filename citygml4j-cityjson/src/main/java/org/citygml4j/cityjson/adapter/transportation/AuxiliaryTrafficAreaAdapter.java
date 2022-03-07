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

package org.citygml4j.cityjson.adapter.transportation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.core.AbstractThematicSurfaceAdapter;
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
import org.citygml4j.core.model.transportation.AuxiliaryTrafficArea;
import org.xmlobjects.gml.model.basictypes.Code;

@CityJSONElements({
        @CityJSONElement(name = "AuxiliaryTrafficArea", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "AuxiliaryTrafficArea", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class AuxiliaryTrafficAreaAdapter extends AbstractThematicSurfaceAdapter<AuxiliaryTrafficArea> {

    @Override
    public AuxiliaryTrafficArea createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new AuxiliaryTrafficArea();
    }

    @Override
    public void buildObject(AuxiliaryTrafficArea object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        JsonNode surfaceMaterial = attributes.consume("surfaceMaterial");
        if (surfaceMaterial.isTextual()) {
            object.setSurfaceMaterial(new Code(surfaceMaterial.asText()));
        }
    }

    @Override
    public String createType(AuxiliaryTrafficArea object, CityJSONVersion version) throws CityJSONSerializeException {
        return "AuxiliaryTrafficArea";
    }

    @Override
    public void writeObject(AuxiliaryTrafficArea object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        helper.writeStandardObjectClassifier(object, node);

        if (object.getSurfaceMaterial() != null && object.getSurfaceMaterial().getValue() != null) {
            node.put("surfaceMaterial", object.getSurfaceMaterial().getValue());
        }
    }
}
