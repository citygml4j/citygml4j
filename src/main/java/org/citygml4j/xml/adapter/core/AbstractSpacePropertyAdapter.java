package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractSpaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractSpaceProperty> {

    @Override
    public AbstractSpaceProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractSpaceProperty();
    }
}
