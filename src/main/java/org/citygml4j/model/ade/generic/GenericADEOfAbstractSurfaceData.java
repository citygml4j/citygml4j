package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAbstractSurfaceData;
import org.w3c.dom.Element;

public class GenericADEOfAbstractSurfaceData extends ADEOfAbstractSurfaceData implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractSurfaceData() {
    }

    public GenericADEOfAbstractSurfaceData(Element value) {
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
