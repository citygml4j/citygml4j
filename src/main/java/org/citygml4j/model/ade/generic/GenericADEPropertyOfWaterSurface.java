package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEPropertyOfWaterSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWaterSurface extends ADEPropertyOfWaterSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWaterSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWaterSurface of(Element value) {
        return new GenericADEPropertyOfWaterSurface(value);
    }
}
