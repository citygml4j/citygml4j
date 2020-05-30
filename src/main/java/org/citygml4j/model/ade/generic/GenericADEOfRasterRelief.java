package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfRasterRelief;
import org.w3c.dom.Element;

public class GenericADEOfRasterRelief extends ADEOfRasterRelief implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfRasterRelief() {
    }

    public GenericADEOfRasterRelief(Element value) {
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
