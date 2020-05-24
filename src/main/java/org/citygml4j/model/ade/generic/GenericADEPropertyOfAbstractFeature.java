package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractFeature;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractFeature extends ADEOfAbstractFeature<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractFeature(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractFeature of(Element value) {
        return new GenericADEPropertyOfAbstractFeature(value);
    }
}
