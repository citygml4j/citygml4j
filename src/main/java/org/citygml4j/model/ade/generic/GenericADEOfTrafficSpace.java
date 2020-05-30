package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfTrafficSpace;
import org.w3c.dom.Element;

public class GenericADEOfTrafficSpace extends ADEOfTrafficSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfTrafficSpace() {
    }

    public GenericADEOfTrafficSpace(Element value) {
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
