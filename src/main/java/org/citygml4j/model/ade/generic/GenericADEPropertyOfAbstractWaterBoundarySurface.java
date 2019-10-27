package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEPropertyOfAbstractWaterBoundarySurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractWaterBoundarySurface extends ADEPropertyOfAbstractWaterBoundarySurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractWaterBoundarySurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractWaterBoundarySurface of(Element value) {
        return new GenericADEPropertyOfAbstractWaterBoundarySurface(value);
    }
}
