package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.construction.AbstractFillingElementProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractFillingElementPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractFillingElementProperty> {

    @Override
    public AbstractFillingElementProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractFillingElementProperty();
    }
}
