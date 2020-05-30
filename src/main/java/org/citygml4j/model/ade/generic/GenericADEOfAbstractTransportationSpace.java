package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfAbstractTransportationSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTransportationSpace extends ADEOfAbstractTransportationSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractTransportationSpace() {
    }

    public GenericADEOfAbstractTransportationSpace(Element value) {
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
