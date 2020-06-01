package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfStorey;
import org.w3c.dom.Element;

public class GenericADEOfStorey extends ADEOfStorey implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfStorey(Element value) {
        this.value = value;
    }

    public static GenericADEOfStorey of(Element value) {
        return new GenericADEOfStorey(value);
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
