package org.citygml4j.model.ade.generic;

import org.citygml4j.model.cityfurniture.ADEPropertyOfCityFurniture;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCityFurniture extends ADEPropertyOfCityFurniture<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCityFurniture(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCityFurniture of(Element value) {
        return new GenericADEPropertyOfCityFurniture(value);
    }
}
