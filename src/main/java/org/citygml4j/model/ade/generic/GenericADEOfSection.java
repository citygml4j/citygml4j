package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfSection;
import org.w3c.dom.Element;

public class GenericADEOfSection extends ADEOfSection implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfSection() {
    }

    public GenericADEOfSection(Element value) {
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
