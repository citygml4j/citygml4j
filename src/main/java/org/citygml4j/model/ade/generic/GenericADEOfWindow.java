package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWindow;
import org.w3c.dom.Element;

public class GenericADEOfWindow extends ADEOfWindow implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfWindow() {
    }

    public GenericADEOfWindow(Element value) {
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
