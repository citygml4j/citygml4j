package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEPropertyOfAppearance;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAppearance extends ADEPropertyOfAppearance<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAppearance(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAppearance of(Element value) {
        return new GenericADEPropertyOfAppearance(value);
    }
}
