package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAppearance;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAppearance extends ADEOfAppearance<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAppearance(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAppearance of(Element value) {
        return new GenericADEPropertyOfAppearance(value);
    }
}
