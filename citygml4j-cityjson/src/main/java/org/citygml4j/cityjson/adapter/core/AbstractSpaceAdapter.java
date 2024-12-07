/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.geometry.MultiCurveProvider;
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
import org.citygml4j.core.model.core.AbstractSpace;
import org.citygml4j.core.model.core.QualifiedAreaProperty;
import org.citygml4j.core.model.core.QualifiedVolumeProperty;
import org.citygml4j.core.model.core.SpaceType;

import java.util.EnumSet;
import java.util.Map;

public abstract class AbstractSpaceAdapter<T extends AbstractSpace> extends AbstractCityObjectAdapter<T> {

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        JsonNode spaceType = attributes.consume("spaceType");
        if (spaceType.isTextual()) {
            object.setSpaceType(SpaceType.fromValue(spaceType.asText()));
        }

        helper.addGeometries(object, node.get(Fields.GEOMETRY));
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        if (object.getSpaceType() != null) {
            attributes.put("spaceType", object.getSpaceType().toValue());
        }

        if (object.isSetVolumes()) {
            for (QualifiedVolumeProperty property : object.getVolumes()) {
                if (property.getObject() != null && property.getObject().getVolume() != null) {
                    attributes.put("volume", property.getObject().getVolume().getValue());
                    break;
                }
            }
        }

        if (object.isSetAreas()) {
            for (QualifiedAreaProperty property : object.getAreas()) {
                if (property.getObject() != null && property.getObject().getArea() != null) {
                    attributes.put("area", property.getObject().getArea().getValue());
                    break;
                }
            }
        }

        helper.addGeometries(object, node, getAllowedGeometryTypes(helper.getVersion()));
    }

    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return GeometryType.ALL_TYPES;
    }

    public Map<Integer, MultiSurfaceProvider> getMultiSurfaceProviders(T object) {
        return null;
    }

    public Map<Integer, MultiCurveProvider> getMultiCurveProviders(T object) {
        return null;
    }
}
