package org.citygml4j.model.ade.generic;

import org.citygml4j.model.tunnel.ADEOfHollowSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfHollowSpace extends ADEOfHollowSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfHollowSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfHollowSpace of(Element value) {
        return new GenericADEPropertyOfHollowSpace(value);
    }
}
