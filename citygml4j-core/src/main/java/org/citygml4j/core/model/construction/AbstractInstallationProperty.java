/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractInstallationProperty extends FeatureProperty<AbstractInstallation> implements CityGMLObject {

    public AbstractInstallationProperty() {
    }

    public AbstractInstallationProperty(AbstractInstallation object) {
        super(object);
    }

    public AbstractInstallationProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractInstallation> getTargetType() {
        return AbstractInstallation.class;
    }
}
