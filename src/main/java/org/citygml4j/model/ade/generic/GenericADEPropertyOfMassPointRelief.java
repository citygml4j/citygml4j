package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEPropertyOfMassPointRelief;
import org.w3c.dom.Element;

public class GenericADEPropertyOfMassPointRelief extends ADEPropertyOfMassPointRelief<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfMassPointRelief(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfMassPointRelief of(Element value) {
        return new GenericADEPropertyOfMassPointRelief(value);
    }
}
