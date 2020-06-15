package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.model.transportation.IntersectionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class IntersectionPropertyAdapter extends AbstractFeaturePropertyAdapter<IntersectionProperty> {

    @Override
    public IntersectionProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new IntersectionProperty();
    }
}
