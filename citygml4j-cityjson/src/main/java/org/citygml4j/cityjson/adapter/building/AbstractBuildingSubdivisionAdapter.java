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

package org.citygml4j.cityjson.adapter.building;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractLogicalSpaceAdapter;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.building.*;

import java.util.EnumSet;
import java.util.Iterator;

public abstract class AbstractBuildingSubdivisionAdapter<T extends AbstractBuildingSubdivision> extends AbstractLogicalSpaceAdapter<T> {
    private final EnumSet<GeometryType> allowedTypes = EnumSet.of(GeometryType.MULTI_SURFACE,
            GeometryType.COMPOSITE_SURFACE, GeometryType.SOLID, GeometryType.COMPOSITE_SOLID);

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        JsonNode sortKey = attributes.consume("sortKey");
        if (sortKey.isNumber()) {
            object.setSortKey(sortKey.asDouble());
        }

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            switch (helper.getCityObjectType(child)) {
                case "BuildingInstallation":
                    object.getBuildingInstallations().add(new BuildingInstallationProperty(helper.getCityObject(child, BuildingInstallation.class)));
                    break;
                case "BuildingConstructiveElement":
                    object.getBuildingConstructiveElements().add(new BuildingConstructiveElementProperty((helper.getCityObject(child, BuildingConstructiveElement.class))));
                    break;
                case "BuildingRoom":
                    object.getBuildingRooms().add(new BuildingRoomProperty(helper.getCityObject(child, BuildingRoom.class)));
                    break;
                case "BuildingFurniture":
                    object.getBuildingFurniture().add(new BuildingFurnitureProperty(helper.getCityObject(child, BuildingFurniture.class)));
                    break;
                default:
                    continue;
            }

            children.remove();
        }
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);

        if (object.getSortKey() != null) {
            attributes.put("sortKey", object.getSortKey());
        }

        if (object.isSetBuildingConstructiveElements()) {
            for (BuildingConstructiveElementProperty property : object.getBuildingConstructiveElements()) {
                if (property.isSetInlineObject()) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }

        if (object.isSetBuildingInstallations()) {
            for (BuildingInstallationProperty property : object.getBuildingInstallations()) {
                if (property.isSetInlineObject()) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }

        if (object.isSetBuildingRooms()) {
            for (BuildingRoomProperty property : object.getBuildingRooms()) {
                if (property.isSetInlineObject()) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }

        if (object.isSetBuildingFurniture()) {
            for (BuildingFurnitureProperty property : object.getBuildingFurniture()) {
                if (property.isSetInlineObject()) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }
    }

    @Override
    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return allowedTypes;
    }
}
