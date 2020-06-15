package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractFeatureProperty;
import org.xmlobjects.builder.ObjectBuildException;

import javax.xml.namespace.QName;

public class AbstractFeaturePropertyAdapter extends org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter<AbstractFeatureProperty> {

    @Override
    public AbstractFeatureProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractFeatureProperty();
    }
}
