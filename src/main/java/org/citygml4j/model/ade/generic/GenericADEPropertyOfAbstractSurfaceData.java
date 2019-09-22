package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEPropertyOfAbstractSurfaceData;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractSurfaceData extends ADEPropertyOfAbstractSurfaceData<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractSurfaceData(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractSurfaceData of(Element value) {
        return new GenericADEPropertyOfAbstractSurfaceData(value);
    }
}
