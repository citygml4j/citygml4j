package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfHollowSpace;
import org.w3c.dom.Element;

public class GenericADEOfHollowSpace extends ADEOfHollowSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfHollowSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfHollowSpace of(Element value) {
        return new GenericADEOfHollowSpace(value);
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
