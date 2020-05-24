package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEOfPlantCover;
import org.w3c.dom.Element;

public class GenericADEPropertyOfPlantCover extends ADEOfPlantCover<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfPlantCover(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfPlantCover of(Element value) {
        return new GenericADEPropertyOfPlantCover(value);
    }
}
