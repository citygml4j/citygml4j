package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.construction.AbstractConstructionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractConstructionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractConstructionProperty> {

    @Override
    public AbstractConstructionProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractConstructionProperty();
    }
}
