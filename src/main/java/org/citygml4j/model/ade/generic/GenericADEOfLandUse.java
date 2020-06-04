package org.citygml4j.model.ade.generic;

import org.citygml4j.model.landuse.ADEOfLandUse;
import org.w3c.dom.Element;

public class GenericADEOfLandUse extends ADEOfLandUse implements ADEGenericContainer {
    private Element value;

    private GenericADEOfLandUse(Element value) {
        this.value = value;
    }

    public static GenericADEOfLandUse of(Element value) {
        return new GenericADEOfLandUse(value);
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
