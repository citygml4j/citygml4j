/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFurnitureProperty extends FeatureProperty<AbstractFurniture> implements CityGMLObject {

    public AbstractFurnitureProperty() {
    }

    public AbstractFurnitureProperty(AbstractFurniture object) {
        super(object);
    }

    public AbstractFurnitureProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractFurniture> getTargetType() {
        return AbstractFurniture.class;
    }
}
