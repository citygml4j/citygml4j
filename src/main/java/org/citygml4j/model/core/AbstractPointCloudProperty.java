package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractPointCloudProperty extends FeatureProperty<AbstractPointCloud> implements CityGMLObject {

    public AbstractPointCloudProperty() {
    }

    public AbstractPointCloudProperty(AbstractPointCloud object) {
        super(object);
    }

    public AbstractPointCloudProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractPointCloud> getTargetType() {
        return AbstractPointCloud.class;
    }
}
