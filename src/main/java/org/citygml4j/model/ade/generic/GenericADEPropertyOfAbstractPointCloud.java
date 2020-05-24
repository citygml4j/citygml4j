package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractPointCloud;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractPointCloud extends ADEOfAbstractPointCloud<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractPointCloud(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractPointCloud of(Element value) {
        return new GenericADEPropertyOfAbstractPointCloud(value);
    }
}
