package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.bridge.BridgeInstallationProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BridgeInstallationPropertyAdapter extends AbstractFeaturePropertyAdapter<BridgeInstallationProperty> {

    @Override
    public BridgeInstallationProperty createObject(QName name) throws ObjectBuildException {
        return new BridgeInstallationProperty();
    }
}
