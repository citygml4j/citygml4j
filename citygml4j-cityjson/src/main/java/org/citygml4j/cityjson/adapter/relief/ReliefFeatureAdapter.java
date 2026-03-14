/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.relief;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractSpaceBoundaryAdapter;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.util.lod.LodMapper;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.relief.AbstractReliefComponentProperty;
import org.citygml4j.core.model.relief.ReliefFeature;
import org.citygml4j.core.model.relief.TINRelief;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CityJSONElements({
        @CityJSONElement(name = "TINRelief", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "TINRelief", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "TINRelief", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class ReliefFeatureAdapter extends AbstractSpaceBoundaryAdapter<ReliefFeature> {

    @Override
    public ReliefFeature createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new ReliefFeature();
    }

    @Override
    public void buildObject(ReliefFeature object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        Map<Double, List<JsonNode>> geometriesByLod = helper.groupGeometriesByLod(node.path(Fields.GEOMETRY));
        LodMapper lodMapper = helper.getLodMapper();
        lodMapper.buildMapping(geometriesByLod.keySet());

        for (int lod = 0; lod < 4; lod++) {
            List<JsonNode> geometries = geometriesByLod.getOrDefault(lodMapper.getMappingFor(lod), Collections.emptyList());
            for (JsonNode geometry : geometries) {
                ObjectNode objectNode = helper.createObject();
                objectNode.putArray(Fields.GEOMETRY).add(geometry);
                TINRelief tinRelief = helper.getObjectUsingBuilder(objectNode, TINReliefAdapter.class);
                if (tinRelief.getTin() != null) {
                    tinRelief.setLod(lod);
                    object.setLod(lod);
                    object.getReliefComponents().add(new AbstractReliefComponentProperty(tinRelief));
                }
            }
        }
    }

    @Override
    public void writeObject(ReliefFeature object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetReliefComponents()) {
            for (AbstractReliefComponentProperty property : object.getReliefComponents()) {
                if (property.getObject() instanceof TINRelief tinRelief) {
                    helper.writeCityObjectUsingSerializer(tinRelief, helper.getOrCreateSerializer(TINReliefAdapter.class));
                }
            }
        }
    }
}
