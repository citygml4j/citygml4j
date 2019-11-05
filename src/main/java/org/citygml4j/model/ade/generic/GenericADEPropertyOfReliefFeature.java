package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEPropertyOfReliefFeature;
import org.w3c.dom.Element;

public class GenericADEPropertyOfReliefFeature extends ADEPropertyOfReliefFeature<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfReliefFeature(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfReliefFeature of(Element value) {
        return new GenericADEPropertyOfReliefFeature(value);
    }
}
