/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractConstructionProperty extends FeatureProperty<AbstractConstruction> implements CityGMLObject {

    public AbstractConstructionProperty() {
    }

    public AbstractConstructionProperty(AbstractConstruction object) {
        super(object);
    }

    public AbstractConstructionProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractConstruction> getTargetType() {
        return AbstractConstruction.class;
    }
}
