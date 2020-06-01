package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractFillingElement;
import org.w3c.dom.Element;

public class GenericADEOfAbstractFillingElement extends ADEOfAbstractFillingElement implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractFillingElement(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractFillingElement of(Element value) {
        return new GenericADEOfAbstractFillingElement(value);
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
