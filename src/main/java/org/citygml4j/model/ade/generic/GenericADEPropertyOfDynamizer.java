package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEPropertyOfDynamizer;
import org.w3c.dom.Element;

public class GenericADEPropertyOfDynamizer extends ADEPropertyOfDynamizer<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfDynamizer(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfDynamizer of(Element value) {
        return new GenericADEPropertyOfDynamizer(value);
    }
}
