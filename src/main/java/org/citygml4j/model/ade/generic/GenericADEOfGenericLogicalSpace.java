package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEOfGenericLogicalSpace;
import org.w3c.dom.Element;

public class GenericADEOfGenericLogicalSpace extends ADEOfGenericLogicalSpace implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfGenericLogicalSpace() {
    }

    public GenericADEOfGenericLogicalSpace(Element value) {
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
