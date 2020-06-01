package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAbstractTexture;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTexture extends ADEOfAbstractTexture implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractTexture(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractTexture of(Element value) {
        return new GenericADEOfAbstractTexture(value);
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
