package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractDynamizer;
import org.w3c.dom.Element;

public class GenericADEOfAbstractDynamizer extends ADEOfAbstractDynamizer implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractDynamizer() {
    }

    public GenericADEOfAbstractDynamizer(Element value) {
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
