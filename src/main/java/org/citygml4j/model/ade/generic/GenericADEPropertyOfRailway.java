package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfRailway;
import org.w3c.dom.Element;

public class GenericADEPropertyOfRailway extends ADEOfRailway<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfRailway(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfRailway of(Element value) {
        return new GenericADEPropertyOfRailway(value);
    }
}
