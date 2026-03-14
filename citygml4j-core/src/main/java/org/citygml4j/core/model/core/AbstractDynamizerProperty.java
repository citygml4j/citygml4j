/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractDynamizerProperty extends FeatureProperty<AbstractDynamizer> implements CityGMLObject {

    public AbstractDynamizerProperty() {
    }

    public AbstractDynamizerProperty(AbstractDynamizer object) {
        super(object);
    }

    public AbstractDynamizerProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractDynamizer> getTargetType() {
        return AbstractDynamizer.class;
    }
}
