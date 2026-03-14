/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractBridgeProperty extends FeatureProperty<AbstractBridge> implements CityGMLObject {

    public AbstractBridgeProperty() {
    }

    public AbstractBridgeProperty(AbstractBridge object) {
        super(object);
    }

    public AbstractBridgeProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractBridge> getTargetType() {
        return AbstractBridge.class;
    }
}
