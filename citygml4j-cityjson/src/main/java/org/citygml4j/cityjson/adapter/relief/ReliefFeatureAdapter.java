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
