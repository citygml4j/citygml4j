package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfCityModel;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCityModel extends ADEPropertyOfCityModel<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCityModel(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCityModel of(Element value) {
        return new GenericADEPropertyOfCityModel(value);
    }
}
