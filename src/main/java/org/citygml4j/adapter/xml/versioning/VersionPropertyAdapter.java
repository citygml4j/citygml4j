package org.citygml4j.adapter.xml.versioning;

import org.citygml4j.model.versioning.VersionProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class VersionPropertyAdapter extends AbstractFeaturePropertyAdapter<VersionProperty> {

    @Override
    public VersionProperty createObject(QName name) {
        return new VersionProperty();
    }
}
