package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractAppearance;
import org.w3c.dom.Element;

public class GenericADEOfAbstractAppearance extends ADEOfAbstractAppearance implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractAppearance() {
    }

    public GenericADEOfAbstractAppearance(Element value) {
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
