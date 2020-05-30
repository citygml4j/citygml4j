package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEOfWaterBody;
import org.w3c.dom.Element;

public class GenericADEOfWaterBody extends ADEOfWaterBody implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfWaterBody() {
    }

    public GenericADEOfWaterBody(Element value) {
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
