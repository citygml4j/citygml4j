package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfMassPointRelief;
import org.w3c.dom.Element;

public class GenericADEOfMassPointRelief extends ADEOfMassPointRelief implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfMassPointRelief() {
    }

    public GenericADEOfMassPointRelief(Element value) {
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
