/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.relief;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractReliefComponentProperty extends FeatureProperty<AbstractReliefComponent> implements CityGMLObject {

    public AbstractReliefComponentProperty() {
    }

    public AbstractReliefComponentProperty(AbstractReliefComponent object) {
        super(object);
    }

    public AbstractReliefComponentProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractReliefComponent> getTargetType() {
        return AbstractReliefComponent.class;
    }
}
