package org.citygml4j.adapter.xml.pointcloud;

import org.citygml4j.model.pointcloud.PointCloudProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class PointCloudPropertyAdapter extends AbstractFeaturePropertyAdapter<PointCloudProperty> {

    @Override
    public PointCloudProperty createObject(QName name) {
        return new PointCloudProperty();
    }
}
