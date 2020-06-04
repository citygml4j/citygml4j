package org.citygml4j.model.ade.generic;

import org.citygml4j.model.dynamizer.ADEOfAbstractTimeseries;
import org.w3c.dom.Element;

public class GenericADEOfAbstractTimeseries extends ADEOfAbstractTimeseries implements ADEGenericContainer {
    private Element value;

    private GenericADEOfAbstractTimeseries(Element value) {
        this.value = value;
    }

    public static GenericADEOfAbstractTimeseries of(Element value) {
        return new GenericADEOfAbstractTimeseries(value);
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
