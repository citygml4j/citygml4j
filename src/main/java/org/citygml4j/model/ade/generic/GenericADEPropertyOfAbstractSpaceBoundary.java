package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractSpaceBoundary;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractSpaceBoundary extends ADEOfAbstractSpaceBoundary<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractSpaceBoundary(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractSpaceBoundary of(Element value) {
        return new GenericADEPropertyOfAbstractSpaceBoundary(value);
    }
}
