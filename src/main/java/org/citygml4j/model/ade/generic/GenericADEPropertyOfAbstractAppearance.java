package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractAppearance;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractAppearance extends ADEOfAbstractAppearance<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractAppearance(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractAppearance of(Element value) {
        return new GenericADEPropertyOfAbstractAppearance(value);
    }
}
