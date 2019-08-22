package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingConstructiveElementProperty extends FeatureProperty<BuildingConstructiveElement> implements CityGMLObject {

    public BuildingConstructiveElementProperty() {
    }

    public BuildingConstructiveElementProperty(BuildingConstructiveElement object) {
        super(object);
    }

    public BuildingConstructiveElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingConstructiveElement> getTargetType() {
        return BuildingConstructiveElement.class;
    }
}
