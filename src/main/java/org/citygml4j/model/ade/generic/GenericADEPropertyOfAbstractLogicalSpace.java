package org.citygml4j.model.ade.generic;

import org.citygml4j.model.core.ADEOfAbstractLogicalSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractLogicalSpace extends ADEOfAbstractLogicalSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractLogicalSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractLogicalSpace of(Element value) {
        return new GenericADEPropertyOfAbstractLogicalSpace(value);
    }
}
