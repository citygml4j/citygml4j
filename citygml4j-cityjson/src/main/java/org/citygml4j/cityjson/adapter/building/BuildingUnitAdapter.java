/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
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

package org.citygml4j.cityjson.adapter.building;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AddressAdapter;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.building.BuildingUnit;
import org.citygml4j.core.model.building.Storey;
import org.citygml4j.core.model.building.StoreyProperty;
import org.citygml4j.core.model.core.AddressProperty;

import java.util.Iterator;

@CityJSONElement(name = "BuildingUnit", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1)
public class BuildingUnitAdapter extends AbstractBuildingSubdivisionAdapter<BuildingUnit> {

    @Override
    public BuildingUnit createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new BuildingUnit();
    }

    @Override
    public void buildObject(BuildingUnit object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            if ("BuildingStorey".equals(helper.getCityObjectType(child))) {
                object.getStoreys().add(new StoreyProperty(helper.getCityObject(child, Storey.class)));
                children.remove();
            }
        }
    }

    @Override
    public String createType(BuildingUnit object, CityJSONVersion version) throws CityJSONSerializeException {
        return "BuildingUnit";
    }

    @Override
    public void writeObject(BuildingUnit object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);

        if (object.isSetAddresses()) {
            ArrayNode addresses = node.putArray(Fields.ADDRESS);
            for (AddressProperty property : object.getAddresses()) {
                if (property.isSetObject()) {
                    ObjectNode address = helper.getObjectUsingSerializer(property.getObject(), AddressAdapter.class);
                    if (!address.isEmpty()) {
                        addresses.add(address);
                    }
                }
            }

            if (addresses.isEmpty()) {
                node.remove(Fields.ADDRESS);
            }
        }

        if (object.isSetStoreys()) {
            for (StoreyProperty property : object.getStoreys()) {
                if (property.isSetInlineObject()) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }
    }
}
