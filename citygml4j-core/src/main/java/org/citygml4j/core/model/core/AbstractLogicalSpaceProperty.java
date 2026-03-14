/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractLogicalSpaceProperty extends FeatureProperty<AbstractLogicalSpace> implements CityGMLObject {

    public AbstractLogicalSpaceProperty() {
    }

    public AbstractLogicalSpaceProperty(AbstractLogicalSpace object) {
        super(object);
    }

    public AbstractLogicalSpaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractLogicalSpace> getTargetType() {
        return AbstractLogicalSpace.class;
    }
}
