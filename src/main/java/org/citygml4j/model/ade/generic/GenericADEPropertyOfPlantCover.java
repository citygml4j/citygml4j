package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEPropertyOfPlantCover;
import org.w3c.dom.Element;

public class GenericADEPropertyOfPlantCover extends ADEPropertyOfPlantCover<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfPlantCover(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfPlantCover of(Element value) {
        return new GenericADEPropertyOfPlantCover(value);
    }
}
