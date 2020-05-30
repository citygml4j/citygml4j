package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfStorey;
import org.w3c.dom.Element;

public class GenericADEOfStorey extends ADEOfStorey implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfStorey() {
    }

    public GenericADEOfStorey(Element value) {
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
