package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.model.transportation.HoleProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class HolePropertyAdapter extends AbstractFeaturePropertyAdapter<HoleProperty> {

    @Override
    public HoleProperty createObject(QName name) throws ObjectBuildException {
        return new HoleProperty();
    }
}
