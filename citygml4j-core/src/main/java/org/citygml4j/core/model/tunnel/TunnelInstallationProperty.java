/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.tunnel;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class TunnelInstallationProperty extends FeatureProperty<TunnelInstallation> implements CityGMLObject {

    public TunnelInstallationProperty() {
    }

    public TunnelInstallationProperty(TunnelInstallation object) {
        super(object);
    }

    public TunnelInstallationProperty(String href) {
        super(href);
    }

    @Override
    public Class<TunnelInstallation> getTargetType() {
        return TunnelInstallation.class;
    }
}
