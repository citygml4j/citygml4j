package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractVersionTransition;
import org.w3c.dom.Element;

public class GenericADEOfAbstractVersionTransition extends ADEOfAbstractVersionTransition implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractVersionTransition(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractVersionTransition of(Element value) {
        return new GenericADEOfAbstractVersionTransition(value);
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
