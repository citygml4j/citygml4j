/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractVersionTransitionProperty extends FeatureProperty<AbstractVersionTransition> implements CityGMLObject {

    public AbstractVersionTransitionProperty() {
    }

    public AbstractVersionTransitionProperty(AbstractVersionTransition object) {
        super(object);
    }

    public AbstractVersionTransitionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractVersionTransition> getTargetType() {
        return AbstractVersionTransition.class;
    }
}
