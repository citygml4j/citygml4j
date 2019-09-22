package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEPropertyOfGeoreferencedTexture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGeoreferencedTexture extends ADEPropertyOfGeoreferencedTexture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGeoreferencedTexture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGeoreferencedTexture of(Element value) {
        return new GenericADEPropertyOfGeoreferencedTexture(value);
    }
}
