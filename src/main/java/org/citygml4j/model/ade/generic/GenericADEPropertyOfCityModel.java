package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfCityModel;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCityModel extends ADEOfCityModel<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCityModel(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCityModel of(Element value) {
        return new GenericADEPropertyOfCityModel(value);
    }
}
