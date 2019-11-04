package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
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
