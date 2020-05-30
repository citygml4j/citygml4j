package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfClosureSurface;
import org.w3c.dom.Element;

public class GenericADEOfClosureSurface extends ADEOfClosureSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfClosureSurface() {
    }

    public GenericADEOfClosureSurface(Element value) {
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
