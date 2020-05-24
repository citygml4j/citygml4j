package org.citygml4j.model.ade.generic;

import org.citygml4j.model.cityobjectgroup.ADEOfCityObjectGroup;
import org.w3c.dom.Element;

public class GenericADEPropertyOfCityObjectGroup extends ADEOfCityObjectGroup<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfCityObjectGroup(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfCityObjectGroup of(Element value) {
        return new GenericADEPropertyOfCityObjectGroup(value);
    }
}
