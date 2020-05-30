package org.citygml4j.model.ade.generic;

import org.citygml4j.model.landuse.ADEOfLandUse;
import org.w3c.dom.Element;

public class GenericADEOfLandUse extends ADEOfLandUse implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfLandUse() {
    }

    public GenericADEOfLandUse(Element value) {
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
