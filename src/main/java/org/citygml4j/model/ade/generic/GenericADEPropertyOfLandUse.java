package org.citygml4j.model.ade.generic;

import org.citygml4j.model.landuse.ADEOfLandUse;
import org.w3c.dom.Element;

public class GenericADEPropertyOfLandUse extends ADEOfLandUse<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfLandUse(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfLandUse of(Element value) {
        return new GenericADEPropertyOfLandUse(value);
    }
}
