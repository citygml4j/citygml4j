/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BridgeInstallationProperty extends FeatureProperty<BridgeInstallation> implements CityGMLObject {

    public BridgeInstallationProperty() {
    }

    public BridgeInstallationProperty(BridgeInstallation object) {
        super(object);
    }

    public BridgeInstallationProperty(String href) {
        super(href);
    }

    @Override
    public Class<BridgeInstallation> getTargetType() {
        return BridgeInstallation.class;
    }
}
