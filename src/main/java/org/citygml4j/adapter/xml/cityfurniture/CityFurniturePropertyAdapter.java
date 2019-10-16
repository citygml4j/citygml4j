package org.citygml4j.adapter.xml.cityfurniture;

import org.citygml4j.model.cityfurniture.CityFurnitureProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class CityFurniturePropertyAdapter extends AbstractFeaturePropertyAdapter<CityFurnitureProperty> {

    @Override
    public CityFurnitureProperty createObject(QName name) {
        return new CityFurnitureProperty();
    }
}
