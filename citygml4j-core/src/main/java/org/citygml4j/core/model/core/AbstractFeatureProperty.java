/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFeatureProperty extends FeatureProperty<AbstractFeature> implements CityGMLObject {

    public AbstractFeatureProperty() {
    }

    public AbstractFeatureProperty(AbstractFeature object) {
        super(object);
    }

    public AbstractFeatureProperty(String href) {
        super(href);
    }

    public AbstractFeatureProperty(GenericElement element) {
        super(element);
    }

    @Override
    public Class<AbstractFeature> getTargetType() {
        return AbstractFeature.class;
    }
}
