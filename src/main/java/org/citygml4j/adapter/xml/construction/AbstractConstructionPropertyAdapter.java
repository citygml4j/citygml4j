package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.AbstractConstructionProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractConstructionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractConstructionProperty> {

    @Override
    public AbstractConstructionProperty createObject(QName name) {
        return new AbstractConstructionProperty();
    }
}
