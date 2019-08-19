package org.citygml4j.model.pointcloud;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class PointCloudProperty extends FeatureProperty<PointCloud> implements CityGMLObject {

    public PointCloudProperty() {
    }

    public PointCloudProperty(PointCloud object) {
        super(object);
    }

    public PointCloudProperty(String href) {
        super(href);
    }

    @Override
    public Class<PointCloud> getTargetType() {
        return PointCloud.class;
    }
}
