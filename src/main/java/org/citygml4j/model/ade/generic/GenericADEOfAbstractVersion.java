package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractVersion;
import org.w3c.dom.Element;

public class GenericADEOfAbstractVersion extends ADEOfAbstractVersion implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfAbstractVersion() {
    }

    public GenericADEOfAbstractVersion(Element value) {
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
