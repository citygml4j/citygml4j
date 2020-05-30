package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfImplicitGeometry;
import org.w3c.dom.Element;

public class GenericADEOfImplicitGeometry extends ADEOfImplicitGeometry implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfImplicitGeometry() {
    }

    public GenericADEOfImplicitGeometry(Element value) {
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
