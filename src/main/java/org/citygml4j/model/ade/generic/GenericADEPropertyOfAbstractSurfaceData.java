package org.citygml4j.model.ade.generic;

import org.citygml4j.model.appearance.ADEOfAbstractSurfaceData;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractSurfaceData extends ADEOfAbstractSurfaceData<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractSurfaceData(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractSurfaceData of(Element value) {
        return new GenericADEPropertyOfAbstractSurfaceData(value);
    }
}
