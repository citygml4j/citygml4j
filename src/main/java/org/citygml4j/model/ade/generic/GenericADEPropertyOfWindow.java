package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEOfWindow;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWindow extends ADEOfWindow<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWindow(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWindow of(Element value) {
        return new GenericADEPropertyOfWindow(value);
    }
}
