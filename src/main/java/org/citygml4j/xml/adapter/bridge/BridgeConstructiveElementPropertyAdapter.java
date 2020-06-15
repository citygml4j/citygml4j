package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.bridge.BridgeConstructiveElementProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BridgeConstructiveElementPropertyAdapter extends AbstractFeaturePropertyAdapter<BridgeConstructiveElementProperty> {

    @Override
    public BridgeConstructiveElementProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeConstructiveElementProperty();
    }
}
