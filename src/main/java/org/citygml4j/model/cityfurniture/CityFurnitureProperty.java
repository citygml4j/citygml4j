package org.citygml4j.model.cityfurniture;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class CityFurnitureProperty extends FeatureProperty<CityFurniture> implements CityGMLObject {

    public CityFurnitureProperty() {
    }

    public CityFurnitureProperty(CityFurniture object) {
        super(object);
    }

    public CityFurnitureProperty(String href) {
        super(href);
    }

    @Override
    public Class<CityFurniture> getTargetType() {
        return CityFurniture.class;
    }
}
