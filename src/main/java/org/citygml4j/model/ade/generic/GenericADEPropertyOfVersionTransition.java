package org.citygml4j.model.ade.generic;

import org.citygml4j.model.versioning.ADEPropertyOfVersionTransition;
import org.w3c.dom.Element;

public class GenericADEPropertyOfVersionTransition extends ADEPropertyOfVersionTransition<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfVersionTransition(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfVersionTransition of(Element value) {
        return new GenericADEPropertyOfVersionTransition(value);
    }
}
