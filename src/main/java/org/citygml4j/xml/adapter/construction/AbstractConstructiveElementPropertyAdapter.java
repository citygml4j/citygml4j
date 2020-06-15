package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.construction.AbstractConstructiveElementProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractConstructiveElementPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractConstructiveElementProperty> {

    @Override
    public AbstractConstructiveElementProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractConstructiveElementProperty();
    }
}
