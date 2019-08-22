package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractBuildingProperty extends FeatureProperty<AbstractBuilding> implements CityGMLObject {

    public AbstractBuildingProperty() {
    }

    public AbstractBuildingProperty(AbstractBuilding object) {
        super(object);
    }

    public AbstractBuildingProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractBuilding> getTargetType() {
        return AbstractBuilding.class;
    }
}
