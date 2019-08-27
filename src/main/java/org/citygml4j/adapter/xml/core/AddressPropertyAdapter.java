package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AddressProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AddressPropertyAdapter extends AbstractFeaturePropertyAdapter<AddressProperty> {

    @Override
    public AddressProperty createObject(QName name) {
        return new AddressProperty();
    }
}
