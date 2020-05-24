package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfX3DMaterial;
import org.w3c.dom.Element;

public class GenericADEPropertyOfX3DMaterial extends ADEOfX3DMaterial<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfX3DMaterial(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfX3DMaterial of(Element value) {
        return new GenericADEPropertyOfX3DMaterial(value);
    }
}
