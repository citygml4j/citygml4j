package org.citygml4j.model.ade.generic;

import org.citygml4j.model.cityfurniture.ADEOfCityFurniture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCityFurniture extends ADEOfCityFurniture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCityFurniture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCityFurniture of(Element value) {
        return new GenericADEPropertyOfCityFurniture(value);
    }
}
