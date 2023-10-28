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

package org.citygml4j.cityjson.adapter.vegetation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
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
import org.citygml4j.core.model.vegetation.SolitaryVegetationObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.measures.Length;

@CityJSONElements({
        @CityJSONElement(name = "SolitaryVegetationObject", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "SolitaryVegetationObject", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "SolitaryVegetationObject", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class SolitaryVegetationObjectAdapter extends AbstractVegetationObjectAdapter<SolitaryVegetationObject> {

    @Override
    public SolitaryVegetationObject createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new SolitaryVegetationObject();
    }

    @Override
    public void buildObject(SolitaryVegetationObject object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        JsonNode species = attributes.consume("species");
        if (species.isTextual()) {
            object.setSpecies(new Code(species.asText()));
        }

        JsonNode height = attributes.consume("height");
        if (height.isNumber()) {
            object.setHeight(new Length(height.asDouble(), "m"));
        }

        JsonNode trunkDiameter = attributes.consume("trunkDiameter");
        if (trunkDiameter.isNumber()) {
            object.setTrunkDiameter(new Length(trunkDiameter.asDouble(), "m"));
        }

        JsonNode crownDiameter = attributes.consume("crownDiameter");
        if (crownDiameter.isNumber()) {
            object.setCrownDiameter(new Length(crownDiameter.asDouble(), "m"));
        }

        JsonNode rootBallDiameter = attributes.consume("rootBallDiameter");
        if (rootBallDiameter.isNumber()) {
            object.setRootBallDiameter(new Length(rootBallDiameter.asDouble(), "m"));
        }

        JsonNode maxRootBallDepth = attributes.consume("maxRootBallDepth");
        if (maxRootBallDepth.isNumber()) {
            object.setMaxRootBallDepth(new Length(maxRootBallDepth.asDouble(), "m"));
        }
    }

    @Override
    public String createType(SolitaryVegetationObject object, CityJSONVersion version) throws CityJSONSerializeException {
        return "SolitaryVegetationObject";
    }

    @Override
    public void writeObject(SolitaryVegetationObject object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);

        if (object.getSpecies() != null && object.getSpecies().getValue() != null) {
            attributes.put("species", object.getSpecies().getValue());
        }

        if (object.getHeight() != null && object.getHeight().getValue() != null) {
            attributes.put("height", object.getHeight().getValue());
        }

        if (object.getTrunkDiameter() != null && object.getTrunkDiameter().getValue() != null) {
            attributes.put("trunkDiameter", object.getTrunkDiameter().getValue());
        }

        if (object.getCrownDiameter() != null && object.getCrownDiameter().getValue() != null) {
            attributes.put("crownDiameter", object.getCrownDiameter().getValue());
        }

        if (object.getRootBallDiameter() != null && object.getRootBallDiameter().getValue() != null) {
            attributes.put("rootBallDiameter", object.getRootBallDiameter().getValue());
        }

        if (object.getMaxRootBallDepth() != null && object.getMaxRootBallDepth().getValue() != null) {
            attributes.put("maxRootBallDepth", object.getMaxRootBallDepth().getValue());
        }
    }
}
