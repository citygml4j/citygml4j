package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAbstractTexture;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTexture extends ADEOfAbstractTexture implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractTexture() {
    }

    public GenericADEOfAbstractTexture(Element value) {
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
