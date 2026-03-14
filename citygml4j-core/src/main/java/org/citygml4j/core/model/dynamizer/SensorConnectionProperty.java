/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class SensorConnectionProperty extends AbstractInlineProperty<SensorConnection> implements CityGMLObject {

    public SensorConnectionProperty() {
    }

    public SensorConnectionProperty(SensorConnection object) {
        super(object);
    }

    @Override
    public Class<SensorConnection> getTargetType() {
        return SensorConnection.class;
    }
}
