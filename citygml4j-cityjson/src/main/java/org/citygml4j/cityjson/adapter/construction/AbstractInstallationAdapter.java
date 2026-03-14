/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.construction;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.construction.AbstractInstallation;
import org.citygml4j.core.model.construction.RelationToConstruction;

public abstract class AbstractInstallationAdapter<T extends AbstractInstallation> extends AbstractOccupiedSpaceAdapter<T> {

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        JsonNode relationToConstruction = attributes.consume("relationToConstruction");
        if (relationToConstruction.isTextual()) {
            object.setRelationToConstruction(RelationToConstruction.fromValue(relationToConstruction.asText()));
        }
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        if (object.getRelationToConstruction() != null) {
            attributes.put("relationToConstruction", object.getRelationToConstruction().toValue());
        }
    }
}
