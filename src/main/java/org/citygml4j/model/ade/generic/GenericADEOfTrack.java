package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfTrack;
import org.w3c.dom.Element;

public class GenericADEOfTrack extends ADEOfTrack implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfTrack() {
    }

    public GenericADEOfTrack(Element value) {
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
