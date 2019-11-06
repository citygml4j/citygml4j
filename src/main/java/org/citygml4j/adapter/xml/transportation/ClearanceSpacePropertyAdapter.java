package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.model.transportation.ClearanceSpaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class ClearanceSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<ClearanceSpaceProperty> {

    @Override
    public ClearanceSpaceProperty createObject(QName name) throws ObjectBuildException {
        return new ClearanceSpaceProperty();
    }
}
