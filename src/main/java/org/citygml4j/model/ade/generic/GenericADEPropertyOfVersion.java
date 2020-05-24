package org.citygml4j.model.ade.generic;

import org.citygml4j.model.versioning.ADEOfVersion;
import org.w3c.dom.Element;

public class GenericADEPropertyOfVersion extends ADEOfVersion<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfVersion(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfVersion of(Element value) {
        return new GenericADEPropertyOfVersion(value);
    }
}
