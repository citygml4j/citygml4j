/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.tunnel;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class TunnelConstructiveElementProperty extends FeatureProperty<TunnelConstructiveElement> implements CityGMLObject {

    public TunnelConstructiveElementProperty() {
    }

    public TunnelConstructiveElementProperty(TunnelConstructiveElement object) {
        super(object);
    }

    public TunnelConstructiveElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<TunnelConstructiveElement> getTargetType() {
        return TunnelConstructiveElement.class;
    }
}
