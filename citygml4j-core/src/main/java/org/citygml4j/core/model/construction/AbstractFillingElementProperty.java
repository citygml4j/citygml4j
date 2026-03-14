/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFillingElementProperty extends FeatureProperty<AbstractFillingElement> implements CityGMLObject {

    public AbstractFillingElementProperty() {
    }

    public AbstractFillingElementProperty(AbstractFillingElement object) {
        super(object);
    }

    public AbstractFillingElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractFillingElement> getTargetType() {
        return AbstractFillingElement.class;
    }
}
