package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEPropertyOfWaterClosureSurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfWaterClosureSurface extends ADEPropertyOfWaterClosureSurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfWaterClosureSurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfWaterClosureSurface of(Element value) {
        return new GenericADEPropertyOfWaterClosureSurface(value);
    }
}
