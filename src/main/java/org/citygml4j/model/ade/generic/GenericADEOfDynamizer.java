package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfDynamizer;
import org.w3c.dom.Element;

public class GenericADEOfDynamizer extends ADEOfDynamizer implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfDynamizer(Element value) {
        this.value = value;
    }

    public static GenericADEOfDynamizer of(Element value) {
        return new GenericADEOfDynamizer(value);
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
