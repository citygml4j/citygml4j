package org.citygml4j.model.ade.generic;

import org.citygml4j.model.versioning.ADEOfVersion;
import org.w3c.dom.Element;

public class GenericADEOfVersion extends ADEOfVersion implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfVersion(Element value) {
        this.value = value;
    }

    public static GenericADEOfVersion of(Element value) {
        return new GenericADEOfVersion(value);
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
