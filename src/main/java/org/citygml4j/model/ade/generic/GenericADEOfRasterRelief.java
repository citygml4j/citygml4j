package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfRasterRelief;
import org.w3c.dom.Element;

public class GenericADEOfRasterRelief extends ADEOfRasterRelief implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfRasterRelief(Element value) {
        this.value = value;
    }

    public static GenericADEOfRasterRelief of(Element value) {
        return new GenericADEOfRasterRelief(value);
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
