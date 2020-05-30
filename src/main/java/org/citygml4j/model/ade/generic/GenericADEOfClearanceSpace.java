package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfClearanceSpace;
import org.w3c.dom.Element;

public class GenericADEOfClearanceSpace extends ADEOfClearanceSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfClearanceSpace() {
    }

    public GenericADEOfClearanceSpace(Element value) {
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
