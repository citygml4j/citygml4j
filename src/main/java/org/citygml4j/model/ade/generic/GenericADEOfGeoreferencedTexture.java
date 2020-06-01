package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfGeoreferencedTexture;
import org.w3c.dom.Element;

public class GenericADEOfGeoreferencedTexture extends ADEOfGeoreferencedTexture implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfGeoreferencedTexture(Element value) {
        this.value = value;
    }

    public static GenericADEOfGeoreferencedTexture of(Element value) {
        return new GenericADEOfGeoreferencedTexture(value);
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
