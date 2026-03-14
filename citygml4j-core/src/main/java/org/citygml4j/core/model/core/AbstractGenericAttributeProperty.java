/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

@SuppressWarnings("rawtypes")
public class AbstractGenericAttributeProperty extends AbstractInlineProperty<AbstractGenericAttribute> implements CityGMLObject {

    public AbstractGenericAttributeProperty() {
    }

    public AbstractGenericAttributeProperty(AbstractGenericAttribute object) {
        super(object);
    }

    @Override
    public Class<AbstractGenericAttribute> getTargetType() {
        return AbstractGenericAttribute.class;
    }
}
