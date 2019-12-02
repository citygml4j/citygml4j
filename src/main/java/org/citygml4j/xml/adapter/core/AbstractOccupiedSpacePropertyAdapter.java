package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractOccupiedSpaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractOccupiedSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractOccupiedSpaceProperty> {

    @Override
    public AbstractOccupiedSpaceProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractOccupiedSpaceProperty();
    }
}
