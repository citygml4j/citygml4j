package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractVersionTransitionProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractVersionTransitionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractVersionTransitionProperty> {

    @Override
    public AbstractVersionTransitionProperty createObject(QName name) {
        return new AbstractVersionTransitionProperty();
    }
}
