package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfBreaklineRelief;
import org.w3c.dom.Element;

public class GenericADEOfBreaklineRelief extends ADEOfBreaklineRelief implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfBreaklineRelief() {
    }

    public GenericADEOfBreaklineRelief(Element value) {
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
