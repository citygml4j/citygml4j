package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEPropertyOfAbstractTexture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractTexture extends ADEPropertyOfAbstractTexture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractTexture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractTexture of(Element value) {
        return new GenericADEPropertyOfAbstractTexture(value);
    }
}
