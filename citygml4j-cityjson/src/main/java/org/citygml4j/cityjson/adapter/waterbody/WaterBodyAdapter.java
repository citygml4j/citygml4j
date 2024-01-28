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

package org.citygml4j.cityjson.adapter.waterbody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractOccupiedSpaceAdapter;
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
import org.citygml4j.core.model.deprecated.waterbody.DeprecatedPropertiesOfWaterBody;
import org.citygml4j.core.model.waterbody.WaterBody;

import java.util.EnumSet;
import java.util.Map;

@CityJSONElements({
        @CityJSONElement(name = "WaterBody", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "WaterBody", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "WaterBody", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class WaterBodyAdapter extends AbstractOccupiedSpaceAdapter<WaterBody> {
    private final EnumSet<GeometryType> allowedTypes = EnumSet.of(GeometryType.MULTI_LINE_STRING,
            GeometryType.MULTI_SURFACE, GeometryType.COMPOSITE_SURFACE, GeometryType.SOLID, GeometryType.COMPOSITE_SOLID);

    @Override
    public WaterBody createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new WaterBody();
    }

    @Override
    public void buildObject(WaterBody object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);
    }

    @Override
    public String createType(WaterBody object, CityJSONVersion version) throws CityJSONSerializeException {
        return "WaterBody";
    }

    @Override
    public void writeObject(WaterBody object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);
    }

    @Override
    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return allowedTypes;
    }

    @Override
    public Map<Integer, MultiSurfaceProvider> getMultiSurfaceProviders(WaterBody object) {
        if (object.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfWaterBody properties = object.getDeprecatedProperties();
            return Map.of(1, MultiSurfaceProvider.of(properties::getLod1MultiSurface, properties::setLod1MultiSurface));
        } else {
            return null;
        }
    }
}
