package org.citygml4j.model.ade.generic;

import org.citygml4j.model.versioning.ADEOfVersionTransition;
import org.w3c.dom.Element;

public class GenericADEOfVersionTransition extends ADEOfVersionTransition implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfVersionTransition() {
    }

    public GenericADEOfVersionTransition(Element value) {
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
