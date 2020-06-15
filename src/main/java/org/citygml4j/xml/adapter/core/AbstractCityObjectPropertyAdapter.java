package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractCityObjectPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractCityObjectProperty> {

    @Override
    public AbstractCityObjectProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractCityObjectProperty();
    }
}
