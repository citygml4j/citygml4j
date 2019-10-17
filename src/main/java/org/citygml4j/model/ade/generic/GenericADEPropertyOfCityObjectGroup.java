package org.citygml4j.model.ade.generic;

import org.citygml4j.model.cityobjectgroup.ADEPropertyOfCityObjectGroup;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCityObjectGroup extends ADEPropertyOfCityObjectGroup<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCityObjectGroup(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCityObjectGroup of(Element value) {
        return new GenericADEPropertyOfCityObjectGroup(value);
    }
}
