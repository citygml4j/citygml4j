package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfX3DMaterial;
import org.w3c.dom.Element;

public class GenericADEOfX3DMaterial extends ADEOfX3DMaterial implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfX3DMaterial() {
    }

    public GenericADEOfX3DMaterial(Element value) {
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
