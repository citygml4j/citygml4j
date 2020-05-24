package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfMassPointRelief;
import org.w3c.dom.Element;

public class GenericADEPropertyOfMassPointRelief extends ADEOfMassPointRelief<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfMassPointRelief(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfMassPointRelief of(Element value) {
        return new GenericADEPropertyOfMassPointRelief(value);
    }
}
