package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.model.dynamizer.DynamizerProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class DynamizerPropertyAdapter extends AbstractFeaturePropertyAdapter<DynamizerProperty> {

    @Override
    public DynamizerProperty createObject(QName name) {
        return new DynamizerProperty();
    }
}
