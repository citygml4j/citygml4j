package org.citygml4j.model.ade.generic;

import org.citygml4j.model.construction.ADEPropertyOfWindow;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWindow extends ADEPropertyOfWindow<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWindow(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWindow of(Element value) {
        return new GenericADEPropertyOfWindow(value);
    }
}
