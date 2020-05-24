package org.citygml4j.model.ade.generic;

import org.citygml4j.model.generics.ADEOfGenericLogicalSpace;
import org.w3c.dom.Element;

public class GenericADEPropertyOfGenericLogicalSpace extends ADEOfGenericLogicalSpace<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfGenericLogicalSpace(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfGenericLogicalSpace of(Element value) {
        return new GenericADEPropertyOfGenericLogicalSpace(value);
    }
}
