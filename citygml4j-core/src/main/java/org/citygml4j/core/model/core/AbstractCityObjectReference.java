/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.base.AssociationAttributes;

public class AbstractCityObjectReference extends AbstractReference<AbstractCityObject> implements CityGMLObject {

    public AbstractCityObjectReference() {
    }

    public AbstractCityObjectReference(String href) {
        super(href);
    }

    public AbstractCityObjectReference(AbstractCityObject object) {
        super(object);
    }

    public AbstractCityObjectReference(AssociationAttributes reference) {
        super(reference);
    }

    @Override
    public Class<AbstractCityObject> getTargetType() {
        return AbstractCityObject.class;
    }
}
