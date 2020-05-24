package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractPhysicalSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractPhysicalSpace extends ADEOfAbstractPhysicalSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractPhysicalSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractPhysicalSpace of(Element value) {
        return new GenericADEPropertyOfAbstractPhysicalSpace(value);
    }
}
