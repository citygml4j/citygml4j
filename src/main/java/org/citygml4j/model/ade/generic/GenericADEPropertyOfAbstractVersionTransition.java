package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAbstractVersionTransition;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractVersionTransition extends ADEPropertyOfAbstractVersionTransition<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractVersionTransition(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractVersionTransition of(Element value) {
        return new GenericADEPropertyOfAbstractVersionTransition(value);
    }
}
