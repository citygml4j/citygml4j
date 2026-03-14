/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.generics;

import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.generics.GenericAttributeType;
import org.citygml4j.cityjson.model.generics.GenericAttributeTypes;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.core.AbstractGenericAttribute;

public abstract class AbstractGenericAttributeAdapter<T extends AbstractGenericAttribute<?>> implements JsonObjectBuilder<T>, JsonObjectSerializer<T> {

    void registerType(String name, GenericAttributeType type, CityJSONSerializerHelper helper) {
        if (helper.isWriteGenericAttributeTypes()) {
            GenericAttributeTypes types = helper.getProperties().get(GenericAttributeTypes.class.getName(), GenericAttributeTypes.class);
            if (types != null) {
                types.addType(name, type);
            }
        }
    }
}
