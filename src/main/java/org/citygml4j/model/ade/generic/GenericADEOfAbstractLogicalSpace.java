package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractLogicalSpace;
import org.w3c.dom.Element;

public class GenericADEOfAbstractLogicalSpace extends ADEOfAbstractLogicalSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractLogicalSpace() {
    }

    public GenericADEOfAbstractLogicalSpace(Element value) {
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
