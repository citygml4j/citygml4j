package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractDynamizerProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractDynamizerPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractDynamizerProperty> {

    @Override
    public AbstractDynamizerProperty createObject(QName name) {
        return new AbstractDynamizerProperty();
    }
}
