/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractUnoccupiedSpaceProperty extends FeatureProperty<AbstractUnoccupiedSpace> implements CityGMLObject {

    public AbstractUnoccupiedSpaceProperty() {
    }

    public AbstractUnoccupiedSpaceProperty(AbstractUnoccupiedSpace object) {
        super(object);
    }

    public AbstractUnoccupiedSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractUnoccupiedSpace> getTargetType() {
        return AbstractUnoccupiedSpace.class;
    }
}
