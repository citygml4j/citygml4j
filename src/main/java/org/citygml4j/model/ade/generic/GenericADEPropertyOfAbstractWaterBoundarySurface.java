package org.citygml4j.model.ade.generic;

import org.citygml4j.model.waterbody.ADEOfAbstractWaterBoundarySurface;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractWaterBoundarySurface extends ADEOfAbstractWaterBoundarySurface<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractWaterBoundarySurface(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractWaterBoundarySurface of(Element value) {
        return new GenericADEPropertyOfAbstractWaterBoundarySurface(value);
    }
}
