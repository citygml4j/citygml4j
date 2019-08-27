package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractUnoccupiedSpaceProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractUnoccupiedSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractUnoccupiedSpaceProperty> {

    @Override
    public AbstractUnoccupiedSpaceProperty createObject(QName name) {
        return new AbstractUnoccupiedSpaceProperty();
    }
}
