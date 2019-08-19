package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractFurnitureProperty extends FeatureProperty<AbstractFurniture> implements CityGMLObject {

    public AbstractFurnitureProperty() {
    }

    public AbstractFurnitureProperty(AbstractFurniture object) {
        super(object);
    }

    public AbstractFurnitureProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractFurniture> getTargetType() {
        return AbstractFurniture.class;
    }
}
