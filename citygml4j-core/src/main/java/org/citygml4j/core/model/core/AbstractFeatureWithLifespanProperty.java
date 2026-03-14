/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFeatureWithLifespanProperty extends FeatureProperty<AbstractFeatureWithLifespan> implements CityGMLObject {

    public AbstractFeatureWithLifespanProperty() {
    }

    public AbstractFeatureWithLifespanProperty(AbstractFeatureWithLifespan object) {
        super(object);
    }

    public AbstractFeatureWithLifespanProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractFeatureWithLifespan> getTargetType() {
        return AbstractFeatureWithLifespan.class;
    }
}
