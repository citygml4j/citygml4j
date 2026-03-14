/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BridgeConstructiveElementProperty extends FeatureProperty<BridgeConstructiveElement> implements CityGMLObject {

    public BridgeConstructiveElementProperty() {
    }

    public BridgeConstructiveElementProperty(BridgeConstructiveElement object) {
        super(object);
    }

    public BridgeConstructiveElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<BridgeConstructiveElement> getTargetType() {
        return BridgeConstructiveElement.class;
    }
}
