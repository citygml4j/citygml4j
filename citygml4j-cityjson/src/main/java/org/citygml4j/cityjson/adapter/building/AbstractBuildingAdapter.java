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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.construction.AbstractConstructionAdapter;
import org.citygml4j.cityjson.adapter.core.AddressAdapter;
import org.citygml4j.cityjson.adapter.geometry.MultiSurfaceProvider;
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
import org.citygml4j.core.model.construction.RelationToConstruction;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.deprecated.building.DeprecatedPropertiesOfAbstractBuilding;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.DoubleOrNilReason;
import org.xmlobjects.gml.model.basictypes.MeasureOrNilReasonList;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractBuildingAdapter<T extends AbstractBuilding> extends AbstractConstructionAdapter<T> {
    private final Map<CityJSONVersion, EnumSet<GeometryType>> allowedTypes = new EnumMap<>(CityJSONVersion.class);

    public AbstractBuildingAdapter() {
        allowedTypes.put(CityJSONVersion.v1_1, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.COMPOSITE_SURFACE,
                GeometryType.SOLID, GeometryType.COMPOSITE_SOLID));
        allowedTypes.put(CityJSONVersion.v1_0, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.SOLID,
                GeometryType.COMPOSITE_SOLID));
    }

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        JsonNode roofType = attributes.consume("roofType");
        if (roofType.isTextual()) {
            object.setRoofType(new Code(roofType.asText()));
        }

        JsonNode storeysAboveGround = attributes.consume("storeysAboveGround");
        if (storeysAboveGround.isInt()) {
            object.setStoreysAboveGround(storeysAboveGround.asInt());
        }

        JsonNode storeysBelowGround = attributes.consume("storeysBelowGround");
        if (storeysBelowGround.isInt()) {
            object.setStoreysBelowGround(storeysBelowGround.asInt());
        }

        JsonNode storeyHeightsAboveGround = attributes.consume("storeyHeightsAboveGround");
        if (storeyHeightsAboveGround.isArray()) {
            MeasureOrNilReasonList measures = new MeasureOrNilReasonList();
            for (JsonNode value : storeyHeightsAboveGround) {
                if (value.isNumber()) {
                    measures.getValue().add(new DoubleOrNilReason(value.asDouble()));
                }
            }

            if (measures.isSetValue()) {
                measures.setUom("m");
                object.setStoreyHeightsAboveGround(measures);
            }
        }

        JsonNode storeyHeightsBelowGround = attributes.consume("storeyHeightsBelowGround");
        if (storeyHeightsBelowGround.isArray()) {
            MeasureOrNilReasonList measures = new MeasureOrNilReasonList();
            for (JsonNode value : storeyHeightsBelowGround) {
                if (value.isNumber()) {
                    measures.getValue().add(new DoubleOrNilReason(value.asDouble()));
                }
            }

            if (measures.isSetValue()) {
                measures.setUom("m");
                object.setStoreyHeightsBelowGround(measures);
            }
        }

        JsonNode address = attributes.consume("address");
        if (address.isArray()) {
            for (JsonNode element : address) {
                object.getAddresses().add(new AddressProperty(helper.getObjectUsingBuilder(element, AddressAdapter.class)));
            }
        } else if (address.isObject()) {
            object.getAddresses().add(new AddressProperty(helper.getObjectUsingBuilder(address, AddressAdapter.class)));
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
        CityJSONVersion version = helper.getVersion();
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);

        if (object.getRoofType() != null) {
            attributes.put("roofType", object.getRoofType().getValue());
        }

        if (object.getStoreysAboveGround() != null) {
            attributes.put("storeysAboveGround", object.getStoreysAboveGround());
        }

        if (object.getStoreysBelowGround() != null) {
            attributes.put("storeysBelowGround", object.getStoreysBelowGround());
        }

        if (object.getStoreyHeightsAboveGround() != null && object.getStoreyHeightsAboveGround().isSetValue()) {
            ArrayNode storeyHeightsAboveGround = attributes.putArray("storeyHeightsAboveGround");
            for (DoubleOrNilReason value : object.getStoreyHeightsAboveGround().getValue()) {
                storeyHeightsAboveGround.add(value.getValue());
            }
        }

        if (object.getStoreyHeightsBelowGround() != null && object.getStoreyHeightsBelowGround().isSetValue()) {
            ArrayNode storeyHeightsBelowGround = attributes.putArray("storeyHeightsBelowGround");
            for (DoubleOrNilReason value : object.getStoreyHeightsBelowGround().getValue()) {
                storeyHeightsBelowGround.add(value.getValue());
            }
        }

        if (object.isSetAddresses()) {
            ArrayNode addresses = helper.createArray();
            for (AddressProperty property : object.getAddresses()) {
                if (property.isSetObject()) {
                    ObjectNode address = helper.getObjectUsingSerializer(property.getObject(), AddressAdapter.class);
                    if (!address.isEmpty()) {
                        addresses.add(address);
                        if (version == CityJSONVersion.v1_0) {
                            break;
                        }
                    }
                }
            }

            if (!addresses.isEmpty()) {
                node.set(Fields.ADDRESS, version == CityJSONVersion.v1_0 ? addresses.get(0) : addresses);
            }
        }

        if (object.isSetBuildingInstallations()) {
            for (BuildingInstallationProperty property : object.getBuildingInstallations()) {
                if (property.isSetInlineObject()
                        && (version != CityJSONVersion.v1_0
                        || property.getObject().getRelationToConstruction() == RelationToConstruction.OUTSIDE)) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }

        if (version == CityJSONVersion.v1_1) {
            if (object.isSetBuildingConstructiveElements()) {
                for (BuildingConstructiveElementProperty property : object.getBuildingConstructiveElements()) {
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
    }

    @Override
    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return allowedTypes.get(version);
    }

    @Override
    public Map<Integer, MultiSurfaceProvider> getMultiSurfaceProviders(T object) {
        if (object.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBuilding properties = object.getDeprecatedProperties();
            return Map.of(1, MultiSurfaceProvider.of(properties::getLod1MultiSurface, properties::setLod1MultiSurface),
                    4, MultiSurfaceProvider.of(properties::getLod4MultiSurface, properties::setLod4MultiSurface));
        } else {
            return null;
        }
    }
}
