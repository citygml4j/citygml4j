package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractSpaceBoundaryPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractSpaceBoundaryProperty> {

    @Override
    public AbstractSpaceBoundaryProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractSpaceBoundaryProperty();
    }
}
