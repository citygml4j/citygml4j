package org.citygml4j.adapter.xml.versioning;

import org.citygml4j.model.versioning.VersionTransitionProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class VersionTransitionPropertyAdapter extends AbstractFeaturePropertyAdapter<VersionTransitionProperty> {

    @Override
    public VersionTransitionProperty createObject(QName name) {
        return new VersionTransitionProperty();
    }
}
