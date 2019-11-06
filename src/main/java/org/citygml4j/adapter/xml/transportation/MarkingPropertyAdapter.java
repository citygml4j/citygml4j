package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.model.transportation.MarkingProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class MarkingPropertyAdapter extends AbstractFeaturePropertyAdapter<MarkingProperty> {

    @Override
    public MarkingProperty createObject(QName name) throws ObjectBuildException {
        return new MarkingProperty();
    }
}
