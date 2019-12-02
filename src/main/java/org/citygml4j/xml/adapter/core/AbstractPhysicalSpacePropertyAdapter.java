package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractPhysicalSpaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractPhysicalSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractPhysicalSpaceProperty> {

    @Override
    public AbstractPhysicalSpaceProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractPhysicalSpaceProperty();
    }
}
