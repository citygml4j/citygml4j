package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractPointCloud;
import org.w3c.dom.Element;

public class GenericADEOfAbstractPointCloud extends ADEOfAbstractPointCloud implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractPointCloud() {
    }

    public GenericADEOfAbstractPointCloud(Element value) {
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
