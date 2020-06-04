package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfTrack;
import org.w3c.dom.Element;

public class GenericADEOfTrack extends ADEOfTrack implements ADEGenericContainer {
    private Element value;

    private GenericADEOfTrack(Element value) {
        this.value = value;
    }

    public static GenericADEOfTrack of(Element value) {
        return new GenericADEOfTrack(value);
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
