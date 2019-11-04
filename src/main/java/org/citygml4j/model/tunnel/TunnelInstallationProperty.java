package org.citygml4j.model.tunnel;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class TunnelInstallationProperty extends FeatureProperty<TunnelInstallation> implements CityGMLObject {

    public TunnelInstallationProperty() {
    }

    public TunnelInstallationProperty(TunnelInstallation object) {
        super(object);
    }

    public TunnelInstallationProperty(String href) {
        super(href);
    }

    @Override
    public Class<TunnelInstallation> getTargetType() {
        return TunnelInstallation.class;
    }
}
