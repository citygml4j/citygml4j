/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractVersionProperty extends FeatureProperty<AbstractVersion> implements CityGMLObject {

    public AbstractVersionProperty() {
    }

    public AbstractVersionProperty(AbstractVersion object) {
        super(object);
    }

    public AbstractVersionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractVersion> getTargetType() {
        return AbstractVersion.class;
    }
}
