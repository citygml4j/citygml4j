/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractOccupiedSpaceProperty extends FeatureProperty<AbstractOccupiedSpace> implements CityGMLObject {

    public AbstractOccupiedSpaceProperty() {
    }

    public AbstractOccupiedSpaceProperty(AbstractOccupiedSpace object) {
        super(object);
    }

    public AbstractOccupiedSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractOccupiedSpace> getTargetType() {
        return AbstractOccupiedSpace.class;
    }
}
