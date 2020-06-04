package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractPointCloud;
import org.w3c.dom.Element;

public class GenericADEOfAbstractPointCloud extends ADEOfAbstractPointCloud implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractPointCloud(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractPointCloud of(Element value) {
        return new GenericADEOfAbstractPointCloud(value);
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
