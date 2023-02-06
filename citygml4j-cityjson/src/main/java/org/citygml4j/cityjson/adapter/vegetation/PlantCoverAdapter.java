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

package org.citygml4j.cityjson.adapter.vegetation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
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
import org.citygml4j.core.model.deprecated.vegetation.DeprecatedPropertiesOfPlantCover;
import org.citygml4j.core.model.vegetation.PlantCover;
import org.xmlobjects.gml.model.measures.Length;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

@CityJSONElements({
        @CityJSONElement(name = "PlantCover", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "PlantCover", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class PlantCoverAdapter extends AbstractVegetationObjectAdapter<PlantCover> {
    private final Map<CityJSONVersion, EnumSet<GeometryType>> allowedTypes = new EnumMap<>(CityJSONVersion.class);

    public PlantCoverAdapter() {
        allowedTypes.put(CityJSONVersion.v1_1, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.COMPOSITE_SURFACE,
                GeometryType.SOLID, GeometryType.COMPOSITE_SOLID, GeometryType.MULTI_SOLID));
        allowedTypes.put(CityJSONVersion.v1_0, EnumSet.of(GeometryType.MULTI_SURFACE, GeometryType.MULTI_SOLID));
    }

    @Override
    public PlantCover createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new PlantCover();
    }

    @Override
    public void buildObject(PlantCover object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        JsonNode averageHeight = attributes.consume("averageHeight");
        if (averageHeight.isNumber()) {
            object.setAverageHeight(new Length(averageHeight.asDouble(), "m"));
        }

        JsonNode minHeight = attributes.consume("minHeight");
        if (minHeight.isNumber()) {
            object.setMinHeight(new Length(minHeight.asDouble(), "m"));
        }

        JsonNode maxHeight = attributes.consume("maxHeight");
        if (maxHeight.isNumber()) {
            object.setMaxHeight(new Length(maxHeight.asDouble(), "m"));
        }
    }

    @Override
    public String createType(PlantCover object, CityJSONVersion version) throws CityJSONSerializeException {
        return "PlantCover";
    }

    @Override
    public void writeObject(PlantCover object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);

        if (object.getAverageHeight() != null && object.getAverageHeight().getValue() != null) {
            attributes.put("averageHeight", object.getAverageHeight().getValue());
        }

        if (object.getMinHeight() != null && object.getMinHeight().getValue() != null) {
            attributes.put("minHeight", object.getMinHeight().getValue());
        }

        if (object.getMaxHeight() != null && object.getMaxHeight().getValue() != null) {
            attributes.put("maxHeight", object.getMaxHeight().getValue());
        }
    }

    @Override
    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return allowedTypes.get(version);
    }

    @Override
    public Map<Integer, MultiSurfaceProvider> getMultiSurfaceProviders(PlantCover object) {
        if (object.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfPlantCover properties = object.getDeprecatedProperties();
            return Map.of(1, MultiSurfaceProvider.of(properties::getLod1MultiSurface, properties::setLod1MultiSurface),
                    4, MultiSurfaceProvider.of(properties::getLod4MultiSurface, properties::setLod4MultiSurface));
        } else {
            return null;
        }
    }
}
