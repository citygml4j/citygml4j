package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingFurnitureProperty extends FeatureProperty<BuildingFurniture> implements CityGMLObject {

    public BuildingFurnitureProperty() {
    }

    public BuildingFurnitureProperty(BuildingFurniture object) {
        super(object);
    }

    public BuildingFurnitureProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingFurniture> getTargetType() {
        return BuildingFurniture.class;
    }
}
