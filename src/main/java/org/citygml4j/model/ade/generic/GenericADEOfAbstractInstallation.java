package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfAbstractInstallation;
import org.w3c.dom.Element;

public class GenericADEOfAbstractInstallation extends ADEOfAbstractInstallation implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfAbstractInstallation(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractInstallation of(Element value) {
        return new GenericADEOfAbstractInstallation(value);
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
