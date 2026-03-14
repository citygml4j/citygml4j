/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class RoomHeightProperty extends AbstractInlineProperty<RoomHeight> implements CityGMLObject {

    public RoomHeightProperty() {
    }

    public RoomHeightProperty(RoomHeight object) {
        super(object);
    }

    @Override
    public Class<RoomHeight> getTargetType() {
        return RoomHeight.class;
    }
}
