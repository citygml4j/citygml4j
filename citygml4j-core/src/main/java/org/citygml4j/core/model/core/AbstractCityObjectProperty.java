/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractCityObjectProperty extends FeatureProperty<AbstractCityObject> implements CityGMLObject {

    public AbstractCityObjectProperty() {
    }

    public AbstractCityObjectProperty(AbstractCityObject object) {
        super(object);
    }

    public AbstractCityObjectProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractCityObject> getTargetType() {
        return AbstractCityObject.class;
    }
}
