/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractSpaceBoundaryProperty extends FeatureProperty<AbstractSpaceBoundary> {

    public AbstractSpaceBoundaryProperty() {
    }

    public AbstractSpaceBoundaryProperty(AbstractSpaceBoundary object) {
        super(object);
    }

    public AbstractSpaceBoundaryProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractSpaceBoundary> getTargetType() {
        return AbstractSpaceBoundary.class;
    }
}
