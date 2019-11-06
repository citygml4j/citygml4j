package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfRoad;
import org.w3c.dom.Element;

public class GenericADEPropertyOfRoad extends ADEPropertyOfRoad<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfRoad(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfRoad of(Element value) {
        return new GenericADEPropertyOfRoad(value);
    }
}
