/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class TimeseriesComponentProperty extends AbstractInlineProperty<TimeseriesComponent> implements CityGMLObject {

    public TimeseriesComponentProperty() {
    }

    public TimeseriesComponentProperty(TimeseriesComponent object) {
        super(object);
    }

    @Override
    public Class<TimeseriesComponent> getTargetType() {
        return TimeseriesComponent.class;
    }
}
