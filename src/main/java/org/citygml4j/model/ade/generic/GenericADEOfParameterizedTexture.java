package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfParameterizedTexture;
import org.w3c.dom.Element;

public class GenericADEOfParameterizedTexture extends ADEOfParameterizedTexture implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfParameterizedTexture(Element value) {
        this.value = value;
    }

    public static GenericADEOfParameterizedTexture of(Element value) {
        return new GenericADEOfParameterizedTexture(value);
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
