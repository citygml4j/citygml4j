package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEPropertyOfParameterizedTexture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfParameterizedTexture extends ADEPropertyOfParameterizedTexture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfParameterizedTexture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfParameterizedTexture of(Element value) {
        return new GenericADEPropertyOfParameterizedTexture(value);
    }
}
