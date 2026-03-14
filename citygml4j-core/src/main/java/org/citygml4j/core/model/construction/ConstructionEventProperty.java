/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class ConstructionEventProperty extends AbstractInlineProperty<ConstructionEvent> implements CityGMLObject {

    public ConstructionEventProperty() {
    }

    public ConstructionEventProperty(ConstructionEvent object) {
        super(object);
    }

    @Override
    public Class<ConstructionEvent> getTargetType() {
        return ConstructionEvent.class;
    }
}
