/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.cityjson.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.cityjson.adapter.geometry.MultiSurfaceProvider;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.deprecated.tunnel.DeprecatedPropertiesOfHollowSpace;
import org.citygml4j.core.model.tunnel.*;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

@CityJSONElements({
        @CityJSONElement(name = "TunnelHollowSpace", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "TunnelHollowSpace", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1)
})
public class HollowSpaceAdapter extends AbstractUnoccupiedSpaceAdapter<HollowSpace> {
    private final EnumSet<GeometryType> allowedTypes = EnumSet.of(GeometryType.MULTI_SURFACE,
            GeometryType.COMPOSITE_SURFACE, GeometryType.SOLID, GeometryType.COMPOSITE_SOLID);

    @Override
    public HollowSpace createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new HollowSpace();
    }

    @Override
    public void buildObject(HollowSpace object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            switch (helper.getCityObjectType(child)) {
                case "TunnelInstallation":
                    object.getTunnelInstallations().add(new TunnelInstallationProperty(helper.getCityObject(child, TunnelInstallation.class)));
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
    public String createType(HollowSpace object, CityJSONVersion version) throws CityJSONSerializeException {
        return "TunnelHollowSpace";
    }

    @Override
    public void writeObject(HollowSpace object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);

        if (object.isSetTunnelInstallations()) {
            for (TunnelInstallationProperty property : object.getTunnelInstallations()) {
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

    @Override
    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return allowedTypes;
    }

    @Override
    public Map<Integer, MultiSurfaceProvider> getMultiSurfaceProviders(HollowSpace object) {
        if (object.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfHollowSpace properties = object.getDeprecatedProperties();
            return Map.of(4, MultiSurfaceProvider.of(properties::getLod4MultiSurface, properties::setLod4MultiSurface));
        } else {
            return null;
        }
    }
}
