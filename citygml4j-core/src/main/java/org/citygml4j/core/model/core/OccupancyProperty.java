/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class OccupancyProperty extends AbstractInlineProperty<Occupancy> implements CityGMLObject {

    public OccupancyProperty() {
    }

    public OccupancyProperty(Occupancy object) {
        super(object);
    }

    @Override
    public Class<Occupancy> getTargetType() {
        return Occupancy.class;
    }
}
