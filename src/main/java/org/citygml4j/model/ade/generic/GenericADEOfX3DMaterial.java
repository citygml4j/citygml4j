package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfX3DMaterial;
import org.w3c.dom.Element;

public class GenericADEOfX3DMaterial extends ADEOfX3DMaterial implements ADEGenericContainer {
    private Element value;

    private GenericADEOfX3DMaterial(Element value) {
        this.value = value;
    }

    public static GenericADEOfX3DMaterial of(Element value) {
        return new GenericADEOfX3DMaterial(value);
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
