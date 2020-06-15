package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractFeatureWithLifespanProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractFeatureWithLifespanPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractFeatureWithLifespanProperty> {

    @Override
    public AbstractFeatureWithLifespanProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractFeatureWithLifespanProperty();
    }
}
