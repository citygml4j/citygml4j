/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class HeightProperty extends AbstractInlineProperty<Height> implements CityGMLObject {

    public HeightProperty() {
    }

    public HeightProperty(Height object) {
        super(object);
    }

    @Override
    public Class<Height> getTargetType() {
        return Height.class;
    }
}
