package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAbstractCityObject;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractCityObject extends ADEPropertyOfAbstractCityObject<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractCityObject(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractCityObject of(Element value) {
        return new GenericADEPropertyOfAbstractCityObject(value);
    }
}
