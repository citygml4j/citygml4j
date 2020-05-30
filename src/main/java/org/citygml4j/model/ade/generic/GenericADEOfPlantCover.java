package org.citygml4j.model.ade.generic;

import org.citygml4j.model.vegetation.ADEOfPlantCover;
import org.w3c.dom.Element;

public class GenericADEOfPlantCover extends ADEOfPlantCover implements ADEGenericPropertyContainer {
    private Element value;

    public GenericADEOfPlantCover() {
    }

    public GenericADEOfPlantCover(Element value) {
        this.value = value;
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
