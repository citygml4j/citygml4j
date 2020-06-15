package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.CityObjectRelationProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class CityObjectRelationPropertyAdapter extends AbstractPropertyAdapter<CityObjectRelationProperty> {

    @Override
    public CityObjectRelationProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new CityObjectRelationProperty();
    }
}
