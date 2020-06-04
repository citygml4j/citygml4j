package org.citygml4j.model.ade.generic;

import org.citygml4j.model.pointcloud.ADEOfPointCloud;
import org.w3c.dom.Element;

public class GenericADEOfPointCloud extends ADEOfPointCloud implements ADEGenericContainer {
    private Element value;

    private GenericADEOfPointCloud(Element value) {
        this.value = value;
    }

    public static GenericADEOfPointCloud of(Element value) {
        return new GenericADEOfPointCloud(value);
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
