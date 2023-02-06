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

package org.citygml4j.cityjson.adapter.bridge;

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
import org.citygml4j.core.model.bridge.*;
import org.citygml4j.core.model.construction.RelationToConstruction;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.deprecated.bridge.DeprecatedPropertiesOfAbstractBridge;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractBridgeAdapter<T extends AbstractBridge> extends AbstractConstructionAdapter<T> {
    private final Map<CityJSONVersion, EnumSet<GeometryType>> allowedTypes = new EnumMap<>(CityJSONVersion.class);

    public AbstractBridgeAdapter() {
        allowedTypes.put(CityJSONVersion.v1_1, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.COMPOSITE_SURFACE,
                GeometryType.SOLID, GeometryType.COMPOSITE_SOLID));
        allowedTypes.put(CityJSONVersion.v1_0, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.SOLID,
                GeometryType.COMPOSITE_SOLID));
    }

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        JsonNode isMovable = attributes.consume("isMovable");
        if (isMovable.isBoolean()) {
            object.setIsMovable(isMovable.asBoolean());
        }

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            switch (helper.getCityObjectType(child)) {
                case "BridgeInstallation":
                    object.getBridgeInstallations().add(new BridgeInstallationProperty(helper.getCityObject(child, BridgeInstallation.class)));
                    break;
                case "BridgeConstructiveElement":
                case "BridgeConstructionElement":
                    object.getBridgeConstructiveElements().add(new BridgeConstructiveElementProperty((helper.getCityObject(child, BridgeConstructiveElement.class))));
                    break;
                case "BridgeRoom":
                    object.getBridgeRooms().add(new BridgeRoomProperty(helper.getCityObject(child, BridgeRoom.class)));
                    break;
                case "BridgeFurniture":
                    object.getBridgeFurniture().add(new BridgeFurnitureProperty(helper.getCityObject(child, BridgeFurniture.class)));
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

        if (object.isSetIsMovable()) {
            attributes.put("isMovable", object.getIsMovable());
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

        if (object.isSetBridgeInstallations()) {
            for (BridgeInstallationProperty property : object.getBridgeInstallations()) {
                if (property.isSetInlineObject()
                        && (version != CityJSONVersion.v1_0
                        || property.getObject().getRelationToConstruction() == RelationToConstruction.OUTSIDE)) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }

        if (object.isSetBridgeConstructiveElements()) {
            for (BridgeConstructiveElementProperty property : object.getBridgeConstructiveElements()) {
                if (property.isSetInlineObject()) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }

        if (version == CityJSONVersion.v1_1) {
            if (object.isSetBridgeRooms()) {
                for (BridgeRoomProperty property : object.getBridgeRooms()) {
                    if (property.isSetInlineObject()) {
                        helper.writeChildObject(property.getObject(), object, node);
                    }
                }
            }

            if (object.isSetBridgeFurniture()) {
                for (BridgeFurnitureProperty property : object.getBridgeFurniture()) {
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
            DeprecatedPropertiesOfAbstractBridge properties = object.getDeprecatedProperties();
            return Map.of(1, MultiSurfaceProvider.of(properties::getLod1MultiSurface, properties::setLod1MultiSurface),
                    4, MultiSurfaceProvider.of(properties::getLod4MultiSurface, properties::setLod4MultiSurface));
        } else {
            return null;
        }
    }
}
