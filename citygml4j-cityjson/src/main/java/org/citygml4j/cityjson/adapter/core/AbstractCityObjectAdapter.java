/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.core;

import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.cityobjectgroup.Role;
import org.citygml4j.core.model.core.*;
import org.citygml4j.core.util.reference.Referees;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.ObjectNode;

public abstract class AbstractCityObjectAdapter<T extends AbstractCityObject> extends AbstractFeatureWithLifespanAdapter<T> {

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        JsonNode relativeToTerrain = attributes.consume("relativeToTerrain");
        if (relativeToTerrain.isString()) {
            object.setRelativeToTerrain(RelativeToTerrain.fromValue(relativeToTerrain.asString()));
        }

        JsonNode relativeToWater = attributes.consume("relativeToWater");
        if (relativeToWater.isString()) {
            object.setRelativeToWater(RelativeToWater.fromValue(relativeToWater.asString()));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        if (object.getRelativeToTerrain() != null) {
            attributes.put("relativeToTerrain", object.getRelativeToTerrain().toValue());
        }

        if (object.getRelativeToWater() != null) {
            attributes.put("relativeToWater", object.getRelativeToWater().toValue());
        }

        if (object.hasLocalProperties()
                && helper.getVersion() != CityJSONVersion.v1_0
                && helper.getType() != CityJSONType.CITYJSON_FEATURE) {
            Referees referees = object.getLocalProperties().get(Referees.PROPERTY_NAME, Referees.class);
            if (referees != null) {
                for (Role role : referees.get(Role.class)) {
                    CityObjectGroup group = role.getParent(CityObjectGroup.class);
                    if (group != null) {
                        helper.getOrPutArray(Fields.PARENTS, node).add(helper.getOrCreateId(group));
                    }
                }
            }
        }

        if (object.isSetGenericAttributes()) {
            for (AbstractGenericAttributeProperty property : object.getGenericAttributes()) {
                if (property.getObject() != null) {
                    JsonObjectSerializer<?> serializer = helper.getContext().getSerializer(property.getObject().getClass(), helper.getVersion());
                    if (serializer != null) {
                        ((JsonObjectSerializer<AbstractGenericAttribute<?>>) serializer).writeObject(property.getObject(), attributes, helper);
                    }
                }
            }
        }
    }
}
