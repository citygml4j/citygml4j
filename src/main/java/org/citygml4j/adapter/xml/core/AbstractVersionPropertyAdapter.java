package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractVersionProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractVersionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractVersionProperty> {

    @Override
    public AbstractVersionProperty createObject(QName name) {
        return new AbstractVersionProperty();
    }
}
