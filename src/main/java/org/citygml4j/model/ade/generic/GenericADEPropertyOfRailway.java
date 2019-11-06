package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfRailway;
import org.w3c.dom.Element;

public class GenericADEPropertyOfRailway extends ADEPropertyOfRailway<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfRailway(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfRailway of(Element value) {
        return new GenericADEPropertyOfRailway(value);
    }
}
