package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAppearance;
import org.w3c.dom.Element;

public class GenericADEOfAppearance extends ADEOfAppearance implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAppearance(Element value) {
        this.value = value;
    }

    public static GenericADEOfAppearance of(Element value) {
        return new GenericADEOfAppearance(value);
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
