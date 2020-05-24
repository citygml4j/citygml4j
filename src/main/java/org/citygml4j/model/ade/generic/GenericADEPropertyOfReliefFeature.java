package org.citygml4j.model.ade.generic;

import org.citygml4j.model.relief.ADEOfReliefFeature;
import org.w3c.dom.Element;

public class GenericADEPropertyOfReliefFeature extends ADEOfReliefFeature<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfReliefFeature(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfReliefFeature of(Element value) {
        return new GenericADEPropertyOfReliefFeature(value);
    }
}
