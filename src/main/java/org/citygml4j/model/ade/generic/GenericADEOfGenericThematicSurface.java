package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEOfGenericThematicSurface;
import org.w3c.dom.Element;

public class GenericADEOfGenericThematicSurface extends ADEOfGenericThematicSurface implements ADEGenericContainer {
    private Element value;

    private GenericADEOfGenericThematicSurface(Element value) {
        this.value = value;
    }

    public static GenericADEOfGenericThematicSurface of(Element value) {
        return new GenericADEOfGenericThematicSurface(value);
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
