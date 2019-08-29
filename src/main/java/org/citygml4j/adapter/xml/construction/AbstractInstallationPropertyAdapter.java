package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.AbstractInstallationProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractInstallationPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractInstallationProperty> {

    @Override
    public AbstractInstallationProperty createObject(QName name) {
        return new AbstractInstallationProperty();
    }
}
