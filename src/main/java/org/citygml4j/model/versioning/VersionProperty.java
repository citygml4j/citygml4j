package org.citygml4j.model.versioning;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class VersionProperty extends FeatureProperty<Version> implements CityGMLObject {

    public VersionProperty() {
    }

    public VersionProperty(Version object) {
        super(object);
    }

    public VersionProperty(String href) {
        super(href);
    }

    @Override
    public Class<Version> getTargetType() {
        return Version.class;
    }
}
