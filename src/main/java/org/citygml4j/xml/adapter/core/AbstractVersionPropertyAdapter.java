package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractVersionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractVersionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractVersionProperty> {

    @Override
    public AbstractVersionProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractVersionProperty();
    }
}
