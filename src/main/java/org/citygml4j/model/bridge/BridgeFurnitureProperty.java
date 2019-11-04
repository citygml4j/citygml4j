package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BridgeFurnitureProperty extends FeatureProperty<BridgeFurniture> implements CityGMLObject {

    public BridgeFurnitureProperty() {
    }

    public BridgeFurnitureProperty(BridgeFurniture object) {
        super(object);
    }

    public BridgeFurnitureProperty(String href) {
        super(href);
    }

    @Override
    public Class<BridgeFurniture> getTargetType() {
        return BridgeFurniture.class;
    }
}
