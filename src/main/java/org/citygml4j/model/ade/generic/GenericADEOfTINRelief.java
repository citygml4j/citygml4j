package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfTINRelief;
import org.w3c.dom.Element;

public class GenericADEOfTINRelief extends ADEOfTINRelief implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfTINRelief() {
    }

    public GenericADEOfTINRelief(Element value) {
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
