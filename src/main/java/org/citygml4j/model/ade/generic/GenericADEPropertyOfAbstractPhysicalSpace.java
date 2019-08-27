package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEPropertyOfAbstractPhysicalSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractPhysicalSpace extends ADEPropertyOfAbstractPhysicalSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractPhysicalSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractPhysicalSpace of(Element value) {
        return new GenericADEPropertyOfAbstractPhysicalSpace(value);
    }
}
