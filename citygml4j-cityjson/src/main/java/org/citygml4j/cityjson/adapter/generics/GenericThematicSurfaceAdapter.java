/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.generics;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.core.AbstractSemanticObjectAdapter;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.generics.GenericThematicSurface;

import java.util.EnumSet;

@CityJSONElements({
        @CityJSONElement(name = "+GenericSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "+GenericSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "+GenericSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class GenericThematicSurfaceAdapter extends AbstractSemanticObjectAdapter<GenericThematicSurface> {
    private final EnumSet<GeometryType> allowedTypes = EnumSet.of(GeometryType.MULTI_SURFACE,
            GeometryType.COMPOSITE_SURFACE);

    @Override
    public GenericThematicSurface createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new GenericThematicSurface();
    }

    @Override
    public String createType(GenericThematicSurface object, CityJSONVersion version) throws CityJSONSerializeException {
        return "+GenericSurface";
    }

    @Override
    public void writeObject(GenericThematicSurface object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        if (isTopLevelObject(object)) {
            helper.addGeometries(object, node, allowedTypes);
        }
    }
}
