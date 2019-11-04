package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BridgeConstructiveElementProperty extends FeatureProperty<BridgeConstructiveElement> implements CityGMLObject {

    public BridgeConstructiveElementProperty() {
    }

    public BridgeConstructiveElementProperty(BridgeConstructiveElement object) {
        super(object);
    }

    public BridgeConstructiveElementProperty(String href) {
        super(href);
    }

    @Override
    public Class<BridgeConstructiveElement> getTargetType() {
        return BridgeConstructiveElement.class;
    }
}
