package org.citygml4j.model.ade.generic;

import org.citygml4j.model.building.ADEOfStorey;
import org.w3c.dom.Element;

public class GenericADEPropertyOfStorey extends ADEOfStorey<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfStorey(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfStorey of(Element value) {
        return new GenericADEPropertyOfStorey(value);
    }
}
