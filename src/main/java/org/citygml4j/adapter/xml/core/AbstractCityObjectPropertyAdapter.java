package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractCityObjectPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractCityObjectProperty> {

    @Override
    public AbstractCityObjectProperty createObject(QName name) {
        return new AbstractCityObjectProperty();
    }
}
