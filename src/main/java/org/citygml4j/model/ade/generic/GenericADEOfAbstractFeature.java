package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractFeature;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFeature extends ADEOfAbstractFeature implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractFeature() {
    }

    public GenericADEOfAbstractFeature(Element value) {
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
