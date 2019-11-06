package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.model.transportation.SectionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class SectionPropertyAdapter extends AbstractFeaturePropertyAdapter<SectionProperty> {

    @Override
    public SectionProperty createObject(QName name) throws ObjectBuildException {
        return new SectionProperty();
    }
}
