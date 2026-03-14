/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class TimeValuePairProperty extends AbstractInlineProperty<TimeValuePair> implements CityGMLObject {

    public TimeValuePairProperty() {
    }

    public TimeValuePairProperty(TimeValuePair object) {
        super(object);
    }

    @Override
    public Class<TimeValuePair> getTargetType() {
        return TimeValuePair.class;
    }
}
