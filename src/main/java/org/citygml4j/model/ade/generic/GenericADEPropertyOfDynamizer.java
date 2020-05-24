package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfDynamizer;
import org.w3c.dom.Element;

public class GenericADEPropertyOfDynamizer extends ADEOfDynamizer<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfDynamizer(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfDynamizer of(Element value) {
        return new GenericADEPropertyOfDynamizer(value);
    }
}
