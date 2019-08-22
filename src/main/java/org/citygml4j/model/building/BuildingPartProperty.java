package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingPartProperty extends FeatureProperty<BuildingPart> implements CityGMLObject {

    public BuildingPartProperty() {
    }

    public BuildingPartProperty(BuildingPart object) {
        super(object);
    }

    public BuildingPartProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingPart> getTargetType() {
        return BuildingPart.class;
    }
}
