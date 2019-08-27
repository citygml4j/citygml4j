package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfImplicitGeometry;
import org.w3c.dom.Element;

public class GenericADEPropertyOfImplicitGeometry extends ADEPropertyOfImplicitGeometry<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfImplicitGeometry(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfImplicitGeometry of(Element value) {
        return new GenericADEPropertyOfImplicitGeometry(value);
    }
}
