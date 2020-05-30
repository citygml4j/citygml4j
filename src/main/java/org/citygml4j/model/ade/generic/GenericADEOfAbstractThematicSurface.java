package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractThematicSurface;
import org.w3c.dom.Element;

public class GenericADEOfAbstractThematicSurface extends ADEOfAbstractThematicSurface implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractThematicSurface() {
    }

    public GenericADEOfAbstractThematicSurface(Element value) {
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
