package org.citygml4j.model.ade.generic;

import org.citygml4j.model.bridge.ADEPropertyOfAbstractBridge;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractBridge extends ADEPropertyOfAbstractBridge<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractBridge(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractBridge of(Element value) {
        return new GenericADEPropertyOfAbstractBridge(value);
    }
}
