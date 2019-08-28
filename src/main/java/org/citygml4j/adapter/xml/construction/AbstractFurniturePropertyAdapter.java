package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.AbstractFurnitureProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractFurniturePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractFurnitureProperty> {

    @Override
    public AbstractFurnitureProperty createObject(QName name) {
        return new AbstractFurnitureProperty();
    }
}
