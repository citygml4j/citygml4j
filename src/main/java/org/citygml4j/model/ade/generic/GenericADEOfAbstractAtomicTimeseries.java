package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfAbstractAtomicTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfAbstractAtomicTimeseries extends ADEOfAbstractAtomicTimeseries implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractAtomicTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractAtomicTimeseries of(Element value) {
        return new GenericADEOfAbstractAtomicTimeseries(value);
    }

    @Override
    public Element getValue() {
        return value;
    }

    @Override
    public void setValue(Element value) {
        this.value = value;
    }
}
