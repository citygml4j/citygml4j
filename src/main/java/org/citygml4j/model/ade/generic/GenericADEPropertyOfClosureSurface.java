package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfClosureSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfClosureSurface extends ADEOfClosureSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfClosureSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfClosureSurface of(Element value) {
        return new GenericADEPropertyOfClosureSurface(value);
    }
}
