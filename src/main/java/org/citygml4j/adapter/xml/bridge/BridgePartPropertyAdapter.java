package org.citygml4j.adapter.xml.bridge;

import org.citygml4j.model.bridge.BridgePartProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BridgePartPropertyAdapter extends AbstractFeaturePropertyAdapter<BridgePartProperty> {

    @Override
    public BridgePartProperty createObject(QName name) throws ObjectBuildException {
        return new BridgePartProperty();
    }
}
