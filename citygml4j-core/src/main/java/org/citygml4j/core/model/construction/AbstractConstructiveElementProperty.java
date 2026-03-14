/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractConstructiveElementProperty extends FeatureProperty<AbstractConstructiveElement> implements CityGMLObject {

    public AbstractConstructiveElementProperty() {
    }

    public AbstractConstructiveElementProperty(AbstractConstructiveElement object) {
        super(object);
    }

    public AbstractConstructiveElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractConstructiveElement> getTargetType() {
        return AbstractConstructiveElement.class;
    }
}
