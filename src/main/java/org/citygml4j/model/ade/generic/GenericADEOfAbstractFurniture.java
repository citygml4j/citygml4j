package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractFurniture;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFurniture extends ADEOfAbstractFurniture implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractFurniture of(Element value) {
        return new GenericADEOfAbstractFurniture(value);
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
