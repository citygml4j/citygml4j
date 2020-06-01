package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfWaterway;
import org.w3c.dom.Element;

public class GenericADEOfWaterway extends ADEOfWaterway implements ADEGenericPropertyContainer {
    private Element value;

    private GenericADEOfWaterway(Element value) {
        this.value = value;
    }

    public static GenericADEOfWaterway of(Element value) {
        return new GenericADEOfWaterway(value);
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
