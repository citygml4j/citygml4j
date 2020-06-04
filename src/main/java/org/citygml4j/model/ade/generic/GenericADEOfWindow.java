package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWindow;
import org.w3c.dom.Element;

public class GenericADEOfWindow extends ADEOfWindow implements ADEGenericContainer {
    private Element value;

    private GenericADEOfWindow(Element value) {
        this.value = value;
    }

    public static GenericADEOfWindow of(Element value) {
        return new GenericADEOfWindow(value);
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
