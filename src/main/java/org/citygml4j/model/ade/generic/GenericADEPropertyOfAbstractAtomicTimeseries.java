package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEPropertyOfAbstractAtomicTimeseries;
import org.w3c.dom.Element;

public class GenericADEPropertyOfAbstractAtomicTimeseries extends ADEPropertyOfAbstractAtomicTimeseries<Element> implements ADEGenericProperty {

    private GenericADEPropertyOfAbstractAtomicTimeseries(Element value) {
        super(value);
    }

    public static GenericADEPropertyOfAbstractAtomicTimeseries of(Element value) {
        return new GenericADEPropertyOfAbstractAtomicTimeseries(value);
    }
}
