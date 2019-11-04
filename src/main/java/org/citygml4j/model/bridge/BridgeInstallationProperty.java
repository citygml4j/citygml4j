package org.citygml4j.model.bridge;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BridgeInstallationProperty extends FeatureProperty<BridgeInstallation> implements CityGMLObject {

    public BridgeInstallationProperty() {
    }

    public BridgeInstallationProperty(BridgeInstallation object) {
        super(object);
    }

    public BridgeInstallationProperty(String href) {
        super(href);
    }

    @Override
    public Class<BridgeInstallation> getTargetType() {
        return BridgeInstallation.class;
    }
}
