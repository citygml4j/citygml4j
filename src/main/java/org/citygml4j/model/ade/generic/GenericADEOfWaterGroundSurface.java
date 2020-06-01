package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEOfWaterGroundSurface;
import org.w3c.dom.Element;

public class GenericADEOfWaterGroundSurface extends ADEOfWaterGroundSurface implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfWaterGroundSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfWaterGroundSurface of(Element value) {
        return new GenericADEOfWaterGroundSurface(value);
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
