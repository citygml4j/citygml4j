package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.StoreyProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class StoreyPropertyAdapter extends AbstractFeaturePropertyAdapter<StoreyProperty> {

    @Override
    public StoreyProperty createObject(QName name) {
        return new StoreyProperty();
    }
}
