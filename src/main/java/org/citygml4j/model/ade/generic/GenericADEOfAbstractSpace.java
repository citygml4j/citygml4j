package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSpace extends ADEOfAbstractSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractSpace() {
    }

    public GenericADEOfAbstractSpace(Element value) {
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
