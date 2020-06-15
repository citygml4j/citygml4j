package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AddressProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AddressPropertyAdapter extends AbstractFeaturePropertyAdapter<AddressProperty> {

    @Override
    public AddressProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AddressProperty();
    }
}
