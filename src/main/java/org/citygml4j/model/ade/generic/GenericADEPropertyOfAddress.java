package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAddress;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAddress extends ADEOfAddress<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAddress(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAddress of(Element value) {
        return new GenericADEPropertyOfAddress(value);
    }
}
