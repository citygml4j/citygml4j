/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BridgeRoomProperty extends FeatureProperty<BridgeRoom> implements CityGMLObject {

    public BridgeRoomProperty() {
    }

    public BridgeRoomProperty(BridgeRoom object) {
        super(object);
    }

    public BridgeRoomProperty(String href) {
        super(href);
    }

    @Override
    public Class<BridgeRoom> getTargetType() {
        return BridgeRoom.class;
    }
}
