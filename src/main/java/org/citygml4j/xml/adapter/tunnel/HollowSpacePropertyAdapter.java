package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.tunnel.HollowSpaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class HollowSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<HollowSpaceProperty> {

    @Override
    public HollowSpaceProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new HollowSpaceProperty();
    }
}
