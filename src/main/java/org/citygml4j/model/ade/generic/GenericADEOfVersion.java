package org.citygml4j.model.ade.generic;

import org.citygml4j.model.versioning.ADEOfVersion;
import org.w3c.dom.Element;

public class GenericADEOfVersion extends ADEOfVersion implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfVersion() {
    }

    public GenericADEOfVersion(Element value) {
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
