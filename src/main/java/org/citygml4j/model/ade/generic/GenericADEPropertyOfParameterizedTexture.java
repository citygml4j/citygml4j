package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfParameterizedTexture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfParameterizedTexture extends ADEOfParameterizedTexture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfParameterizedTexture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfParameterizedTexture of(Element value) {
        return new GenericADEPropertyOfParameterizedTexture(value);
    }
}
