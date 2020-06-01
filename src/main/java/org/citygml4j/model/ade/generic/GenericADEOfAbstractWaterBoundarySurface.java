package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEOfAbstractWaterBoundarySurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractWaterBoundarySurface extends ADEOfAbstractWaterBoundarySurface implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractWaterBoundarySurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractWaterBoundarySurface of(Element value) {
        return new GenericADEOfAbstractWaterBoundarySurface(value);
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
