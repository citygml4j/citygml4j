package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAppearance;
import org.w3c.dom.Element;

public class GenericADEOfAppearance extends ADEOfAppearance implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAppearance() {
    }

    public GenericADEOfAppearance(Element value) {
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
