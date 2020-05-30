package org.citygml4j.model.ade.generic;

import org.citygml4j.model.pointcloud.ADEOfPointCloud;
import org.w3c.dom.Element;

public class GenericADEOfPointCloud extends ADEOfPointCloud implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfPointCloud() {
    }

    public GenericADEOfPointCloud(Element value) {
        this.value = value;
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
