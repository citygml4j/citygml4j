package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.bridge.BridgeRoomProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BridgeRoomPropertyAdapter extends AbstractFeaturePropertyAdapter<BridgeRoomProperty> {

    @Override
    public BridgeRoomProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeRoomProperty();
    }
}
