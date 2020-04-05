package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class PointCloudModule extends CityGMLModule {
    public static final PointCloudModule v3_0;

    private PointCloudModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new PointCloudModule(
                CityGMLConstants.CITYGML_3_0_POINTCLOUD_NAMESPACE,
                "pnt",
                "http://schemas.opengis.net/citygml/pointcloud/3.0/pointCloud.xsd",
                CityGMLVersion.v3_0
        );
    }

    public static PointCloudModule of(CityGMLVersion version) {
        return version == CityGMLVersion.v3_0 ? v3_0 : null;
    }
}
