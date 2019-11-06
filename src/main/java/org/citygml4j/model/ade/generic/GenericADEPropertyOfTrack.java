package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfTrack;
import org.w3c.dom.Element;

public class GenericADEPropertyOfTrack extends ADEPropertyOfTrack<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfTrack(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfTrack of(Element value) {
        return new GenericADEPropertyOfTrack(value);
    }
}
