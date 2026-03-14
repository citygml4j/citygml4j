/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.tunnel;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class TunnelPartProperty extends FeatureProperty<TunnelPart> implements CityGMLObject {

    public TunnelPartProperty() {
    }

    public TunnelPartProperty(TunnelPart object) {
        super(object);
    }

    public TunnelPartProperty(String href) {
        super(href);
    }

    @Override
    public Class<TunnelPart> getTargetType() {
        return TunnelPart.class;
    }
}
