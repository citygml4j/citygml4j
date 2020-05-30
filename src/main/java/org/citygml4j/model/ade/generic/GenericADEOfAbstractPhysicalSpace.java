package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractPhysicalSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractPhysicalSpace extends ADEOfAbstractPhysicalSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractPhysicalSpace() {
    }

    public GenericADEOfAbstractPhysicalSpace(Element value) {
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
