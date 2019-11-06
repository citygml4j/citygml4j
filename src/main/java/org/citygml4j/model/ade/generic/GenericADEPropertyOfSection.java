package org.citygml4j.model.ade.generic;

import org.citygml4j.model.transportation.ADEPropertyOfSection;
import org.w3c.dom.Element;

public class GenericADEPropertyOfSection extends ADEPropertyOfSection<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfSection(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfSection of(Element value) {
        return new GenericADEPropertyOfSection(value);
    }
}
