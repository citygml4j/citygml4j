package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractLogicalSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractLogicalSpace extends ADEOfAbstractLogicalSpace implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractLogicalSpace(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractLogicalSpace of(Element value) {
        return new GenericADEOfAbstractLogicalSpace(value);
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
