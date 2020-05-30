package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfDynamizer;
import org.w3c.dom.Element;

public class GenericADEOfDynamizer extends ADEOfDynamizer implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfDynamizer() {
    }

    public GenericADEOfDynamizer(Element value) {
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
