/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.model.core.AbstractThematicSurface;
import org.citygml4j.core.model.core.QualifiedAreaProperty;

public abstract class AbstractThematicSurfaceAdapter<T extends AbstractThematicSurface> extends AbstractSemanticObjectAdapter<T> {

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = object instanceof TopLevelFeature ?
                helper.getOrPutObject(Fields.ATTRIBUTES, node) :
                node;

        if (object.isSetAreas()) {
            for (QualifiedAreaProperty property : object.getAreas()) {
                if (property.getObject() != null && property.getObject().getArea() != null) {
                    attributes.put("area", property.getObject().getArea().getValue());
                    break;
                }
            }
        }
    }
}
