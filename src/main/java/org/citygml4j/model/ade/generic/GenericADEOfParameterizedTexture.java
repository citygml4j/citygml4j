package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfParameterizedTexture;
import org.w3c.dom.Element;

public class GenericADEOfParameterizedTexture extends ADEOfParameterizedTexture implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfParameterizedTexture() {
    }

    public GenericADEOfParameterizedTexture(Element value) {
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
