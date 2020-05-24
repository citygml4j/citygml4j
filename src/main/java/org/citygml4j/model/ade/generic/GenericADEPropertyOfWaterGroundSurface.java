package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEOfWaterGroundSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWaterGroundSurface extends ADEOfWaterGroundSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWaterGroundSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWaterGroundSurface of(Element value) {
        return new GenericADEPropertyOfWaterGroundSurface(value);
    }
}
