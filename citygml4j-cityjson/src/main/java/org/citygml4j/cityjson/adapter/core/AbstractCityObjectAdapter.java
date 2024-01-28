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

public abstract class AbstractCityObjectAdapter<T extends AbstractCityObject> extends AbstractFeatureWithLifespanAdapter<T> {

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        JsonNode relativeToTerrain = attributes.consume("relativeToTerrain");
        if (relativeToTerrain.isTextual()) {
            object.setRelativeToTerrain(RelativeToTerrain.fromValue(relativeToTerrain.asText()));
        }

        JsonNode relativeToWater = attributes.consume("relativeToWater");
        if (relativeToWater.isTextual()) {
            object.setRelativeToWater(RelativeToWater.fromValue(relativeToWater.asText()));
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
