package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractVersionTransition;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractVersionTransition extends ADEOfAbstractVersionTransition<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractVersionTransition(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractVersionTransition of(Element value) {
        return new GenericADEPropertyOfAbstractVersionTransition(value);
    }
}
