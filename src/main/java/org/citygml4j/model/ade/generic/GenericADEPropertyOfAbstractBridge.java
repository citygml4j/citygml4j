package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEOfAbstractBridge;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractBridge extends ADEOfAbstractBridge<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractBridge(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractBridge of(Element value) {
        return new GenericADEPropertyOfAbstractBridge(value);
    }
}
