package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfReliefFeature;
import org.w3c.dom.Element;

public class GenericADEOfReliefFeature extends ADEOfReliefFeature implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfReliefFeature() {
    }

    public GenericADEOfReliefFeature(Element value) {
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
