/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFillingSurfaceProperty extends FeatureProperty<AbstractFillingSurface> implements CityGMLObject {

    public AbstractFillingSurfaceProperty() {
    }

    public AbstractFillingSurfaceProperty(AbstractFillingSurface object) {
        super(object);
    }

    public AbstractFillingSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractFillingSurface> getTargetType() {
        return AbstractFillingSurface.class;
    }
}
