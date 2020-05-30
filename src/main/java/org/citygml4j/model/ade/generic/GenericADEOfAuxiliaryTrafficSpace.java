package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfAuxiliaryTrafficSpace;
import org.w3c.dom.Element;

public class GenericADEOfAuxiliaryTrafficSpace extends ADEOfAuxiliaryTrafficSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAuxiliaryTrafficSpace() {
    }

    public GenericADEOfAuxiliaryTrafficSpace(Element value) {
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
