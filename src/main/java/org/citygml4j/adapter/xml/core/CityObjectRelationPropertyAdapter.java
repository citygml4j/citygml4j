package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.CityObjectRelationProperty;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class CityObjectRelationPropertyAdapter extends AbstractPropertyAdapter<CityObjectRelationProperty> {

    @Override
    public CityObjectRelationProperty createObject(QName name) {
        return new CityObjectRelationProperty();
    }
}
