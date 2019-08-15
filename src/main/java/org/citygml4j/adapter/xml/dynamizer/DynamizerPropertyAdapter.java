package org.citygml4j.adapter.xml.dynamizer;

import org.citygml4j.model.dynamizer.DynamizerProperty;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class DynamizerPropertyAdapter extends AbstractPropertyAdapter<DynamizerProperty> {

    @Override
    public DynamizerProperty createObject(QName name) {
        return new DynamizerProperty();
    }
}
