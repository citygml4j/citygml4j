/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.waterbody;

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
import org.citygml4j.core.model.waterbody.WaterSurface;
import org.xmlobjects.gml.model.basictypes.Code;

@CityJSONElements({
        @CityJSONElement(name = "WaterSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "WaterSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "WaterSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class WaterSurfaceAdapter extends AbstractThematicSurfaceAdapter<WaterSurface> {

    @Override
    public WaterSurface createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new WaterSurface();
    }

    @Override
    public void buildObject(WaterSurface object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        JsonNode waterLevel = attributes.consume("waterLevel");
        if (waterLevel.isTextual()) {
            object.setWaterLevel(new Code(waterLevel.asText()));
        }
    }

    @Override
    public String createType(WaterSurface object, CityJSONVersion version) throws CityJSONSerializeException {
        return "WaterSurface";
    }

    @Override
    public void writeObject(WaterSurface object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);

        if (object.getWaterLevel() != null && object.getWaterLevel().getValue() != null) {
            node.put("waterLevel", object.getWaterLevel().getValue());
        }
    }
}
