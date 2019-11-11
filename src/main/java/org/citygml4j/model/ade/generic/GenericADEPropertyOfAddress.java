package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAddress;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAddress extends ADEPropertyOfAddress<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAddress(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAddress of(Element value) {
        return new GenericADEPropertyOfAddress(value);
    }
}
