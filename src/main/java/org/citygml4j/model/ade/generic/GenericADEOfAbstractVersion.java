package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractVersion;
import org.w3c.dom.Element;

public class GenericADEOfAbstractVersion extends ADEOfAbstractVersion implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractVersion(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractVersion of(Element value) {
        return new GenericADEOfAbstractVersion(value);
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
