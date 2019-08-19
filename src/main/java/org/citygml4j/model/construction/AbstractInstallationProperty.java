package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractInstallationProperty extends FeatureProperty<AbstractInstallation> implements CityGMLObject {

    public AbstractInstallationProperty() {
    }

    public AbstractInstallationProperty(AbstractInstallation object) {
        super(object);
    }

    public AbstractInstallationProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractInstallation> getTargetType() {
        return AbstractInstallation.class;
    }
}
