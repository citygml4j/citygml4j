package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEOfWaterway;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWaterway extends ADEOfWaterway<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWaterway(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWaterway of(Element value) {
        return new GenericADEPropertyOfWaterway(value);
    }
}
