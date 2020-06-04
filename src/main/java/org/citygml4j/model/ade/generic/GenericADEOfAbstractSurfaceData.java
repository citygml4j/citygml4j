package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAbstractSurfaceData;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSurfaceData extends ADEOfAbstractSurfaceData implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractSurfaceData(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractSurfaceData of(Element value) {
        return new GenericADEOfAbstractSurfaceData(value);
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
