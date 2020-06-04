package org.citygml4j.model.ade.generic;

import org.citygml4j.model.cityfurniture.ADEOfCityFurniture;
import org.w3c.dom.Element;

public class GenericADEOfCityFurniture extends ADEOfCityFurniture implements ADEGenericContainer {
    private Element value;

    private GenericADEOfCityFurniture(Element value) {
        this.value = value;
    }

    public static GenericADEOfCityFurniture of(Element value) {
        return new GenericADEOfCityFurniture(value);
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
