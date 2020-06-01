package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfSection;
import org.w3c.dom.Element;

public class GenericADEOfSection extends ADEOfSection implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfSection(Element value) {
        this.value = value;
    }

    public static GenericADEOfSection of(Element value) {
        return new GenericADEOfSection(value);
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
