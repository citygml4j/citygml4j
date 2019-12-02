package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractVersionTransitionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractVersionTransitionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractVersionTransitionProperty> {

    @Override
    public AbstractVersionTransitionProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractVersionTransitionProperty();
    }
}
