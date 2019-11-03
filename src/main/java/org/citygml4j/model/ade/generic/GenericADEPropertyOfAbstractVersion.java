package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAbstractVersion;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractVersion extends ADEPropertyOfAbstractVersion<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractVersion(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractVersion of(Element value) {
        return new GenericADEPropertyOfAbstractVersion(value);
    }
}
