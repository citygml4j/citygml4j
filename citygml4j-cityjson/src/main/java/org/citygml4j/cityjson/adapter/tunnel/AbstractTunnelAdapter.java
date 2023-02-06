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

package org.citygml4j.cityjson.adapter.tunnel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.construction.AbstractConstructionAdapter;
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
import org.citygml4j.core.model.construction.RelationToConstruction;
import org.citygml4j.core.model.deprecated.tunnel.DeprecatedPropertiesOfAbstractTunnel;
import org.citygml4j.core.model.tunnel.*;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractTunnelAdapter<T extends AbstractTunnel> extends AbstractConstructionAdapter<T> {
    private final Map<CityJSONVersion, EnumSet<GeometryType>> allowedTypes = new EnumMap<>(CityJSONVersion.class);

    public AbstractTunnelAdapter() {
        allowedTypes.put(CityJSONVersion.v1_1, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.COMPOSITE_SURFACE,
                GeometryType.SOLID, GeometryType.COMPOSITE_SOLID));
        allowedTypes.put(CityJSONVersion.v1_0, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.SOLID,
                GeometryType.COMPOSITE_SOLID));
    }

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            switch (helper.getCityObjectType(child)) {
                case "TunnelInstallation":
                    object.getTunnelInstallations().add(new TunnelInstallationProperty(helper.getCityObject(child, TunnelInstallation.class)));
                    break;
                case "TunnelConstructiveElement":
                    object.getTunnelConstructiveElements().add(new TunnelConstructiveElementProperty((helper.getCityObject(child, TunnelConstructiveElement.class))));
                    break;
                case "TunnelHollowSpace":
                    object.getHollowSpaces().add(new HollowSpaceProperty(helper.getCityObject(child, HollowSpace.class)));
                    break;
                case "TunnelFurniture":
                    object.getTunnelFurniture().add(new TunnelFurnitureProperty(helper.getCityObject(child, TunnelFurniture.class)));
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

        if (object.isSetTunnelInstallations()) {
            for (TunnelInstallationProperty property : object.getTunnelInstallations()) {
                if (property.isSetInlineObject()
                        && (version != CityJSONVersion.v1_0
                        || property.getObject().getRelationToConstruction() == RelationToConstruction.OUTSIDE)) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }

        if (version == CityJSONVersion.v1_1) {
            if (object.isSetTunnelConstructiveElements()) {
                for (TunnelConstructiveElementProperty property : object.getTunnelConstructiveElements()) {
                    if (property.isSetInlineObject()) {
                        helper.writeChildObject(property.getObject(), object, node);
                    }
                }
            }

            if (object.isSetHollowSpaces()) {
                for (HollowSpaceProperty property : object.getHollowSpaces()) {
                    if (property.isSetInlineObject()) {
                        helper.writeChildObject(property.getObject(), object, node);
                    }
                }
            }

            if (object.isSetTunnelFurniture()) {
                for (TunnelFurnitureProperty property : object.getTunnelFurniture()) {
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
            DeprecatedPropertiesOfAbstractTunnel properties = object.getDeprecatedProperties();
            return Map.of(1, MultiSurfaceProvider.of(properties::getLod1MultiSurface, properties::setLod1MultiSurface),
                    4, MultiSurfaceProvider.of(properties::getLod4MultiSurface, properties::setLod4MultiSurface));
        } else {
            return null;
        }
    }
}
