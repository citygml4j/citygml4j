package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfImplicitGeometry;
import org.w3c.dom.Element;

public class GenericADEPropertyOfImplicitGeometry extends ADEOfImplicitGeometry<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfImplicitGeometry(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfImplicitGeometry of(Element value) {
        return new GenericADEPropertyOfImplicitGeometry(value);
    }
}
