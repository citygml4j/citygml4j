/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BridgePartProperty extends FeatureProperty<BridgePart> implements CityGMLObject {

    public BridgePartProperty() {
    }

    public BridgePartProperty(BridgePart object) {
        super(object);
    }

    public BridgePartProperty(String href) {
        super(href);
    }

    @Override
    public Class<BridgePart> getTargetType() {
        return BridgePart.class;
    }
}
